package com.djimenez.example.spring.mvc.web.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * HttpRequestWrapper overriding methods getLocale(), getLocales() to include
 * the user's preferred locale.
 */
public class LocaleRequestWrapper extends HttpServletRequestWrapper {

  private final transient Log log =
    LogFactory.getLog(LocaleRequestWrapper.class);
  private final Locale preferredLocale;

  /**
   * Sets preferred local to user's locale
   * 
   * @param decorated
   *          the current decorated request
   * @param userLocale
   *          the user's locale
   */
  public LocaleRequestWrapper(final HttpServletRequest decorated,
    final Locale userLocale) {
    super(decorated);
    preferredLocale = userLocale;
    if (null == preferredLocale) {
      log.error("preferred locale = null, it is an unexpected value!");
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final Locale getLocale() {
    if (null != preferredLocale) {
      return preferredLocale;
    }
    else {
      return super.getLocale();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @SuppressWarnings("unchecked")
  public final Enumeration<Locale> getLocales() {
    if (null != preferredLocale) {
      final List<Locale> l = Collections.list(super.getLocales());
      if (l.contains(preferredLocale)) {
        l.remove(preferredLocale);
      }
      l.add(0, preferredLocale);
      return Collections.enumeration(l);
    }
    else {
      return super.getLocales();
    }
  }

}