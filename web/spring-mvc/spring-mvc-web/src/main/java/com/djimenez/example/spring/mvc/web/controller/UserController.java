package com.djimenez.example.spring.mvc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.service.user.UserManager;

/**
 * Simple class to retrieve a list of users from the database.
 * <p>
 * <a href="UserController.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserController implements Controller {

  private final transient Log log = LogFactory.getLog(UserController.class);
  private UserManager mgr = null;

  public ModelAndView handleRequest(final HttpServletRequest request,
    final HttpServletResponse response) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug("entering 'handleRequest' method...");
    }

    return new ModelAndView("admin/userList", ConstantsRole.USER_LIST, mgr
      .getUsers());
  }

  public void setUserManager(final UserManager userManager) {
    this.mgr = userManager;
  }
}
