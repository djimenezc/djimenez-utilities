package com.djimenez.util.internationalization;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.djimenez.util.configuration.date.DateConfigurationFileHelper;
import com.djimenez.util.constants.SystemConstants;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public final class DateContextHolder implements DateContext {

  private static Logger logger = Logger.getLogger(DateContextHolder.class);

  private static DateContext instance;

  public static DateContext getInstance(final Locale locale) {
    if (instance == null) {
      instance = new DateContextHolder(locale);
    }
    return instance;
  }

  private final DateFormat dateFormatter;

  private final DateFormat timeFormatter;

  private final DateFormat dateAndTimeFormatter;

  private final TimeZone timeZone;

  private final Locale locale;

  private DateContextHolder(final Locale locale) {

    this.locale = locale;
    this.timeZone = this.defineTimeZone();
    this.dateFormatter = this.defineDateFormat(locale, this.timeZone);
    this.timeFormatter = this.defineTimeFormat(locale, this.timeZone);
    this.dateAndTimeFormatter =
      this.defineDateAndTimeFormat(locale, this.timeZone);
  }

  private DateFormat defineDateAndTimeFormat(final Locale currentLocale,
    final TimeZone currentTimeZone) {
    final DateFormat dateFormat =
      DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
        currentLocale);
    dateFormat.setTimeZone(currentTimeZone);

    logger.debug("Date And Time formatted as " + dateFormat.getTimeZone());
    return dateFormat;
  }

  private DateFormat defineDateFormat(final Locale currentLocale,
    final TimeZone currentTimeZone) {

    final DateFormat dateFormat =
      DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);

    dateFormat.setTimeZone(currentTimeZone);

    logger.debug("Date formatted as " + dateFormat);

    return dateFormat;
  }

  private DateFormat defineTimeFormat(final Locale currentLocale,
    final TimeZone currentTimeZone) {

    final DateFormat dateFormat =
      DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);

    dateFormat.setTimeZone(currentTimeZone);

    logger.debug("Time formatted as " + dateFormat);

    return dateFormat;
  }

  private TimeZone defineTimeZone() {

    String id = SystemConstants.DEFAULT_TIMEZONE;

    TimeZone tz = null;

    try {
      id =
        DateConfigurationFileHelper.getInstance().getProperty("date.timezone");
    }
    catch (final Exception e) {
    }
    finally {
      tz = TimeZone.getTimeZone(id);
      logger.debug("Timezone defined as " + tz.toString());
    }
    return tz;
  }

  @Override
  public Calendar getCalendar() {
    return Calendar.getInstance(this.locale);
  }

  @Override
  public DateFormat getDateAndTimeFormatter() {
    return this.dateAndTimeFormatter;
  }

  @Override
  public DateFormat getDateFormatter() {
    return this.dateFormatter;
  }

  @Override
  public DateFormat getTimeFormatter() {
    return this.timeFormatter;
  }

  @Override
  public TimeZone getTimeZone() {
    return this.timeZone;
  }
}
