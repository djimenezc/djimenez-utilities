/**
 * Created on 2007-4-14 00:54:50
 */
package com.sun.identity.openid;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openid4java.OpenIDException;
import org.openid4java.association.AssociationSessionType;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.InMemoryConsumerAssociationStore;
import org.openid4java.consumer.InMemoryNonceVerifier;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.MessageException;
import org.openid4java.message.MessageExtension;
import org.openid4java.message.ParameterList;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;
import org.openid4java.message.sreg.SRegMessage;
import org.openid4java.message.sreg.SRegRequest;
import org.openid4java.message.sreg.SRegResponse;
import org.openid4java.util.HttpClientFactory;
import org.openid4java.util.ProxyProperties;

/**
 * @author Sutra Zhou
 */
public class OpenidConsumerServlet extends javax.servlet.http.HttpServlet {

  /**
	 *
	 */
  private static final long serialVersionUID = -5998885243419513055L;
  private static final String OPTIONAL_VALUE = "0";
  private static final String REQUIRED_VALUE = "1";
  private static final Log LOG = LogFactory.getLog(OpenidConsumerServlet.class);

  /**
   * Get proxy properties from the context init params.
   * 
   * @return proxy properties
   */
  private static ProxyProperties getProxyProperties(final ServletConfig config) {
    ProxyProperties proxyProps;
    final String host = config.getInitParameter("proxy.host");
    LOG.debug("proxy.host: " + host);
    if (host == null) {
      proxyProps = null;
    }
    else {
      proxyProps = new ProxyProperties();
      final String port = config.getInitParameter("proxy.port");
      final String username = config.getInitParameter("proxy.username");
      final String password = config.getInitParameter("proxy.password");
      final String domain = config.getInitParameter("proxy.domain");
      proxyProps.setProxyHostName(host);
      proxyProps.setProxyPort(Integer.parseInt(port));
      proxyProps.setUserName(username);
      proxyProps.setPassword(password);
      proxyProps.setDomain(domain);
    }
    return proxyProps;
  }

  private ServletContext context;

  private ConsumerManager manager;

  /**
   * Attribute exchange example.
   * 
   * @param httpReq
   * @param authReq
   * @throws MessageException
   * @see <a
   *      href="http://code.google.com/p/openid4java/wiki/AttributeExchangeHowTo">Attribute
   *      Exchange HowTo</a>
   * @see <a
   *      href="http://openid.net/specs/openid-attribute-exchange-1_0.html">OpenID
   *      Attribute Exchange 1.0 - Final</a>
   */
  private void addAttributeExchangeToAuthRequest(
    final HttpServletRequest httpReq, final AuthRequest authReq)
    throws MessageException {
    final String[] aliases = httpReq.getParameterValues("alias");
    final String[] typeUris = httpReq.getParameterValues("typeUri");
    final String[] counts = httpReq.getParameterValues("count");
    final FetchRequest fetch = FetchRequest.createFetchRequest();
    for (int i = 0, l = typeUris == null ? 0 : typeUris.length; i < l; i++) {
      final String typeUri = typeUris[i];
      if (StringUtils.isNotBlank(typeUri)) {
        final String alias = aliases[i];
        final boolean required = httpReq.getParameter("required" + i) != null;
        final int count = NumberUtils.toInt(counts[i], 1);
        fetch.addAttribute(alias, typeUri, required, count);
      }
    }
    authReq.addExtension(fetch);
  }

