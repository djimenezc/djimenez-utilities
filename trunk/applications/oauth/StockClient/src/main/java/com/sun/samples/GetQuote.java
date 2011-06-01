/**
 * Do NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER. Copyright (c) 2010
 * Sun Microsystems Inc. All Rights Reserved The contents of this file are
 * subject to the terms of the Common Development and Distribution License (the
 * License). You may not use this file except in compliance with the License.
 * You can obtain a copy of the License at
 * https://opensso.dev.java.net/public/CDDLv1.0.html or
 * opensso/legal/CDDLv1.0.txt See the License for the specific language
 * governing permission and limitations under the License. When distributing
 * Covered Code, include this CDDL Header Notice in each file and include the
 * License file at opensso/legal/CDDLv1.0.txt. If applicable, add the following
 * below the CDDL Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]" $Id:
 * GetQuote.java.template,v 1.5 2010-01-20 17:51:37 huacui Exp $
 */

package com.sun.samples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.oauth.client.OAuthClientFilter;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;

/**
 * Sample servlet that demonstrates OAuth token support with OpenSSO on
 * Glassfish
 */
public class GetQuote extends HttpServlet {

  private static final String TOKEN_SERVICE =
  // "<PROTOCOL>://<HOST>:<PORT>/<DEPLOYURI>/resources/1/oauth/";
    "http://localhost:10001/TokenService/resources/1/oauth/";
  private static final String CONSUMER_NAME = "StockClient";
  private static final String CONSUMER_KEY =
    TOKEN_SERVICE + "consumer/" + CONSUMER_NAME;
  private static final String CONSUMER_SECRET = CONSUMER_NAME + "_secret";
  // The valid values of SIGNATURE_METHOD are:
  // HMAC-SHA1, RSA-SHA1, and PLAINTEXT
  // private static final String SIGNATURE_METHOD = "HMAC-SHA1";
  private static final Client client = Client.create();
  private static String oauth_token_str = null;
  private static String oauth_secret_str = null;
  private static String signature_method = "HMAC-SHA1";

  String url = "http://localhost:10001/StockService/resources/stock?quote=";
  // "<PROTOCOL-STOCKSERVICE>://<HOST-STOCKSERVICE>:<PORT-STOCKSERVICE>/StockService/resources/stock?quote=";

  // a test RSA private key string
  private static final String PRIVATE_KEY =
    "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALRiMLAh9iimur8V"
      + "A7qVvdqxevEuUkW4K+2KdMXmnQbG9Aa7k7eBjK1S+0LYmVjPKlJGNXHDGuy5Fw/d"
      + "7rjVJ0BLB+ubPK8iA/Tw3hLQgXMRRGRXXCn8ikfuQfjUS1uZSatdLB81mydBETlJ"
      + "hI6GH4twrbDJCR2Bwy/XWXgqgGRzAgMBAAECgYBYWVtleUzavkbrPjy0T5FMou8H"
      + "X9u2AC2ry8vD/l7cqedtwMPp9k7TubgNFo+NGvKsl2ynyprOZR1xjQ7WgrgVB+mm"
      + "uScOM/5HVceFuGRDhYTCObE+y1kxRloNYXnx3ei1zbeYLPCHdhxRYW7T0qcynNmw"
      + "rn05/KO2RLjgQNalsQJBANeA3Q4Nugqy4QBUCEC09SqylT2K9FrrItqL2QKc9v0Z"
      + "zO2uwllCbg0dwpVuYPYXYvikNHHg+aCWF+VXsb9rpPsCQQDWR9TT4ORdzoj+Nccn"
      + "qkMsDmzt0EfNaAOwHOmVJ2RVBspPcxt5iN4HI7HNeG6U5YsFBb+/GZbgfBT3kpNG"
      + "WPTpAkBI+gFhjfJvRw38n3g/+UeAkwMI2TJQS4n8+hid0uus3/zOjDySH3XHCUno"
      + "cn1xOJAyZODBo47E+67R4jV1/gzbAkEAklJaspRPXP877NssM5nAZMU0/O/NGCZ+"
      + "3jPgDUno6WbJn5cqm8MqWhW1xGkImgRk+fkDBquiq4gPiT898jusgQJAd5Zrr6Q8"
      + "AO/0isr/3aa6O6NLQxISLKcPDk2NOccAfS/xOtfOz4sJYM3+Bs4Io9+dZGSDCA54"
      + "Lw03eHTNQghS0A==";

