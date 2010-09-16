package com.djimenez.tuenti;

import org.apache.commons.httpclient.HttpClient;

import com.djimenez.core.patterns.interfaces.command.Command;

public abstract class AbstractHttpCommand implements Command {

  private HttpClient httpClient;

  private HttpUtil httpUtil;

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

}
