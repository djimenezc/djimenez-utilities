package com.gowex.facebook.facade;

import org.apache.commons.httpclient.NameValuePair;

import com.gowex.service.HttpService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class FacebookFacadeImpl implements FacebookFacade {

  public static final String URL_FACEBOOK_OAUTH_ACCESS_TOKEN =
    "https://graph.facebook.com/oauth/access_token";
  public static final String URL_FACEBOOK_OAUTH_AUTHORITATION =
    "https://www.facebook.com/dialog/oauth";

  private String appId;
  private String redirectUrl;
  private String permissions;
  private String appSecret;
  private String appApiKey;

  private FacebookClient facebookClient;
  private HttpService httpService;

  /**
   * @return the appApiKey
   */
  public String getAppApiKey() {
    return appApiKey;
  }

  /**
   * @return the appId
   */
  @Override
  public String getAppId() {
    return appId;
  }

  /**
   * @return the appSecret
   */
  public String getAppSecret() {
    return appSecret;
  }

  /**
   * @return the facebookClient
   */
  public FacebookClient getFacebookClient() {
    return facebookClient;
  }

  /**
   * @return the httpService
   */
  public HttpService getHttpService() {
    return httpService;
  }

  @Override
  public String getPermissions() {

    return permissions;
  }

  /**
   * @return the redirectUrl
   */
  @Override
  public String getRedirectUrl() {
    return redirectUrl;
  }

  @Override
  public String retrieveAccessToken(final String accessCode) {

    final NameValuePair[] parameterBody = new NameValuePair[4];

    parameterBody[0] = new NameValuePair("client_id", appId);
    parameterBody[1] = new NameValuePair("redirect_uri", redirectUrl);
    parameterBody[2] = new NameValuePair("client_secret", appSecret);
    parameterBody[3] = new NameValuePair("code", accessCode);

    String accessToken;
    try {
      accessToken =
        httpService.sendHttpGet(URL_FACEBOOK_OAUTH_ACCESS_TOKEN, parameterBody);
    }
    catch (final Exception e) {
      accessToken = "";
    }

    return accessToken;
  }

  @Override
  public String retrieveAuthoritationCode() {

    final NameValuePair[] parameterBody = new NameValuePair[4];

    parameterBody[0] = new NameValuePair("client_id", appId);
    parameterBody[1] = new NameValuePair("redirect_uri", redirectUrl);
    parameterBody[2] = new NameValuePair("display", "touch");
    parameterBody[4] = new NameValuePair("scope", "email");

    String accessToken;

    try {
      accessToken =
        httpService
          .sendHttpGet(URL_FACEBOOK_OAUTH_AUTHORITATION, parameterBody);
    }
    catch (final Exception e) {
      accessToken = "";
    }

    return accessToken;
  }

  @Override
  public User retrievePersonInfo(final String accessToken) {

    facebookClient = new DefaultFacebookClient(accessToken);

    final User user = facebookClient.fetchObject("me", User.class);

    return user;
  }

  /**
   * @param appApiKey
   *          the appApiKey to set
   */
  public void setAppApiKey(final String appApiKey) {
    this.appApiKey = appApiKey;
  }

  /**
   * @param appId
   *          the appId to set
   */
  public void setAppId(final String appId) {
    this.appId = appId;
  }

  /**
   * @param appSecret
   *          the appSecret to set
   */
  public void setAppSecret(final String appSecret) {
    this.appSecret = appSecret;
  }

  /**
   * @param facebookClient
   *          the facebookClient to set
   */
  public void setFacebookClient(final FacebookClient facebookClient) {
    this.facebookClient = facebookClient;
  }

  /**
   * @param httpService
   *          the httpService to set
   */
  public void setHttpService(final HttpService httpService) {
    this.httpService = httpService;
  }

  /**
   * @param permissions
   *          the permissions to set
   */
  public void setPermissions(final String permissions) {
    this.permissions = permissions;
  }

  /**
   * @param redirectUrl
   *          the redirectUrl to set
   */
  public void setRedirectUrl(final String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

}