  /**
   * Simple Registration Extension example.
   * 
   * @param httpReq
   * @param authReq
   * @throws MessageException
   * @see <a href="http://code.google.com/p/openid4java/wiki/SRegHowTo">Simple
   *      Registration HowTo</a>
   * @see <a
   *      href="http://openid.net/specs/openid-simple-registration-extension-1_0.html">OpenID
   *      Simple Registration Extension 1.0</a>
   */
  private void addSimpleRegistrationToAuthRequest(
    final HttpServletRequest httpReq, final AuthRequest authReq)
    throws MessageException {
    // Attribute Exchange example: fetching the 'email' attribute
    // FetchRequest fetch = FetchRequest.createFetchRequest();
    final SRegRequest sregReq = SRegRequest.createFetchRequest();

    final String[] attributes =
      { "nickname", "email", "fullname", "dob", "gender", "postcode",
        "country", "language", "timezone" };
    for (final String attribute : attributes) {
      final String value = httpReq.getParameter(attribute);
      if (OPTIONAL_VALUE.equals(value)) {
        sregReq.addAttribute(attribute, false);
      }
      else
        if (REQUIRED_VALUE.equals(value)) {
          sregReq.addAttribute(attribute, true);
        }
    }

    // attach the extension to the authentication request
    if (!sregReq.getAttributes().isEmpty()) {
      authReq.addExtension(sregReq);
    }
  }

