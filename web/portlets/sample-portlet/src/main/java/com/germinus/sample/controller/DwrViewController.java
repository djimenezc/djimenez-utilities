package com.germinus.sample.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

public class DwrViewController extends AbstractController {

    private static final Log log = LogFactory.getLog(SampleController.class);

    /**
     * Process the action request. There is nothing to return.
     */
    public void handleActionRequestVoid(ActionRequest request, ActionResponse response)
        throws Exception    {
	
    }
    
    /**
     * Process the render request and return a ModelAndView object which the
     * DispatcherPortlet will render.
     */
    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        log.debug("handleRenderRequestInternal");
        return new ModelAndView("dwrPage","", null);
    }

}
