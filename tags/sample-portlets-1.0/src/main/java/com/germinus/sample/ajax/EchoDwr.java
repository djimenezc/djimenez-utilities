package com.germinus.sample.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liferay.portal.util.PortalUtil;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class EchoDwr {
    public static String echo(String message) throws Exception {
     
     WebContext webContext = WebContextFactory.get();
     HttpSession session = webContext.getSession();
     HttpServletRequest httpServletRequest = webContext.getHttpServletRequest();
  
     long userId = PortalUtil.getUserId(httpServletRequest);
     
     if (userId == 0) {
        throw new Exception("Must be logged in to run this.");
     }
     
     HttpServletRequest request = webContext.getHttpServletRequest();
     request.setAttribute("message", message);
     
     String html = webContext.forwardToString("/html/portlet/example/echo.jsp");
  
     return html; 
  }
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}