package com.germinus.sample.web;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.HandlerInterceptor;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.context.PortletApplicationObjectSupport;
import org.springframework.web.portlet.context.PortletContextAware;

public class PortletNameInterceptor extends PortletApplicationObjectSupport
  implements HandlerInterceptor, PortletContextAware {

  private PortletContext portletContext;

  public final void afterActionCompletion(final ActionRequest arg0,
    final ActionResponse arg1, final Object arg2, final Exception arg3)
    throws Exception {

    logger.debug("PortletNameInterceptor postHandle : ");
  }

  public final void afterCompletion(final PortletRequest request,
    final PortletResponse response, final Object handler, final Exception ex)
    throws Exception {
    logger.debug("PortletNameInterceptor postHandle : ");
  }

  public final void afterRenderCompletion(final RenderRequest arg0,
    final RenderResponse arg1, final Object arg2, final Exception arg3)
    throws Exception {
    logger.debug("PortletNameInterceptor postHandle : ");

  }

  public final void postHandle(final RenderRequest request,
    final RenderResponse response, final Object handler,
    final ModelAndView modelAndView) throws Exception {
    logger.debug("PortletNameInterceptor postHandle : ");
  }

  public final void postHandleRender(final RenderRequest arg0,
    final RenderResponse arg1, final Object arg2, final ModelAndView arg3)
    throws Exception {
    logger.debug("PortletNameInterceptor postHandle : ");

  }

  public final boolean preHandle(final PortletRequest request,
    final PortletResponse response, final Object handler) throws Exception {
    logger.debug("portletContextName : "
      + (portletContext == null ? "<no PortletContext!>" : portletContext
        .getPortletContextName()));
    return true;
  }

  public final boolean preHandleAction(final ActionRequest arg0,
    final ActionResponse arg1, final Object arg2) throws Exception {
    logger.debug("PortletNameInterceptor postHandle : ");
    return false;
  }

  public final boolean preHandleRender(final RenderRequest arg0,
    final RenderResponse arg1, final Object arg2) throws Exception {
    logger.debug("PortletNameInterceptor postHandle : ");
    return false;
  }

  public final void setPortletConfig(final PortletContext portletContext) {
    this.portletContext = portletContext;
  }

}