  // the x509 cert in PEM
  private static final String CERTIFICATE =
    "-----BEGIN CERTIFICATE-----\n"
      + "MIIBpjCCAQ+gAwIBAgIBATANBgkqhkiG9w0BAQUFADAZMRcwFQYDVQQDDA5UZXN0\n"
      + "IFByaW5jaXBhbDAeFw03MDAxMDEwODAwMDBaFw0zODEyMzEwODAwMDBaMBkxFzAV\n"
      + "BgNVBAMMDlRlc3QgUHJpbmNpcGFsMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKB\n"
      + "gQC0YjCwIfYoprq/FQO6lb3asXrxLlJFuCvtinTF5p0GxvQGu5O3gYytUvtC2JlY\n"
      + "zypSRjVxwxrsuRcP3e641SdASwfrmzyvIgP08N4S0IFzEURkV1wp/IpH7kH41Etb\n"
      + "mUmrXSwfNZsnQRE5SYSOhh+LcK2wyQkdgcMv11l4KoBkcwIDAQABMA0GCSqGSIb3\n"
      + "DQEBBQUAA4GBAGZLPEuJ5SiJ2ryq+CmEGOXfvlTtEL2nuGtr9PewxkgnOjZpUy+d\n"
      + "4TvuXJbNQc8f4AMWL/tO9w0Fk80rWKp9ea8/df4qMq5qlFWlx6yOLQxumNOmECKb\n"
      + "WpkUQDIDJEoFUzKMVuJf4KO/FJ345+BNLGgbJ6WujreoM1X/gYfdnJ/J\n"
      + "-----END CERTIFICATE-----";

  @SuppressWarnings("unchecked")
  private static MultivaluedMap<String, String> POST(
    final WebResource resource, final MultivaluedMap data) {
    return resource.type("application/x-www-form-urlencoded").post(
      MultivaluedMap.class, data);
  }

  private static MultivaluedMap<String, String> registerConsumer() {

    final WebResource resource =
      client.resource(TOKEN_SERVICE + "consumer_registration");
    final MultivaluedMapImpl form = new MultivaluedMapImpl();
    form.add("cons_key", CONSUMER_KEY);
    form.add("secret", CONSUMER_SECRET);
    form.add("name", CONSUMER_NAME);
    form.add("certificate", CERTIFICATE);

    final MultivaluedMap<String, String> response = POST(resource, form);

    System.out.println("Registering consumer " + CONSUMER_KEY + ": ");

    final Iterator itr = response.entrySet().iterator();

    while (itr.hasNext()) {
      final Map.Entry<String, String> e = (Entry<String, String>) itr.next();
      final String value = e.getKey();

      System.out.println(value);
    }

    return response;
  }

