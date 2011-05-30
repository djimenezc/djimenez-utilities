package com.gowex.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpServiceImpl implements HttpService {

  @Override
  public String sendHttpGet(final String url, final NameValuePair[] parameters)
    throws Exception {

    String responseAsString = null;

    try {
      final HttpClient client = new HttpClient();

      final StringBuffer sb = new StringBuffer(url);

      sb.append("?");

      for (final NameValuePair nameValuePair : parameters) {

        sb.append(nameValuePair.getName());
        sb.append("=");
        sb.append(nameValuePair.getValue());
        sb.append("&");
      }

      // Delete last character
      final String urlFormed = sb.substring(0, sb.length() - 1);

      final GetMethod getMethod = new GetMethod(urlFormed);
      // getMethod.setQueryString(queryString);

      client.executeMethod(getMethod);

      responseAsString = getMethod.getResponseBodyAsString();
      getMethod.releaseConnection();
    }
    catch (final Exception e) {
      throw new Exception("get failed", e);
    }

    return responseAsString;
  }

  /*
   * (non-Javadoc)
   * @see com.gowex.http.service.PostService#sendHttpPost(java.lang.String,
   * java.lang.String)
   */
  public String sendHttpPost(final String url, final String queryString,
    final NameValuePair[] parameterBody) throws Exception {

    String result = null;

    try {
      final HttpClient client = new HttpClient();
      final PostMethod post = new PostMethod(url);
      post.setQueryString(queryString);
      post.setRequestBody(parameterBody);

      client.executeMethod(post);

      result = post.getResponseBodyAsString();
      post.releaseConnection();
    }
    catch (final Exception e) {
      throw new Exception("post failed", e);
    }

    return result;
  }
}
