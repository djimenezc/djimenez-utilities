package com.gowex.facebook.action;

import org.apache.struts.action.Action;

import com.gowex.facebook.facade.FacebookFacade;

public class AbstractFacebookAction extends Action {

  public static final String SUCCESS = "success";
  public static final String ERROR = "error";

  private FacebookFacade facebookFacade;

  /**
   * @return the facebookFacade
   */
  public FacebookFacade getFacebookFacade() {
    return facebookFacade;
  }

  /**
   * @param facebookFacade
   *          the facebookFacade to set
   */
  public void setFacebookFacade(final FacebookFacade reventaFacade) {
    this.facebookFacade = reventaFacade;
  }

}
