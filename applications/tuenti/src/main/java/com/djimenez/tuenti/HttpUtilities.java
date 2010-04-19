package com.djimenez.tuenti;

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpUtilities {

  /**
   * @param header
   * @return
   */
  private String buildNewUri(final Header header) {
    String newuri = header.getValue();
    if ((newuri == null) || (newuri.equals(""))) {
      newuri = "/";
    }
    return newuri;
  }

  public final HttpClient configureRequest(final HttpClient client,
    final String site, final int port) {

    client.getHostConfiguration().setHost(site, port, "http");

    client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

    return client;
  }

  public final Cookie[] getCookies(final HttpClient client, final String site,
    final int port) {

    // See if we got any cookies
    final CookieSpec cookiespec = CookiePolicy.getDefaultSpec();

    final Cookie[] cookies =
      cookiespec.match(site, port, "/", false, client.getState().getCookies());

    System.out.println("Initial set of cookies:");

    if (cookies.length == 0) {
      System.out.println("None");
    }
    else {
      for (final Cookie initcookie : cookies) {
        System.out.println("- " + initcookie.toString());
      }
    }

    return cookies;
  }

  public final GetMethod getMethod(final HttpClient client, final String path)
    throws IOException {

    final GetMethod getMethod = new GetMethod(path);

    getMethod.setFollowRedirects(true);

    client.executeMethod(getMethod);
    System.out.println("Get status: " + getMethod.getStatusLine().toString());

    // release any connection resources used by the method
    getMethod.releaseConnection();

    return getMethod;
  }

  /**
   * Loads the page at the given URL from a separate thread.
   * 
   * @param url
   */
  public final void loadPage(final String url, final HttpClient client) {

    final GetMethod get = new GetMethod(url);
    get.setFollowRedirects(true);

    try {

      // final int iGetResultCode = client.executeMethod(get);

      // final String strGetResponseBody = get.getResponseBodyAsString();

      // if (strGetResponseBody != null) {
      // TODO ver que hacer cuando cargamos la página

      // }
    }
    catch (final Exception ex) {
      ex.printStackTrace();
    }
    finally {
      get.releaseConnection();
    }
  }

  public final PostMethod postAuthMethod(final HttpClient client,
    final String path) throws IOException {

    final PostMethod authpost = new PostMethod(path);

    // Prepare login parameters
    final NameValuePair action = new NameValuePair("action", "do_login");
    final NameValuePair url =
      new NameValuePair("url", "/?m=Login&func=do_login");
    final NameValuePair userid =
      new NameValuePair("email", "david.jimenez19@gmail.com");
    final NameValuePair password =
      new NameValuePair("input_password", "linda1");

    authpost
      .setRequestBody(new NameValuePair[] { action, url, userid, password });

    client.executeMethod(authpost);

    System.out.println("Login form post: "
      + authpost.getStatusLine().toString());
    // release any connection resources used by the method
    authpost.releaseConnection();

    return authpost;
  }

  /**
   * Usually a successful form-based login results in a redicrect to
   * 
   * @param httpMethod
   * @return
   * @throws IOException
   * @throws HttpException
   */
  public final int redirectSucessUrl(final HttpClient client,
    final HttpMethodBase httpMethod) throws IOException {

    final int statuscode = httpMethod.getStatusCode();

    if ((statuscode == HttpStatus.SC_MOVED_TEMPORARILY)
      || (statuscode == HttpStatus.SC_MOVED_PERMANENTLY)
      || (statuscode == HttpStatus.SC_SEE_OTHER)
      || (statuscode == HttpStatus.SC_TEMPORARY_REDIRECT)) {

    }

    final Header header = httpMethod.getResponseHeader("location");

    if (header != null) {

      final String newuri = buildNewUri(header);
      System.out.println("Redirect target: " + newuri);
      final GetMethod redirect = new GetMethod(newuri);

      client.executeMethod(redirect);
      System.out.println("Redirect: " + redirect.getStatusLine().toString());
      // release any connection resources used by the method
      redirect.releaseConnection();
    }
    else {
      System.out.println("Invalid redirect");
      return -1;
    }

    return 1;
  }
}
