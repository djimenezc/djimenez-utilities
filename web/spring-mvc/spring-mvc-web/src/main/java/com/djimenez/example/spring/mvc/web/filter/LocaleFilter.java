package com.djimenez.example.spring.mvc.web.filter;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.djimenez.example.spring.mvc.constants.Constants;
import com.djimenez.example.spring.mvc.constants.ConstantsRole;

/**
 * Filter to wrap request with a request including user preferred locale.
 */
public class LocaleFilter extends OncePerRequestFilter {

  /**
   * This method looks for a "locale" request parameter. If it finds one, it
   * sets it as the preferred locale and also configures it to work with JSTL.
   * 
   * @param request
   *          the current request
   * @param response
   *          the current response
   * @param chain
   *          the chain
   * @throws IOException
   *           when something goes wrong
   * @throws ServletException
   *           when a communication failure happens
   */
  @Override
  @SuppressWarnings("unchecked")
  public final void doFilterInternal(HttpServletRequest request,
    final HttpServletResponse response, final FilterChain chain)
    throws IOException, ServletException {

    final String locale = request.getParameter("locale");
    Locale preferredLocale = null;

    if (locale != null) {
      final int indexOfUnderscore = locale.indexOf('_');
      if (indexOfUnderscore != -1) {
        final String language = locale.substring(0, indexOfUnderscore);
        final String country = locale.substring(indexOfUnderscore + 1);
        preferredLocale = new Locale(language, country);
      }
      else {
        preferredLocale = new Locale(locale);
      }
    }

    final HttpSession session = request.getSession(false);

    if (session != null) {
      if (preferredLocale == null) {
        preferredLocale =
          (Locale) session.getAttribute(Constants.PREFERRED_LOCALE_KEY);
      }
      else {
        session.setAttribute(Constants.PREFERRED_LOCALE_KEY, preferredLocale);
        Config.set(session, Config.FMT_LOCALE, preferredLocale);
      }

      if ((preferredLocale != null)
        && !(request instanceof LocaleRequestWrapper)) {
        request = new LocaleRequestWrapper(request, preferredLocale);
        LocaleContextHolder.setLocale(preferredLocale);
      }
    }

    final String theme = request.getParameter("theme");
    if ((theme != null) && request.isUserInRole(ConstantsRole.ADMIN_ROLE)) {
      final Map<String, Object> config =
        (Map) getServletContext().getAttribute(Constants.CONFIG);
      config.put(Constants.CSS_THEME, theme);
    }

    chain.doFilter(request, response);

    // Reset thread-bound LocaleContext.
    LocaleContextHolder.setLocaleContext(null);
  }
}