  // --- placing the authentication request ---
  public String authRequest(final String userSuppliedString,
    final HttpServletRequest httpReq, final HttpServletResponse httpResp)
    throws IOException, ServletException {
    try {
      // configure the return_to URL where your application will receive
      // the authentication responses from the OpenID provider
      // String returnToUrl = "http://example.com/openid";
      final String returnToUrl =
        httpReq.getRequestURL().toString() + "?is_return=true";

      // perform discovery on the user-supplied identifier
      final List discoveries = manager.discover(userSuppliedString);

      // attempt to associate with the OpenID provider
      // and retrieve one service endpoint for authentication
      final DiscoveryInformation discovered = manager.associate(discoveries);

      // store the discovery information in the user's session
      httpReq.getSession().setAttribute("openid-disc", discovered);

      // obtain a AuthRequest message to be sent to the OpenID provider
      final AuthRequest authReq = manager.authenticate(discovered, returnToUrl);

      // Simple registration example
      addSimpleRegistrationToAuthRequest(httpReq, authReq);

      // Attribute exchange example
      addAttributeExchangeToAuthRequest(httpReq, authReq);

      if (!discovered.isVersion2()) {
        // Option 1: GET HTTP-redirect to the OpenID Provider endpoint
        // The only method supported in OpenID 1.x
        // redirect-URL usually limited ~2048 bytes
        httpResp.sendRedirect(authReq.getDestinationUrl(true));
        return null;
      }
      else {
        // Option 2: HTML FORM Redirection (Allows payloads >2048 bytes)

        final RequestDispatcher dispatcher =
          getServletContext().getRequestDispatcher(
            "/jsp/openid/consumer/formredirection.jsp");
        httpReq.setAttribute("prameterMap", httpReq.getParameterMap());
        httpReq.setAttribute("message", authReq);
        // httpReq.setAttribute("destinationUrl", httpResp
        // .getDestinationUrl(false));
        dispatcher.forward(httpReq, httpResp);
      }
    }
    catch (final OpenIDException e) {
      // present error to the user
      throw new ServletException(e);
    }

    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void doGet(final HttpServletRequest req,
    final HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void doPost(final HttpServletRequest req,
    final HttpServletResponse resp) throws ServletException, IOException {
    if ("true".equals(req.getParameter("is_return"))) {
      processReturn(req, resp);
    }
    else {
      final String identifier = req.getParameter("openid_identifier");
      if (identifier != null) {
        this.authRequest(identifier, req, resp);
      }
      else {
        this.getServletContext().getRequestDispatcher(
          "/jsp/openid/consumer/index.jsp").forward(req, resp);
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void init(final ServletConfig config) throws ServletException {
    super.init(config);

    context = config.getServletContext();

    LOG.debug("context: " + context);

    // --- Forward proxy setup (only if needed) ---
    final ProxyProperties proxyProps = getProxyProperties(config);
    if (proxyProps != null) {
      LOG.debug("ProxyProperties: " + proxyProps);
      HttpClientFactory.setProxyProperties(proxyProps);
    }

    this.manager = new ConsumerManager();
    manager.setAssociations(new InMemoryConsumerAssociationStore());
    manager.setNonceVerifier(new InMemoryNonceVerifier(5000));
    manager.setMinAssocSessEnc(AssociationSessionType.DH_SHA256);
  }

  private void processReturn(final HttpServletRequest req,
    final HttpServletResponse resp) throws ServletException, IOException {

    final Identifier identifier = this.verifyResponse(req);

    LOG.debug("identifier: " + identifier);

    if (identifier == null) {
      this.getServletContext().getRequestDispatcher(
        "/jsp/openid/consumer/index.jsp").forward(req, resp);
    }
    else {
      req.setAttribute("identifier", identifier.getIdentifier());
      this.getServletContext().getRequestDispatcher(
        "/jsp/openid/consumer/return.jsp").forward(req, resp);
    }
  }

  /**
   * @param httpReq
   * @param authSuccess
   * @throws MessageException
   */
  private void receiveAttributeExchange(final HttpServletRequest httpReq,
    final AuthSuccess authSuccess) throws MessageException {
    if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
      final FetchResponse fetchResp =
        (FetchResponse) authSuccess.getExtension(AxMessage.OPENID_NS_AX);

      // List emails = fetchResp.getAttributeValues("email");
      // String email = (String) emails.get(0);

      final List aliases = fetchResp.getAttributeAliases();
      final Map attributes = new LinkedHashMap();
      for (final Iterator iter = aliases.iterator(); iter.hasNext();) {
        final String alias = (String) iter.next();
        final List values = fetchResp.getAttributeValues(alias);
        if (values.size() > 0) {
          final String[] arr = new String[values.size()];
          values.toArray(arr);
          attributes.put(alias, StringUtils.join(arr));
        }
      }
      httpReq.setAttribute("attributes", attributes);
    }
  }

  /**
   * @param httpReq
   * @param authSuccess
   * @throws MessageException
   */
  private void receiveSimpleRegistration(final HttpServletRequest httpReq,
    final AuthSuccess authSuccess) throws MessageException {
    if (authSuccess.hasExtension(SRegMessage.OPENID_NS_SREG)) {
      final MessageExtension ext =
        authSuccess.getExtension(SRegMessage.OPENID_NS_SREG);
      if (ext instanceof SRegResponse) {
        final SRegResponse sregResp = (SRegResponse) ext;
        for (final Iterator iter = sregResp.getAttributeNames().iterator(); iter
          .hasNext();) {
          final String name = (String) iter.next();
          final String value = sregResp.getParameterValue(name);
          httpReq.setAttribute(name, value);
        }
      }
    }
  }

  // --- processing the authentication response ---
  public Identifier verifyResponse(final HttpServletRequest httpReq)
    throws ServletException {
    try {
      // extract the parameters from the authentication response
      // (which comes in as a HTTP request from the OpenID provider)
      final ParameterList response =
        new ParameterList(httpReq.getParameterMap());

      // retrieve the previously stored discovery information
      final DiscoveryInformation discovered =
        (DiscoveryInformation) httpReq.getSession().getAttribute("openid-disc");

      // extract the receiving URL from the HTTP request
      final StringBuffer receivingURL = httpReq.getRequestURL();
      final String queryString = httpReq.getQueryString();
      if ((queryString != null) && (queryString.length() > 0)) {
        receivingURL.append("?").append(httpReq.getQueryString());
      }

      // verify the response; ConsumerManager needs to be the same
      // (static) instance used to place the authentication request
      final VerificationResult verification =
        manager.verify(receivingURL.toString(), response, discovered);

      // examine the verification result and extract the verified
      // identifier
      final Identifier verified = verification.getVerifiedId();
      if (verified != null) {
        final AuthSuccess authSuccess =
          (AuthSuccess) verification.getAuthResponse();

        receiveSimpleRegistration(httpReq, authSuccess);

        receiveAttributeExchange(httpReq, authSuccess);

        return verified; // success
      }
    }
    catch (final OpenIDException e) {
      // present error to the user
      throw new ServletException(e);
    }

    return null;
  }
}
