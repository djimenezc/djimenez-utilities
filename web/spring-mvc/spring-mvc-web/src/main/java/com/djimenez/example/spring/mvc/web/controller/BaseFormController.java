package com.djimenez.example.spring.mvc.web.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.djimenez.example.spring.mvc.constants.Constants;
import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.service.mail.MailEngine;
import com.djimenez.example.spring.mvc.service.user.UserManager;

/**
 * Implementation of <strong>SimpleFormController</strong> that contains
 * convenience methods for subclasses. For example, getting the current user and
 * saving messages/errors. This class is intended to be a base class for all
 * Form controllers.
 * <p>
 * <a href="BaseFormController.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public abstract class BaseFormController extends SimpleFormController {

  protected final transient Log log = LogFactory.getLog(getClass());
  public static final String MESSAGES_KEY = "successMessages";
  private UserManager userManager = null;
  protected MailEngine mailEngine = null;
  protected SimpleMailMessage message = null;
  protected String templateName = null;
  protected String cancelView;

  public String getCancelView() {
    // Default to successView if cancelView is invalid
    if ((this.cancelView == null) || (this.cancelView.length() == 0)) {
      return getSuccessView();
    }
    return this.cancelView;
  }

  /**
   * Convenience method to get the Configuration HashMap from the servlet
   * context.
   * 
   * @return the user's populated form from the session
   */
  public Map getConfiguration() {
    final Map config =
      (HashMap) getServletContext().getAttribute(Constants.CONFIG);

    // so unit tests don't puke when nothing's been set
    if (config == null) {
      return new HashMap();
    }

    return config;
  }

  /**
   * Convenience method for getting a i18n key's value. Calling
   * getMessageSourceAccessor() is used because the RequestContext variable is
   * not set in unit tests b/c there's no DispatchServlet Request.
   * 
   * @param msgKey
   * @param locale
   *          the current locale
   * @return
   */
  public String getText(final String msgKey, final Locale locale) {
    return getMessageSourceAccessor().getMessage(msgKey, locale);
  }

  /**
   * Convenience method for getting a i18n key's value with arguments.
   * 
   * @param msgKey
   * @param args
   * @param locale
   *          the current locale
   * @return
   */
  public String getText(final String msgKey, final Object[] args,
    final Locale locale) {
    return getMessageSourceAccessor().getMessage(msgKey, args, locale);
  }

  /**
   * Convenient method for getting a i18n key's value with a single string
   * argument.
   * 
   * @param msgKey
   * @param arg
   * @param locale
   *          the current locale
   * @return
   */
  public String getText(final String msgKey, final String arg,
    final Locale locale) {
    return getText(msgKey, new Object[] { arg }, locale);
  }

  public UserManager getUserManager() {
    return this.userManager;
  }

  /**
   * Set up a custom property editor for converting form inputs to real objects
   */
  @Override
  protected void initBinder(final HttpServletRequest request,
    final ServletRequestDataBinder binder) {
    binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(
      Integer.class, null, true));
    binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(
      Long.class, null, true));
    binder.registerCustomEditor(byte[].class,
      new ByteArrayMultipartFileEditor());
    final SimpleDateFormat dateFormat =
      new SimpleDateFormat(getText("date.format", request.getLocale()));
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
      dateFormat, true));
  }

  /**
   * Default behavior for FormControllers - redirect to the successView when the
   * cancel button has been pressed.
   */
  @Override
  public ModelAndView processFormSubmission(final HttpServletRequest request,
    final HttpServletResponse response, final Object command,
    final BindException errors) throws Exception {
    if (request.getParameter("cancel") != null) {
      return new ModelAndView(getCancelView());
    }

    return super.processFormSubmission(request, response, command, errors);
  }

  @SuppressWarnings("unchecked")
  public void saveError(final HttpServletRequest request, final String error) {
    List errors = (List) request.getSession().getAttribute("errors");
    if (errors == null) {
      errors = new ArrayList();
    }
    errors.add(error);
    request.getSession().setAttribute("errors", errors);
  }

  @SuppressWarnings("unchecked")
  public void saveMessage(final HttpServletRequest request, final String msg) {
    List messages = (List) request.getSession().getAttribute(MESSAGES_KEY);

    if (messages == null) {
      messages = new ArrayList();
    }

    messages.add(msg);
    request.getSession().setAttribute(MESSAGES_KEY, messages);
  }

  /**
   * Convenience message to send messages to users, includes app URL as footer.
   * 
   * @param user
   * @param msg
   * @param url
   */
  protected void sendUserMessage(final User user, final String msg,
    final String url) {
    if (log.isDebugEnabled()) {
      log.debug("sending e-mail to user [" + user.getEmail() + "]...");
    }

    message.setTo(user.getFullName() + "<" + user.getEmail() + ">");

    final Map<String, Serializable> model = new HashMap<String, Serializable>();
    model.put("user", user);

    // TODO: once you figure out how to get the global resource bundle in
    // WebWork, then figure it out here too. In the meantime, the Username
    // and Password labels are hard-coded into the template.
    // model.put("bundle", getTexts());
    model.put("message", msg);
    model.put("applicationURL", url);
    mailEngine.sendMessage(message, templateName, model);
  }

  /**
   * Indicates what view to use when the cancel button has been pressed.
   */
  public void setCancelView(final String cancelView) {
    this.cancelView = cancelView;
  }

  public void setMailEngine(final MailEngine mailEngine) {
    this.mailEngine = mailEngine;
  }

  public void setMessage(final SimpleMailMessage message) {
    this.message = message;
  }

  public void setTemplateName(final String templateName) {
    this.templateName = templateName;
  }

  public void setUserManager(final UserManager userManager) {
    this.userManager = userManager;
  }

}
