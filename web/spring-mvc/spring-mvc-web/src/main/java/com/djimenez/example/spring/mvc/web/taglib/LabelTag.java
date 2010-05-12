package com.djimenez.example.spring.mvc.web.taglib;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Form;
import org.apache.commons.validator.ValidatorResources;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.Errors;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.RequestContext;
import org.springmodules.validation.commons.ValidatorFactory;

/**
 * <p>
 * This class is designed to render a <label> tag for labeling your forms and
 * adds an asterik (*) for required fields. It was originally written by Erik
 * Hatcher (http://www.ehatchersolutions.com/JavaDevWithAnt/).
 * <p>
 * It is designed to be used as follows:
 * 
 * <pre>
 * &lt;tag:label key="userForm.username"/&gt;
 * </pre>
 * 
 * @jsp.tag name="label" bodycontent="empty"
 */
public class LabelTag extends TagSupport {

  private static final long serialVersionUID = -5310144023136517119L;
  private RequestContext requestContext;
  // private transient final Log log = LogFactory.getLog(LabelTag.class);
  private String key = null;
  private String styleClass = null;
  private String errorClass = null;
  private boolean colon = false;

  private void addValidationErrorLabels(final boolean validationError,
    final Locale locale, final StringBuffer label) {
    if (validationError) {
      label.append("<img class=\"validationWarning\" alt=\"");
      label.append(getMessageSource().getMessage("icon.warning", null, locale));
      label.append("\"");

      final String context =
        ((HttpServletRequest) pageContext.getRequest()).getContextPath();

      label.append(" src=\"").append(context);
      label.append(getMessageSource().getMessage("icon.warning.img", null,
        locale));
      label.append("\" />");
    }
  }

  private StringBuffer buildLabel(final boolean requiredField,
    final boolean validationError, final Locale locale, final String fieldName,
    final String message, final String cssClass, final String cssErrorClass,
    final StringBuffer label) {

    if ((message == null) || "".equals(message.trim())) {
      label.append("");
    }
    else {
      label.append("<label for=\"").append(fieldName).append("\"");

      if (validationError) {
        label.append(" class=\"").append(cssErrorClass).append("\"");
      }
      else
        if (cssClass != null) {
          label.append(" class=\"").append(cssClass).append("\"");
        }

      label.append(">").append(message);
      label.append((requiredField) ? " <span class=\"req\">*</span>" : "");
      label.append((colon) ? ":" : "");
      label.append("</label>");

      addValidationErrorLabels(validationError, locale, label);
    }

    return label;
  }

  @Override
  public final int doStartTag() throws JspException {

    getRequest();

    // Look up this key to see if its a field of the current form
    boolean requiredField;
    boolean validationError;

    final ValidatorResources resources = getValidatorResources();

    final Locale locale = getLocale();

    // get the name of the bean from the key
    final String formName = key.substring(0, key.indexOf('.'));
    final String fieldName = key.substring(formName.length() + 1);

    requiredField = getField(resources, locale, formName, fieldName);

    final Errors errors = requestContext.getErrors(formName, false);

    validationError = isValidationError(fieldName, errors);

    final String message = retrievedMessage(locale);

    final String cssClass = getStyle(requiredField);

    final String cssErrorClass = (errorClass != null) ? errorClass : "error";
    StringBuffer label = new StringBuffer();

    label =
      buildLabel(requiredField, validationError, locale, fieldName, message,
        cssClass, cssErrorClass, label);

    printMessage(label);

    // Continue processing this page
    return (SKIP_BODY);
  }

  private boolean getField(final ValidatorResources resources,
    final Locale locale, final String formName, final String fieldName) {

    boolean requiredField = false;

    if (resources != null) {
      final Form form = resources.getForm(locale, formName);

      if (form != null) {
        final Field field = form.getField(fieldName);

        if (field != null) {
          if (field.isDependency("required") || field.isDependency("validwhen")) {
            requiredField = true;
          }
        }
      }
    }
    return requiredField;
  }

  private Locale getLocale() {
    Locale locale = pageContext.getRequest().getLocale();

    if (locale == null) {
      locale = Locale.getDefault();
    }
    return locale;
  }

  /**
   * Use the application context itself for default message resolution.
   */
  private MessageSource getMessageSource() {
    return requestContext.getWebApplicationContext();
  }

