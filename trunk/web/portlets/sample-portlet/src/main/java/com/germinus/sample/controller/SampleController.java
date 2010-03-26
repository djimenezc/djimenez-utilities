package com.germinus.sample.controller;

import com.germinus.sample.dao.GenericDao;
import com.germinus.sample.model.Item;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SampleController extends AbstractController implements InitializingBean  {

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
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        log.debug("handleRenderRequestInternal");
        //mostramos la vista sample, no necesita parametros
        return new ModelAndView("sample", "", null);
    }

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	/*	if (this.itemDao == null)
            throw new IllegalArgumentException("A Item is required");*/
	}
}
