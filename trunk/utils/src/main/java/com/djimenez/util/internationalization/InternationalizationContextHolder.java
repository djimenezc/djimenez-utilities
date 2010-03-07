package com.djimenez.util.internationalization;

import java.util.Locale;

import org.apache.log4j.Logger;

import com.djimenez.util.configuration.ConfigurationHelper;

/**
 * @author a.pastoriza.barcia
 * @version 1.1
 */
public final class InternationalizationContextHolder {

  private static final Logger logger =
    Logger.getLogger(InternationalizationContextHolder.class);

  private static final String DEFAULT_LANGUAGE = "es";
  private static final String DEFAULT_COUNTRY = "ES";

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
    String language = DEFAULT_LANGUAGE;
    String country = DEFAULT_COUNTRY;
    Locale loc = null;
    try {
      country = ConfigurationHelper.getInstance().getProperty("locale.country");
      language =
        ConfigurationHelper.getInstance().getProperty("locale.language");
    }
    finally {
      loc = new Locale(language, country);
      logger.debug("Locale defined as " + loc);
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
