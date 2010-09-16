package com.djimenez.web.servlet;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class PostService {

  public String sendHttpPost(final String url, final String queryString)
    throws Exception {

    String result = null;

    try {
      final HttpClient client = new HttpClient();
      final PostMethod post = new PostMethod(url);
      post.setQueryString(queryString);
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
