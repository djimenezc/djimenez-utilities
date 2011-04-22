package com.djimenez.tuenti.example;

/*
 * ==================================================================== Licensed
 * to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership. The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the
 * License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * ==================================================================== This
 * software consists of voluntary contributions made by many individuals on
 * behalf of the Apache Software Foundation. For more information on the Apache
 * Software Foundation, please see <http://www.apache.org/>. [Additional
 * notices, if required by prior licensing conditions]
 */

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * <p>
 * A example that demonstrates how HttpClient APIs can be used to perform form-based logon.
 * </p>
 * 
 * @author Oleg Kalnichevski
 */
public final class FormLoginDemo {

  private static final String LOGON_PATH = "/?m=login&func=force_www";
  static final String LOGON_SITE = "www.tuenti.com";
  static final int LOGON_PORT = 80;

  /**
   * @param initcookies
   */
  private static void checkCookies(final Cookie[] initcookies) {
    if (initcookies.length == 0) {
      System.out.println("None");
    }
    else {
      for (final Cookie initcookie : initcookies) {
        System.out.println("- " + initcookie.toString());
      }
    }
  }

  /**
   * @param client
   * @param header
   * @throws IOException
   * @throws HttpException
   */
  private static void checkHeader(final HttpClient client, final Header header) throws IOException {

    if (header != null) {
      String newuri = header.getValue();
      if ((newuri == null) || (newuri.equals(""))) {
        newuri = "/";
      }
      System.out.println("Redirect target: " + newuri);
      final GetMethod redirect = new GetMethod(newuri);

      client.executeMethod(redirect);
      System.out.println("Redirect: " + redirect.getStatusLine().toString());
      // release any connection resources used by the method
      redirect.releaseConnection();
    }
    else {
      System.out.println("Invalid redirect");
      System.exit(1);
    }
  }

  public static void main(final String[] args) throws Exception {

    final HttpClient client = new HttpClient();

    client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT, "http");
    client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
    // 'developer.java.sun.com' has cookie compliance problems
    // Their session cookie's domain attribute is in violation of the RFC2109
    // We have to resort to using compatibility cookie policy

    final GetMethod authget = new GetMethod(LOGON_PATH);
    authget.setFollowRedirects(true);

    client.executeMethod(authget);
    System.out.println("Login form get: " + authget.getStatusLine().toString());
    // release any connection resources used by the method
    authget.releaseConnection();
    // See if we got any cookies
    final CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
    final Cookie[] initcookies =
      cookiespec.match(LOGON_SITE, LOGON_PORT, "/", false, client.getState().getCookies());
    System.out.println("Initial set of cookies:");

    checkCookies(initcookies);

    final PostMethod authpost = new PostMethod(LOGON_PATH);

    // Prepare login parameters
    final NameValuePair action = new NameValuePair("action", "do_login");
    final NameValuePair url = new NameValuePair("url", "/?m=Login&func=do_login");
    final NameValuePair userid = new NameValuePair("email", "david.jimenez19%40gmail.com");
    final NameValuePair password = new NameValuePair("input_password", "linda1");
    final NameValuePair timeZone = new NameValuePair("timezone", "1");
    final NameValuePair timeStamp = new NameValuePair("timezone", "13034395121");

    authpost.setRequestBody(new NameValuePair[] { action, url, userid, password, timeZone,
      timeStamp });

    client.executeMethod(authpost);

    System.out.println("Login form post: " + authpost.getStatusLine().toString());
    // release any connection resources used by the method
    authpost.releaseConnection();
    // See if we got any cookies
    // The only way of telling whether logon succeeded is
    // by finding a session cookie
    final Cookie[] logoncookies =
      cookiespec.match(LOGON_SITE, LOGON_PORT, "/", false, client.getState().getCookies());
    System.out.println("Logon cookies:" + logoncookies);

    checkCookies(logoncookies);

    manageRequest(client, authpost);
  }

  /**
   * @param client
   * @param authpost
   * @throws IOException
   * @throws HttpException
   */
  private static void manageRequest(final HttpClient client, final PostMethod authpost)
    throws IOException {
    // Usually a successful form-based login results in a redicrect to
    // another url
    final int statuscode = authpost.getStatusCode();
    if ((statuscode == HttpStatus.SC_MOVED_TEMPORARILY)
      || (statuscode == HttpStatus.SC_MOVED_PERMANENTLY) || (statuscode == HttpStatus.SC_SEE_OTHER)
      || (statuscode == HttpStatus.SC_TEMPORARY_REDIRECT)) {

      final Header header = authpost.getResponseHeader("location");

      checkHeader(client, header);
    }
  }

  private FormLoginDemo() {
    super();
  }
}
