package com.gowex.facebook.action.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gowex.facebook.action.AbstractFacebookAction;
import com.restfb.types.User;

public class FacebookAuthenticatedAction extends AbstractFacebookAction {

  /**
   * This is the action called from the Struts framework.
   * 
   * @param mapping
   *          The ActionMapping used to select this instance.
   * @param form
   *          The optional ActionForm bean for this request.
   * @param request
   *          The HTTP Request we are processing.
   * @param response
   *          The HTTP Response we are processing.
   * @throws java.lang.Exception
   * @return
   */
  @Override
  public ActionForward execute(final ActionMapping mapping,
    final ActionForm form, final HttpServletRequest request,
    final HttpServletResponse response) throws Exception {

    final String accessCode = request.getParameter("code");

    String accessToken = getFacebookFacade().retrieveAccessToken(accessCode);

    accessToken = extractAccessToken(accessToken);

    final User user = getFacebookFacade().retrievePersonInfo(accessToken);

    request.setAttribute("user", user);
    request.setAttribute("accessCode", accessCode);

    return mapping.findForward(SUCCESS);
  }

  /**
   * @param accessToken
   * @return
   */
  private String extractAccessToken(String accessToken) {
    String[] arrayString = accessToken.split("=");
    arrayString = arrayString[1].split("&");
    accessToken = arrayString[0];
    return accessToken;
  }
}
