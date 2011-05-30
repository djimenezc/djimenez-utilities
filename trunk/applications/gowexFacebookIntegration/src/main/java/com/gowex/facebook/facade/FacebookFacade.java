package com.gowex.facebook.facade;

import com.restfb.types.User;

public interface FacebookFacade {

  String getAppId();

  String getPermissions();

  String getRedirectUrl();

  String retrieveAccessToken(String accessCode);

  String retrieveAuthoritationCode();

  User retrievePersonInfo(String accessCode);

}
