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

    PortletContext portletContext;
    
	public void setPortletConfig(PortletContext portletContext) {
        this.portletContext = portletContext;
    }

	public boolean preHandle(PortletRequest request, PortletResponse response, Object handler)
			throws Exception {
        logger.debug("portletContextName : " +(portletContext == null ? "<no PortletContext!>" : portletContext.getPortletContextName()));
        return true;
	}

	public void postHandle(
			RenderRequest request, RenderResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		logger.debug("PortletNameInterceptor postHandle : ");
	}

	public void afterCompletion(
			PortletRequest request, PortletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("PortletNameInterceptor postHandle : ");
	}

	public void afterActionCompletion(ActionRequest arg0, ActionResponse arg1,
			Object arg2, Exception arg3) throws Exception {
		logger.debug("PortletNameInterceptor postHandle : ");
		
	}

	public void afterRenderCompletion(RenderRequest arg0, RenderResponse arg1,
			Object arg2, Exception arg3) throws Exception {
		logger.debug("PortletNameInterceptor postHandle : ");
		
	}

	public void postHandleRender(RenderRequest arg0, RenderResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		logger.debug("PortletNameInterceptor postHandle : ");
		
	}

	public boolean preHandleAction(ActionRequest arg0, ActionResponse arg1,
			Object arg2) throws Exception {
		logger.debug("PortletNameInterceptor postHandle : ");
		return false;
	}

	public boolean preHandleRender(RenderRequest arg0, RenderResponse arg1,
			Object arg2) throws Exception {
		logger.debug("PortletNameInterceptor postHandle : ");
		return false;
	}

}
