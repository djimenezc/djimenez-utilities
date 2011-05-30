package com.gowex.service;

import org.apache.commons.httpclient.NameValuePair;

public interface HttpService {

  public abstract String sendHttpGet(final String url,
    final NameValuePair[] parameterBody) throws Exception;

  public abstract String sendHttpPost(final String url,
    final String queryString, final NameValuePair[] parameterBody)
    throws Exception;

}