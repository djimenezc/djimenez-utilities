package com.germinus.sample.ajax;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class EchoDwr {

  public static String echo(final String message) throws Exception {

    final WebContext webContext = WebContextFactory.get();
    // final HttpSession session = webContext.getSession();
    // final HttpServletRequest httpServletRequest =
    // webContext.getHttpServletRequest();

    // FIXME look for the mode to retrieve a userId
    // long userId = PortalUtil.getUserId(httpServletRequest);
    //     
    // if (userId == 0) {
    // throw new Exception("Must be logged in to run this.");
    // }

    final HttpServletRequest request = webContext.getHttpServletRequest();
    request.setAttribute("message", message);

    final String html =
      webContext.forwardToString("/html/portlet/example/echo.jsp");

    return html;
  }

  public final String sayHello(final String name) {
    return "Hello, " + name;
  }
}