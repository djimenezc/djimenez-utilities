package com.djimenez.util.internationalization;

import java.util.Locale;

import org.apache.log4j.Logger;

import com.djimenez.util.constants.SystemConstants;
import com.djimenez.util.properties.internationalization.InternationalizationConfigurationFileHelper;

/**
 * @author a.pastoriza.barcia
 * @version 1.1
 */
public final class InternationalizationContextHolder {

  private static Logger logger =
    Logger.getLogger(InternationalizationContextHolder.class);

  private static InternationalizationContextHolder instance;

  public static InternationalizationContextHolder getInstance() {

    if (instance == null) {
      instance = new InternationalizationContextHolder();
    }
    return instance;
  }

  private final Locale locale;

  private InternationalizationContextHolder() {

    this.locale = this.defineLocale();
  }

  private Locale defineLocale() {

    String language = SystemConstants.DEFAULT_LANGUAGE;
    String country = SystemConstants.DEFAULT_COUNTRY;

    Locale loc;

    try {
      country =
        InternationalizationConfigurationFileHelper.getInstance().getProperty(
          "locale.country");
      language =
        InternationalizationConfigurationFileHelper.getInstance().getProperty(
          "locale.language");
    }
    catch (final Exception e) {
    }
    finally {
      loc = new Locale(language, country);
      logger.debug("Locale defined as " + loc.toString());
    }
    return loc;
  }

  public CurrencyContext getCurrencyContext() {
    return CurrencyContextHolder.getInstance(this.locale);
  }

  public DateContext getDateContext() {

    return DateContextHolder.getInstance(this.locale);
  }

  public Locale getLocale() {
    return this.locale;
  }

  public NumericContext getNumericContext() {
    return NumericContextHolder.getInstance(this.locale);
  }

}
