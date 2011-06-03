package com.sun.identity.openid;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openid4java.message.DirectError;
import org.openid4java.message.Message;
import org.openid4java.message.ParameterList;
import org.openid4java.server.ServerManager;

public class OpenidProviderServlet extends javax.servlet.http.HttpServlet {

  // instantiate a ServerManager object
  public ServerManager manager = new ServerManager();

  public OpenidProviderServlet() {
    manager.setOPEndpointUrl("Http://my.openidprovider.com/server");
  }

  private String directResponse(final HttpServletResponse httpResp,
    final String response) throws IOException {
    final ServletOutputStream os = httpResp.getOutputStream();
    os.write(response.getBytes());
    os.close();

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

    try {
      processRequest(req, resp);
    }
    catch (final Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public String processRequest(final HttpServletRequest httpReq,
    final HttpServletResponse httpResp) throws Exception {
    // extract the parameters from the request
    final ParameterList request = new ParameterList(httpReq.getParameterMap());

    final String mode =
      request.hasParameter("openid.mode") ? request
        .getParameterValue("openid.mode") : null;

    Message response;
    String responseText;

    if ("associate".equals(mode)) {
      // --- process an association request ---
      response = manager.associationResponse(request);
      responseText = response.keyValueFormEncoding();
    }
    else
      if ("checkid_setup".equals(mode) || "checkid_immediate".equals(mode)) {
        // interact with the user and obtain data needed to continue
        final List userData = userInteraction(request);

        final String userSelectedId = (String) userData.get(0);
        final String userSelectedClaimedId = (String) userData.get(1);
        final Boolean authenticatedAndApproved = (Boolean) userData.get(2);

        // --- process an authentication request ---
        response =
          manager.authResponse(request, userSelectedId, userSelectedClaimedId,
            authenticatedAndApproved.booleanValue());

        if (response instanceof DirectError) {
          return directResponse(httpResp, response.keyValueFormEncoding());
        }
        else {
          // caller will need to decide which of the following to use:

          // option1: GET HTTP-redirect to the return_to URL
          return response.getDestinationUrl(true);

          // option2: HTML FORM Redirection
          // RequestDispatcher dispatcher =
          // getServletContext().getRequestDispatcher("formredirection.jsp");
          // httpReq.setAttribute("prameterMap", response.getParameterMap());
          // httpReq.setAttribute("destinationUrl",
          // response.getDestinationUrl(false));
          // dispatcher.forward(request, response);
          // return null;
        }
      }
      else
        if ("check_authentication".equals(mode)) {
          // --- processing a verification request ---
          response = manager.verify(request);
          responseText = response.keyValueFormEncoding();
        }
        else {
          // --- error response ---
          response = DirectError.createDirectError("Unknown request");
          responseText = response.keyValueFormEncoding();
        }

    // return the result to the user
    return responseText;
  }

  private List userInteraction(final ParameterList request)
    throws ServerException {
    throw new ServerException("User-interaction not implemented.");
  }
}