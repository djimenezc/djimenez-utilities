package com.djimenez.example.spring.mvc.web.taglib;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.djimenez.example.spring.mvc.constants.Constants;

/**
 * <p>
 * This class is designed to put all the public variables in a class to a
 * specified scope - designed for exposing a Constants class to Tag Libraries.
 * </p>
 * <p>
 * It is designed to be used as follows:
 * 
 * <pre>
 * &lt;tag:constants /&gt;
 * </pre>
 * 
 * </p>
 * <p>
 * Optional values are "className" (fully qualified) and "scope".
 * </p>
 * <p>
 * <a href="BaseAction.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class ConstantsTag extends TagSupport {

  private static final long serialVersionUID = 3258417209566116146L;
  private final Log log = LogFactory.getLog(ConstantsTag.class);

  /**
   * The class to expose the variables from.
   */
  private String clazz = Constants.class.getName();

  /**
   * The scope to be put the variable in.
   */
  private String scope;

  /**
   * The single variable to expose.
   */
  private String var;

  /**
   * Maps lowercase JSP scope names to their PageContext integer constant
   * values.
   */
  private static final Map<String, Integer> SCOPES =
    new HashMap<String, Integer>();

  /**
   * Initialize the scope names map and the encode variable
   */
  static {
    SCOPES.put("page", PageContext.PAGE_SCOPE);
    SCOPES.put("request", PageContext.REQUEST_SCOPE);
    SCOPES.put("session", PageContext.SESSION_SCOPE);
    SCOPES.put("application", PageContext.APPLICATION_SCOPE);
  }

  /**
   * Main method that does processing and exposes Constants in specified scope
   * 
   * @return int
   * @throws JspException
   *           if processing fails
   */
  @Override
  public final int doStartTag() throws JspException {

    // Using reflection, get the available field names in the class
    Class<?> c = null;
    int toScope = PageContext.PAGE_SCOPE;

    if (scope != null) {
      toScope = getScope(scope);
    }

    try {
      c = Class.forName(clazz);
    }
    catch (final ClassNotFoundException cnf) {
      log.error("ClassNotFound - maybe a typo?");
      throw new JspException(cnf.getMessage());
    }

    try {
      // if var is null, expose all variables
      if (var == null) {
        final Field[] fields = c.getDeclaredFields();

        AccessibleObject.setAccessible(fields, true);

        for (final Field field : fields) {
          pageContext.setAttribute(field.getName(), field.get(this), toScope);
        }
      }
      else {
        try {
          final Object value = c.getField(var).get(this);
          pageContext.setAttribute(c.getField(var).getName(), value, toScope);
        }
        catch (final NoSuchFieldException nsf) {
          log.error(nsf.getMessage());
          throw new JspException(nsf);
        }
      }
    }
    catch (final IllegalAccessException iae) {
      log.error("Illegal Access Exception - maybe a classloader issue?");
      throw new JspException(iae);
    }

    // Continue processing this page
    return (SKIP_BODY);
  }

  public final String getClassName() {
    return this.clazz;
  }

  public final String getScope() {
    return (this.scope);
  }

  /**
   * Converts the scope name into its corresponding PageContext constant value.
   * 
   * @param scopeName
   *          Can be "page", "request", "session", or "application" in any case.
   * @return The constant representing the scope (ie.
   *         PageContext.REQUEST_SCOPE).
   * @throws JspException
   *           if the scopeName is not a valid name.
   */
  public final int getScope(final String scopeName) throws JspException {

    final Integer scopeId = SCOPES.get(scopeName.toLowerCase());

    if (scopeId == null) {
      throw new JspException("Scope '" + scopeName + "' not a valid option");
    }

    return scopeId;
  }

  public final String getVar() {
    return (this.var);
  }

  /**
   * Release all allocated resources.
   */
  @Override
  public final void release() {
    super.release();
    clazz = null;
    scope = Constants.class.getName();
  }

  public final void setClassName(final String clazz) {
    this.clazz = clazz;
  }

  public final void setScope(final String scope) {
    this.scope = scope;
  }

  public final void setVar(final String var) {
    this.var = var;
  }
}
