package com.djimenez.example.spring.mvc.web.taglib;

import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.displaytag.tags.el.ExpressionEvaluator;

import com.djimenez.example.spring.mvc.model.LabelValue;

/**
 * Tag for creating multiple &lt;select&gt; options for displaying a list of
 * country names.
 * <p>
 * <b>NOTE</b> - This tag requires a Java2 (JDK 1.2 or later) platform.
 * </p>
 * 
 * @author Jens Fischer, Matt Raible
 * @version $Revision: 1.6 $ $Date: 2006/07/15 11:57:20 $
 * @jsp.tag name="country" bodycontent="empty"
 */
public class CountryTag extends TagSupport {

  /**
   * Class to compare LabelValues using their labels with locale-sensitive
   * behaviour.
   */
  public static class LabelValueComparator implements Comparator<Object> {

    private final Collator c;

    /**
     * Creates a new LabelValueComparator object.
     * 
     * @param locale
     *          The Locale used for localized String comparison.
     */
    public LabelValueComparator(final Locale locale) {
      c = Collator.getInstance(locale);
    }

    /**
     * Compares the localized labels of two LabelValues.
     * 
     * @param o1
     *          The first LabelValue to compare.
     * @param o2
     *          The second LabelValue to compare.
     * @return The value returned by comparing the localized labels.
     */
    public final int compare(final Object o1, final Object o2) {
      final LabelValue lhs = (LabelValue) o1;
      final LabelValue rhs = (LabelValue) o2;

      return c.compare(lhs.getLabel(), rhs.getLabel());
    }
  }

  private static final long serialVersionUID = 3905528206810167095L;
  private String name;
  private String prompt;
  private String scope;

  private String selected;

  /**
   * Build a List of LabelValues for all the available countries. Uses the two
   * letter uppercase ISO name of the country as the value and the localized
   * country name as the label.
   * 
   * @param locale
   *          The Locale used to localize the country names.
   * @return List of LabelValues for all available countries.
   */
  protected final List<LabelValue> buildCountryList(final Locale locale) {

    final String empty = "";
    final Locale[] available = Locale.getAvailableLocales();

    final List<LabelValue> countries = new ArrayList<LabelValue>();

    for (final Locale element : available) {

      final String iso = element.getCountry();

      final String nameContry = element.getDisplayCountry(locale);

      if (!empty.equals(iso) && !empty.equals(nameContry)) {

        final LabelValue country = new LabelValue(nameContry, iso);

        if (!countries.contains(country)) {
          countries.add(new LabelValue(nameContry, iso));
        }
      }
    }

    Collections.sort(countries, new LabelValueComparator(locale));

    return countries;
  }

  /**
   * Process the start of this tag.
   * 
   * @return int status
   * @exception JspException
   *              if a JSP exception has occurred
   * @see javax.servlet.jsp.tagext.Tag#doStartTag()
   */
  @Override
  public final int doStartTag() throws JspException {
    final ExpressionEvaluator eval = new ExpressionEvaluator(this, pageContext);

    if (selected != null) {
      selected = eval.evalString("default", selected);
    }

    final Locale userLocale = pageContext.getRequest().getLocale();
    final List<LabelValue> countries = this.buildCountryList(userLocale);

    if (scope != null) {
      includeCountriesByScope(countries);
    }
    else {
      final StringBuffer sb = new StringBuffer();
      sb.append("<select name=\"" + name + "\" id=\"" + name
        + "\" class=\"select\">\n");

      if (prompt != null) {
        sb.append("    <option value=\"\" selected=\"selected\">");
        sb.append(eval.evalString("prompt", prompt));
        sb.append("</option>\n");
      }

      markSelectedCountry(countries, sb);

      sb.append("</select>");

      try {
        pageContext.getOut().write(sb.toString());
      }
      catch (final IOException io) {
        throw new JspException(io);
      }
    }

    return super.doStartTag();
  }

  private void includeCountriesByScope(final List<LabelValue> countries)
    throws JspException {

    if (scope.equals("page")) {
      pageContext.setAttribute(name, countries);
    }
    else
      if (scope.equals("request")) {
        pageContext.getRequest().setAttribute(name, countries);
      }
      else
        if (scope.equals("session")) {
          pageContext.getSession().setAttribute(name, countries);
        }
        else
          if (scope.equals("application")) {
            pageContext.getServletContext().setAttribute(name, countries);
          }
          else {
            throw new JspException(
              "Attribute 'scope' must be: page, request, session or application");
          }
  }

  private void markSelectedCountry(final List<LabelValue> countries,
    final StringBuffer sb) {
    for (final LabelValue country : countries) {
      sb.append("    <option value=\"" + country.getValue() + "\"");

      if ((selected != null) && selected.equals(country.getValue())) {
        sb.append(" selected=\"selected\"");
      }

      sb.append(">" + country.getLabel() + "</option>\n");
    }
  }

  /**
   * Release aquired resources to enable tag reusage.
   * 
   * @see javax.servlet.jsp.tagext.Tag#release()
   */
  @Override
  public final void release() {
    super.release();
  }

  /**
   * @param selected
   *          The selected option.
   * @jsp.attribute required="false" rtexprvalue="true"
   */
  public final void setDefault(final String selected) {
    this.selected = selected;
  }

  /**
   * @param name
   *          The name to set.
   * @jsp.attribute required="false" rtexprvalue="true"
   */
  public final void setName(final String name) {
    this.name = name;
  }

  /**
   * @param prompt
   *          The prompt to set.
   * @jsp.attribute required="false" rtexprvalue="true"
   */
  public final void setPrompt(final String prompt) {
    this.prompt = prompt;
  }

  /**
   * Property used to simply stuff the list of countries into a specified scope.
   * 
   * @param scope
   * @jsp.attribute required="false" rtexprvalue="true"
   */
  public final void setToScope(final String scope) {
    this.scope = scope;
  }
}
