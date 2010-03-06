package com.djimenez.tuenti;

import org.apache.commons.httpclient.HttpClient;

import com.djimenez.core.patterns.interfaces.Command;

public abstract class AbstractHttpCommand implements Command {

  private HttpClient httpClient;

  private HttpUtilities httpUtilities;

  /**
   * @param httpClient
   *          the httpClient to set
   */
  public void setHttpClient(final HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * @return the httpClient
   */
  public HttpClient getHttpClient() {
    return httpClient;
  }

  /**
   * @param httpUtilities
   *          the httpUtilities to set
   */
  public void setHttpUtilities(final HttpUtilities httpUtilities) {
    this.httpUtilities = httpUtilities;
  }

  /**
   * @return the httpUtilities
   */
  public HttpUtilities getHttpUtilities() {
    return httpUtilities;
  }

}
