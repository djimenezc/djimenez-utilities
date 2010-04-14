package com.germinus.sample.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.djimenez.model.item.Item;
import com.germinus.sample.dao.GenericDao;

public class DisplayTagsController extends AbstractController implements InitializingBean{
	
	private static final Log log = LogFactory.getLog(SampleController.class);
	
	private GenericDao<Item, Long> itemDao;
	
    public void setItemDao(GenericDao<Item, Long> itemDao) {
        this.itemDao = itemDao;
    }

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
        return new ModelAndView("display-tags", "items", itemDao.getAll());
    }

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		//if (this.itemDao == null)
           // throw new IllegalArgumentException("A Item is required");
	}
}
