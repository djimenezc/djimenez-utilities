package com.djimenez.web.servlet;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.testing.ServletTester;

public class HttpPostServiceTest {

  private static ServletTester tester;
  private static String baseUrl;

  /**
   * Stops the Jetty container.
   */
  @AfterClass
  public static void cleanupServletContainer() throws Exception {

    tester.stop();
  }

  /**
   * This kicks off an instance of the Jetty servlet container so that we can
   * hit it. We register an echo service that simply returns the parameters
   * passed to it.
   */
  @BeforeClass
  public static void initServletContainer() throws Exception {

    tester = new ServletTester();
    tester.setContextPath("/");
    tester.addServlet(EchoServlet.class, "/echo");
    baseUrl = tester.createSocketConnector(true);
    tester.start();
  }

  @Test
  public void testPost() throws Exception {
    final PostService postService = new PostService();

    final String res =
      postService.sendHttpPost(baseUrl + "/echo", "foo=bar&baz=%25%26%3D%2F");
    final String[] resList = StringUtils.split(res, "\n");

    assertEquals(3, resList.length);
    assertEquals("SIZE=2", resList[0].trim());
    assertEquals("foo:::bar", resList[2].trim());
    assertEquals("baz:::%&=/", resList[1].trim());
  }
}
