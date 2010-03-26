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

public class SampleController extends AbstractController implements
  InitializingBean {

  private static final Log log = LogFactory.getLog(SampleController.class);

  public void afterPropertiesSet() throws Exception {
    // TODO Auto-generated method stub
    /*
     * if (this.itemDao == null) throw new
     * IllegalArgumentException("A Item is required");
     */
  }

  /**
   * Process the action request. There is nothing to return.
   */
  public void handleActionRequestVoid(final ActionRequest request,
    final ActionResponse response) throws Exception {

  }

  /**
   * Process the render request and return a ModelAndView object which the
   * DispatcherPortlet will render.
   */
  @Override
  public ModelAndView handleRenderRequestInternal(final RenderRequest request,
    final RenderResponse response) throws Exception {
    log.debug("handleRenderRequestInternal");
    // mostramos la vista sample, no necesita parametros
    return new ModelAndView("sample", "", null);
  }
}