  // <editor-fold defaultstate="collapsed"
  // desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   * 
   * @param request
   *          servlet request
   * @param response
   *          servlet response
   */
  @Override
  protected void doGet(final HttpServletRequest request,
    final HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   * 
   * @param request
   *          servlet request
   * @param response
   *          servlet response
   */
  @Override
  protected void doPost(final HttpServletRequest request,
    final HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  private MultivaluedMap getAccessToken(final String verifier) {
    final OAuthParameters params = initOAuthParams();
    final OAuthSecrets secrets = initOAuthSecrets();
    if (oauth_token_str != null) {
      params.token(oauth_token_str);
    }
    params.verifier(verifier);
    secrets.tokenSecret(oauth_secret_str);
    final OAuthClientFilter filter = getClientFilter(params, secrets);
    final WebResource resource =
      client.resource(TOKEN_SERVICE + "get_access_token");
    resource.addFilter(filter);
    final MultivaluedMap<String, String> response =
      POST(resource, new MultivaluedMapImpl());
    return response;
  }

  private OAuthClientFilter getClientFilter(final OAuthParameters params,
    final OAuthSecrets secrets) {
    final OAuthClientFilter filter =
      new OAuthClientFilter(client.getProviders(), params, secrets);
    return filter;
  }

  private MultivaluedMap getRequestToken(final String callback) {
    final OAuthParameters params = initOAuthParams();
    params.callback(callback);
    final OAuthSecrets secrets = initOAuthSecrets();
    final OAuthClientFilter filter = getClientFilter(params, secrets);
    final WebResource resource =
      client.resource(TOKEN_SERVICE + "get_request_token");
    resource.addFilter(filter);
    final MultivaluedMap<String, String> response =
      POST(resource, new MultivaluedMapImpl());
    oauth_token_str = response.getFirst("oauth_token");
    oauth_secret_str = response.getFirst("oauth_token_secret");
    return response;

  }

  /**
   * Returns a short description of the servlet.
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }

  private OAuthParameters initOAuthParams() {
    final OAuthParameters params = new OAuthParameters();
    params.consumerKey(CONSUMER_KEY).signatureMethod(signature_method);
    return params;
  }

  private OAuthSecrets initOAuthSecrets() {
    final OAuthSecrets secrets = new OAuthSecrets();
    if (signature_method.equalsIgnoreCase("RSA-SHA1")) {
      secrets.consumerSecret(PRIVATE_KEY);
    }
    else {
      secrets.consumerSecret(CONSUMER_SECRET);
    }
    return secrets;
  }

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   * 
   * @param request
   *          servlet request
   * @param response
   *          servlet response
   */
  protected void processRequest(final HttpServletRequest request,
    final HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");

    final PrintWriter out = response.getWriter();
    final String symbol = request.getParameter("symbol");

    if ((symbol == null) || (symbol.length() == 0)) {
      out.println("<h1>Invalid Stock Symbol</h1>");
      out.close();
      return;
    }

    final String sign_method = request.getParameter("sig");

    if (sign_method != null) {
      signature_method = sign_method;
    }

    if (!signature_method.equals("HMAC-SHA1")
      && !signature_method.equals("RSA-SHA1")
      && !signature_method.equals("PLAINTEXT")) {
      out.println("<h1>Invalid Signature method</h1>");
      out.close();
      return;
    }
    System.out.println("signature_method = " + signature_method);

    try {
      // Check for the call back parameter and if yes
      // obtain the access token.
      final String cb = request.getParameter("callback");
      if ((cb != null) && cb.equals("true")) {
        final String reqtoken = request.getParameter("oauth_token");
        final String verifier = request.getParameter("oauth_verifier");
        final MultivaluedMap accessTokenResp = getAccessToken(verifier);
        final String accessToken =
          (String) accessTokenResp.getFirst("oauth_token");
        final String accessTokenSecret =
          (String) accessTokenResp.getFirst("oauth_token_secret");
        // Reinitialize the params and secret.
        final OAuthParameters params = initOAuthParams();
        params.token(accessToken);
        final OAuthSecrets secrets = initOAuthSecrets();
        secrets.tokenSecret(accessTokenSecret);
        // now access the resource
        final OAuthClientFilter filter = getClientFilter(params, secrets);
        final WebResource resource = client.resource(url + symbol);
        resource.addFilter(filter);
        final ClientResponse clr = resource.get(ClientResponse.class);
        response.setContentType("text/xml;charset=UTF-8");
        out.println(clr.getEntity(String.class));
        return;
      }
      // Register the consumer. This can also be done offband.
      registerConsumer();
      // TODO descomentar el registro del consumidor
      // Get StockQuote
      final WebResource resource = client.resource(url + symbol);
      final ClientResponse clr = resource.get(ClientResponse.class);
      if (clr.getResponseStatus().getStatusCode() == 401) {
        // unauthorized
        final String callback =
          request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort()
            + "/StockClient/GetQuote?callback=true&symbol=" + symbol;
        final MultivaluedMap rtresp = getRequestToken(callback);

        // redirectForAuthentication(request, response, rtresp, symbol);
        redirectForAuthenticationNotInteractive(request, response, rtresp,
          symbol);
      }
      // out.println(clr.getEntity(String.class));
    }
    catch (final Exception ex) {
      ex.printStackTrace(out);
    }
    out.close();
  }

  private void redirectForAuthentication(final HttpServletRequest request,
    final HttpServletResponse response, final MultivaluedMap rtResp,
    final String symbol) throws Exception {
    final String oauthtoken = (String) rtResp.getFirst("oauth_token");
    System.out.println("OAuth token: " + oauthtoken);

    final String url =
    // "<PROTOCOL>://<HOST>:<PORT>/<DEPLOYURI>/oauth/userconsole.jsp?"
      "http://localhost:10001/TokenService/userconsole.jsp?" + "oauth_token="
        + oauthtoken;
    response.sendRedirect(url);

  }

  private void redirectForAuthenticationNotInteractive(
    final HttpServletRequest request, final HttpServletResponse response,
    final MultivaluedMap rtResp, final String symbol) throws Exception {

    final String oauthtoken = (String) rtResp.getFirst("oauth_token");
    System.out.println("OAuth token: " + oauthtoken);

    final String url =
    // "<PROTOCOL>://<HOST>:<PORT>/<DEPLOYURI>/oauth/userconsole.jsp?"
      "http://localhost:10001/TokenService/loginAuto.jsp?" + "oauth_token="
        + oauthtoken;
    response.sendRedirect(url);
  }

}
