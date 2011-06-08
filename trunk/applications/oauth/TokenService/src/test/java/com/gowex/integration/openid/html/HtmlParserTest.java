package com.gowex.integration.openid.html;

import java.io.IOException;

import org.junit.Test;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.UrlIdentifier;
import org.openid4java.discovery.html.CyberNekoDOMHtmlParser;
import org.openid4java.discovery.html.HtmlParser;
import org.openid4java.discovery.html.HtmlResult;
import org.openid4java.util.HttpFetcher;
import org.openid4java.util.HttpFetcherFactory;
import org.openid4java.util.HttpRequestOptions;
import org.openid4java.util.HttpResponse;

public class HtmlParserTest {

  private static final String URL_OPENID_ENDPOINT =
    "http://localhost:10001/TokenService/openidOp/id=1111111";

  private final HtmlParser htmlParser = new CyberNekoDOMHtmlParser();

  @Test
  public void testHtmlParser() throws DiscoveryException, IOException {

    final UrlIdentifier identifier = new UrlIdentifier(URL_OPENID_ENDPOINT);

    final HttpFetcherFactory httpFetcherFactory = new HttpFetcherFactory();

    final HttpFetcher httpFetcher =
      httpFetcherFactory.createFetcher(HttpRequestOptions
        .getDefaultOptionsForDiscovery());

    final HttpRequestOptions requestOptions = httpFetcher.getRequestOptions();
    requestOptions.setContentType("text/html");

    final HttpResponse resp =
      httpFetcher.get(identifier.toString(), requestOptions);

    final HtmlResult result = new HtmlResult();
    htmlParser.parseHtml(resp.getBody(), result);

    System.out.println("Endpoint 1: " + result.getOP1Endpoint());
    System.out.println("Endpoint 2: " + result.getOP2Endpoint());

    org.junit.Assert.assertEquals(
      "http://localhost:10001/TokenService/openid/provider", result
        .getOP1Endpoint().toString());
  }
}
