package com.gowex.facebook.action.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gowex.facebook.action.AbstractFacebookAction;
import com.gowex.facebook.facade.FacebookFacadeImpl;

public class FacebookAuthenticationAction extends AbstractFacebookAction {

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

    request.setAttribute("appId", getFacebookFacade().getAppId());
    request.setAttribute("redirectUrl", getFacebookFacade().getRedirectUrl());
    request.setAttribute("facebookScope", getFacebookFacade().getPermissions());
    request.setAttribute("urlFacebook",
      FacebookFacadeImpl.URL_FACEBOOK_OAUTH_AUTHORITATION);

    return mapping.findForward(SUCCESS);
  }
}
