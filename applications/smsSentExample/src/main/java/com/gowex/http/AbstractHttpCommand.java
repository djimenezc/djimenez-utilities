package com.gowex.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;

import com.gowex.http.util.HttpUtil;
import com.gowex.sms.sent.example.command.HttpCommand;

public abstract class AbstractHttpCommand implements HttpCommand {

  private HttpClient httpClient;

  private HttpUtil httpUtil;

  protected String response;

  protected NameValuePair[] parametersList;

  /**
   * @return the httpClient
   */
  public final HttpClient getHttpClient() {
    return httpClient;
  }

  /**
   * @return the httpUtilities
   */
  public final HttpUtil getHttpUtilities() {
    return httpUtil;
  }

  /**
   * @return the response
   */
  @Override
  public String getResponse() {
    return response;
  }

  /**
   * @param httpClient
   *          the httpClient to set
   */
  public final void setHttpClient(final HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * @param httpUtil
   *          the httpUtilities to set
   */
  public final void setHttpUtilities(final HttpUtil httpUtil) {
    this.httpUtil = httpUtil;
  }

  @Override
  public void setParameters(final NameValuePair[] parametersList) {

    this.parametersList = parametersList;
  }
}
