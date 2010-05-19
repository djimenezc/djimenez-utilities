package com.djimenez.example.spring.mvc.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.MailException;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.service.role.RoleManager;
import com.djimenez.example.spring.mvc.service.user.UserExistsException;
import com.djimenez.example.spring.mvc.web.util.RequestUtil;

/**
 * Controller to signup new users.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class SignupController extends BaseFormController {

  private RoleManager roleManager;

  public SignupController() {
    setCommandName("user");
    setCommandClass(User.class);
  }

  @Override
  public ModelAndView onSubmit(final HttpServletRequest request,
    final HttpServletResponse response, final Object command,
    final BindException errors) throws Exception {
    if (LOG.isDebugEnabled()) {
      LOG.debug("entering 'onSubmit' method...");
    }

    final User user = (User) command;
    final Locale locale = request.getLocale();

    user.setEnabled(true);

    // Set the default user role on this new user
    user.addRole(roleManager.getRole(ConstantsRole.USER_ROLE));

    try {
      this.getUserManager().saveUser(user);
    }
    catch (final AccessDeniedException ade) {
      // thrown by UserSecurityAdvice configured in aop:advisor
      // userManagerSecurity
      LOG.warn(ade.getMessage());
      response.sendError(HttpServletResponse.SC_FORBIDDEN);
      return null;
    }
    catch (final UserExistsException e) {
      errors.rejectValue("username", "errors.existing.user", new Object[] {
        user.getUsername(), user.getEmail() }, "duplicate user");

      // redisplay the unencrypted passwords
      user.setPassword(user.getConfirmPassword());
      return showForm(request, response, errors);
    }

    saveMessage(request, getText("user.registered", user.getUsername(), locale));
    request.getSession().setAttribute(ConstantsRole.REGISTERED, Boolean.TRUE);

    // log user in automatically
    final UsernamePasswordAuthenticationToken auth =
      new UsernamePasswordAuthenticationToken(user.getUsername(), user
        .getConfirmPassword(), user.getAuthorities());
    auth.setDetails(user);
    SecurityContextHolder.getContext().setAuthentication(auth);

    // Send user an e-mail
    if (LOG.isDebugEnabled()) {
      LOG.debug("Sending user '" + user.getUsername()
        + "' an account information e-mail");
    }

    // Send an account information e-mail
    getMessage().setSubject(getText("signup.email.subject", locale));

    try {
      sendUserMessage(user, getText("signup.email.message", locale),
        RequestUtil.getAppURL(request));
    }
    catch (final MailException me) {
      saveError(request, me.getMostSpecificCause().getMessage());
    }

    return new ModelAndView(getSuccessView());
  }

  public void setRoleManager(final RoleManager roleManager) {
    this.roleManager = roleManager;
  }
}
