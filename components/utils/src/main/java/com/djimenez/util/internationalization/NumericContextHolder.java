package com.djimenez.util.internationalization;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public final class NumericContextHolder implements NumericContext {

  private static Logger logger = Logger.getLogger(NumericContextHolder.class);
  private static NumericContextHolder instance;

  public static NumericContextHolder getInstance(final Locale locale) {
    if (instance == null) {
      instance = new NumericContextHolder(locale);
    }

    return instance;
  }

  private final NumberFormat numberFormatter;
  private final NumberFormat percentFormatter;

  private final DecimalFormat decimalFormatter;

  private NumericContextHolder(final Locale locale) {
    this.numberFormatter = this.defineNumberFormat(locale);
    this.percentFormatter = this.definePercentFormat(locale);
    this.decimalFormatter = this.defineDecimalFormat();
  }

  private DecimalFormat defineDecimalFormat() {
    final DecimalFormat decimalFormat = new DecimalFormat();
    final DecimalFormatSymbols decimalFormatSymbols =
      new DecimalFormatSymbols();
    decimalFormatSymbols.setDecimalSeparator('.');
    decimalFormat.setGroupingUsed(false);
    decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
    logger.debug("Percent formatted as " + decimalFormat);
    return decimalFormat;
  }

  private NumberFormat defineNumberFormat(final Locale currentLocale) {
    final NumberFormat numberFormat =
      NumberFormat.getNumberInstance(currentLocale);
    numberFormat.setGroupingUsed(false);
    logger.debug("Number formatted as " + numberFormat);
    return numberFormat;
  }

  private NumberFormat definePercentFormat(final Locale currentLocale) {
    final NumberFormat numberFormat =
      NumberFormat.getPercentInstance(currentLocale);
    logger.debug("Percent formatted as " + numberFormat);
    return numberFormat;
  }

  @Override
  public DecimalFormat getDecimalFormatter() {
    return this.decimalFormatter;
  }

  @Override
  public NumberFormat getNumberFormatter() {
    return this.numberFormatter;
  }

  @Override
  public NumberFormat getPercentFormatter() {
    return this.percentFormatter;
  }
}