  /**
   * Extract the error messages from the given ObjectError list.
   */
  /*
   * private String getErrorMessages(List fes) throws NoSuchMessageException {
   * StringBuffer message = new StringBuffer(); for (int i = 0; i < fes.size();
   * i++) { ObjectError error = (ObjectError) fes.get(i);
   * message.append(this.requestContext.getMessage(error, true)); } return
   * message.toString(); }
   */

  private void getRequest() {
    try {
      this.requestContext =
        new RequestContext((HttpServletRequest) this.pageContext.getRequest());
    }
    catch (final RuntimeException ex) {
      throw ex;
    }
    catch (final Exception ex) {
      pageContext.getServletContext().log("Exception in custom tag", ex);
    }
  }

  private String getStyle(final boolean requiredField) {
    String cssClass = null;
    if (styleClass != null) {
      cssClass = styleClass;
    }
    else
      if (requiredField) {
        cssClass = "required";
      }
    return cssClass;
  }

  /**
   * Get the validator resources from a ValidatorFactory defined in the web
   * application context or one of its parent contexts. The bean is resolved by
   * type (org.springframework.validation.commons.ValidatorFactory).
   * 
   * @return ValidatorResources from a ValidatorFactory.
   */
  private ValidatorResources getValidatorResources() {
    // look in servlet beans definition (i.e. action-servlet.xml)
    WebApplicationContext ctx =
      (WebApplicationContext) pageContext.getRequest().getAttribute(
        DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    ValidatorFactory factory = null;
    try {
      factory =
        BeanFactoryUtils.beanOfTypeIncludingAncestors(ctx,
          ValidatorFactory.class, true, true);
    }
    catch (final NoSuchBeanDefinitionException e) {
      // look in main application context (i.e. applicationContext.xml)
      ctx =
        WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext
          .getServletContext());
      factory =
        BeanFactoryUtils.beanOfTypeIncludingAncestors(ctx,
          ValidatorFactory.class, true, true);
    }
    return factory.getValidatorResources();
  }

  private boolean isValidationError(final String fieldName, final Errors errors) {

    List<?> fes = null;
    boolean validationError = false;

    if (errors != null) {
      fes = errors.getFieldErrors(fieldName);
      // String errorMsg = getErrorMessages(fes);
    }

    if ((fes != null) && (fes.size() > 0)) {
      validationError = true;
    }

    return validationError;
  }

  /**
   * Print the retrieved message to our output writer
   * 
   * @param label
   * @throws JspException
   */
  private void printMessage(final StringBuffer label) throws JspException {

    try {
      writeMessage(label.toString());
    }
    catch (final IOException io) {
      io.printStackTrace();
      throw new JspException("Error writing label: " + io.getMessage());
    }
  }

  /**
   * Release all allocated resources.
   */
  @Override
  public final void release() {
    super.release();
    key = null;
    colon = false;
    styleClass = null;
    errorClass = null;
  }

  /**
   * Retrieve the message string we are looking for
   * 
   * @param locale
   * @return
   */
  private String retrievedMessage(final Locale locale) {
    String message = null;
    try {
      message = getMessageSource().getMessage(key, null, locale);
    }
    catch (final NoSuchMessageException nsm) {
      message = "???" + key + "???";
    }
    return message;
  }

  /**
   * Setter for specifying whether to include colon
   * 
   * @jsp.attribute required="false" rtexprvalue="true"
   */
  public final void setColon(final boolean colon) {
    this.colon = colon;
  }

  /**
   * Setter for assigning a CSS class when errors occur, defaults to labelError.
   * 
   * @jsp.attribute required="false" rtexprvalue="true"
   */
  public final void setErrorClass(final String errorClass) {
    this.errorClass = errorClass;
  }

  /**
   * @jsp.attribute required="true" rtexprvalue="true"
   */
  public final void setKey(final String key) {
    this.key = key;
  }

  /**
   * Setter for assigning a CSS class, default is label.
   * 
   * @jsp.attribute required="false" rtexprvalue="true"
   */
  public final void setStyleClass(final String styleClass) {
    this.styleClass = styleClass;
  }

  /**
   * Write the message to the page.
   * 
   * @param msg
   *          the message to write
   * @throws IOException
   *           if writing failed
   */
  protected final void writeMessage(final String msg) throws IOException {
    pageContext.getOut().write(msg);
  }
}
