package com.djimenez.util.internationalization;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.apache.log4j.Logger;

public final class CurrencyContextHolder implements CurrencyContext {

  private static Logger logger = Logger.getLogger(CurrencyContextHolder.class);

  private static CurrencyContext instance;

  public static CurrencyContext getInstance(final Locale locale) {
    if (instance == null) {
      instance = new CurrencyContextHolder(locale);
    }
    return instance;
  }

  private final NumberFormat currencyFormatter;

  private final Currency currency;

  private CurrencyContextHolder(final Locale locale) {
    this.currencyFormatter = this.defineCurrencyFormat(locale);
    this.currency = this.defineCurrency(locale);
  }

  private Currency defineCurrency(final Locale currentlocale) {
    final Currency cur = Currency.getInstance(currentlocale);
    logger.debug("Currency defined as " + cur);
    return cur;
  }

  private NumberFormat defineCurrencyFormat(final Locale currentLocale) {
    final NumberFormat numberFormat =
      NumberFormat.getCurrencyInstance(currentLocale);
    logger.debug("Currency formatted as " + numberFormat);
    return numberFormat;
  }

  @Override
  public Currency getCurrency() {
    return this.currency;
  }

  @Override
  public NumberFormat getCurrencyFormatter() {
    return this.currencyFormatter;
  }
}
