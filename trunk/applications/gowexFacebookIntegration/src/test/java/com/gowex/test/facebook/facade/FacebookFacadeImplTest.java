package com.gowex.test.facebook.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.gowex.facebook.facade.FacebookFacade;

public class FacebookFacadeImplTest {

  @Autowired
  FacebookFacade facebookFacade;

  public void testRetrieveAccessToken() {

    final String accessCode = "";

    facebookFacade.retrieveAccessToken(accessCode);
  }

}
