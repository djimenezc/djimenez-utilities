package com.germinus.sample.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

public class JavascriptController extends AbstractController implements
  InitializingBean {

  private final Log log = LogFactory.getLog(SampleController.class);

  public void afterPropertiesSet() throws Exception {
  }

  @Override
  public final ModelAndView handleRenderRequestInternal(
    final RenderRequest request, final RenderResponse response)
    throws Exception {

    log.debug("handleRenderRequestInternal");

    return new ModelAndView("javascript", "", null);
  }

}
