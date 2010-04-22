package com.djimenez.tuenti;

import org.apache.commons.httpclient.HttpClient;

import com.djimenez.core.patterns.interfaces.command.Command;

public abstract class AbstractHttpCommand implements Command {

  private HttpClient httpClient;

  private HttpUtilities httpUtilities;

  /**
   * @return the httpClient
   */
  public final HttpClient getHttpClient() {
    return httpClient;
  }

  /**
   * @return the httpUtilities
   */
  public final HttpUtilities getHttpUtilities() {
    return httpUtilities;
  }

  /**
   * @param httpClient
   *          the httpClient to set
   */
  public final void setHttpClient(final HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * @param httpUtilities
   *          the httpUtilities to set
   */
  public final void setHttpUtilities(final HttpUtilities httpUtilities) {
    this.httpUtilities = httpUtilities;
  }

}
