package com.djimenez.util.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.djimenez.util.internationalization.DateHelper;
import com.djimenez.util.internationalization.InternationalizationContextHolder;
import com.djimenez.util.internationalization.InternationalizationException;
import com.djimenez.util.properties.ConfigurationHelperFO;

/**
 * Manager date with Internationalization
 * 
 * @author mla003es
 */
public class DateHelperFO {

  private static final Logger logger = Logger.getLogger(DateHelper.class);
  private static final String FORMAT_HOUR =
    ConfigurationHelperFO.getInstance().getProperty("hour.format");
  private static final String FORMAT_DATE_SLASH_INVERTED =
    ConfigurationHelperFO.getInstance().getProperty(
      "date.format.slash.inverted");
  private static final String FORMAT_DATE_HYPHEN =
    ConfigurationHelperFO.getInstance().getProperty("date.format.hyphen");
  private static final String DATE_PATTERN =
    ConfigurationHelperFO.getInstance().getProperty("date.pattern");
  private static final String FORMAT_HOUR_MIN =
    ConfigurationHelperFO.getInstance().getProperty("hour.minutes.format");
  private static final String DATE_TIME_PATTERN =
    ConfigurationHelperFO.getInstance().getProperty("date.time.pattern");
  private static final String DATE_PATTERN_TICKET_PARKING_EAN =
    ConfigurationHelperFO.getInstance().getProperty(
      "date.pattern.ticket.parking.ean");
  private static final String DATE_PATTERN_TICKET_PARKING_TEXT =
    ConfigurationHelperFO.getInstance().getProperty(
      "date.pattern.ticket.parking.text");
  private static final String DATE_PATTERN_INVOICE =
    ConfigurationHelperFO.getInstance().getProperty("date.invoice.pattern");
  private static final String DATE_PATTERN_CONFIGURATION =
    ConfigurationHelperFO.getInstance().getProperty(
      "date.pattern.configuration");

  /**
   * Parser a date to object Calendar internationalization
   * 
   * @param date
   * @return
   */
  public static Calendar dateToCalendar(final Date date) {
    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    calendar.setTime(date);
    return calendar;

  }

  /**
   * Parser date to String with HYPHEN
   * 
   * @param date
   * @return string
   */

  public static String dateToStringHyphen(final Date date) {

    final SimpleDateFormat simpleDateFormatSlashInverted =
      new SimpleDateFormat(FORMAT_DATE_HYPHEN);
    return simpleDateFormatSlashInverted.format(date);
  }

  /**
   * Parse a date to string with pattern ddMMyyy
   * 
   * @param date
   * @return
   */
  public static String dateToStringPatternKeyBoard(final Date date) {
    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(DATE_PATTERN);
    return simpleDateFormat.format(date);
  }

  /**
   * Parser date to String with slash inverted
   * 
   * @param date
   * @return string
   */

  public static String dateToStringSlashInverted(final Date date) {
    final SimpleDateFormat simpleDateFormatSlashInverted =
      new SimpleDateFormat(FORMAT_DATE_SLASH_INVERTED);
    return simpleDateFormatSlashInverted.format(date);
  }

  /**
   * Return current date in Calendar
   * 
   * @return Long
   */
  public static Calendar getCurrentCalendar() {

    return InternationalizationContextHolder.getInstance().getDateContext()
      .getCalendar();
  }

  /**
   * Return the actual date with InternationalizationContextHolder, without
   * hour, minutes or seconds
   * 
   * @return
   */
  public static Date getCurrentDate() {

    return new Date(DateHelperFO.getLongCurrentDateWithoutTime());
  }

  /**
   * Return the actual date with InternationalizationContextHolder
   * 
   * @return
   */
  public static Date getCurrentDatetime() {

    return new Date(DateHelper.getLongCurrentDate());
  }

  /**
   * Return current date in Long without time
   * 
   * @return Long
   */
  public static Long getLongCurrentDateWithoutTime() {

    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    calendar.clear(Calendar.HOUR);

    return calendar.getTimeInMillis();
  }

  /**
   * Return current date in String with pattern ddMMyyyy
   * 
   * @return String
   */
  public static String getStringCurrentDate() {

    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(DATE_PATTERN);
    final Date hoy = new Date(calendar.getTimeInMillis());
    return simpleDateFormat.format(hoy);
  }

  /**
   * Parse date to format parking ticket (HHMMDDMMAA)
   * 
   * @param date
   * @return
   */
  public static String getStringDateForTicketParking(final Date date) {

    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(DATE_PATTERN_TICKET_PARKING_EAN);
    return simpleDateFormat.format(date);
  }

  /**
   * Parse date to format invoice ticket (dd-MM-yyyy HH:mm)
   * 
   * @param date
   * @return
   */
  public static String getStringDateTextForTicketInvoice(final Date date) {

    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(DATE_PATTERN_INVOICE);
    return simpleDateFormat.format(date);
  }

  /**
   * Parse date to format parking ticket (dd/MM/yyyy HH:mm)
   * 
   * @param date
   * @return
   */
  public static String getStringDateTextForTicketParking(final Date date) {

    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(DATE_PATTERN_TICKET_PARKING_TEXT);
    return simpleDateFormat.format(date);
  }

  /**
   * Check pattern date (ddMMyyyy)
   * 
   * @param date
   * @return
   */
  public static Boolean isDateValidKeyBoard(final String date) {
    Boolean valid = Boolean.FALSE;

    if (date.length() == 8) {
      final SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat("ddMMyyyy");
      try {
        if (simpleDateFormat.format((simpleDateFormat.parse(date)))
          .equals(date)) {
          valid = Boolean.TRUE;
        }
      }
      catch (final Exception e) {
        valid = Boolean.FALSE;
      }
    }
    return valid;
  }

  /**
   * Check pattern hour (HHmm or HHmmSS)
   * 
   * @param date
   * @return
   */
  public static boolean isHourValid(final String hour) {
    boolean res = false;
    final SimpleDateFormat simpleHourMinFormat =
      new SimpleDateFormat(FORMAT_HOUR_MIN);
    final SimpleDateFormat simpleHourFormat = new SimpleDateFormat(FORMAT_HOUR);
    try {
      simpleHourFormat.parse(hour);
      final long hh = Long.parseLong(hour.substring(0, 2));
      final long mm = Long.parseLong(hour.substring(2, 4));
      if ((hh < 24) && (hh >= 0) && (mm < 60) && (mm >= 0)) {
        res = true;
      }
    }
    catch (final ParseException e) {
      try {
        simpleHourMinFormat.parse(hour);
        final long hh = Long.parseLong(hour.substring(0, 2));
        final long mm = Long.parseLong(hour.substring(2, 4));
        final long ss = Long.parseLong(hour.substring(4, 6));
        if ((hh < 24) && (hh >= 0) && (mm < 60) && (mm >= 0) && (ss < 60)
          && (ss >= 0)) {
          res = true;
        }
      }
      catch (final Exception ex) {
        res = false;
      }
    }
    catch (final Exception ex2) {
      res = false;
    }
    return res;
  }

  /**
   * Parser a string to object Calendar internationalization. Only the date,
   * without the time
   * 
   * @param dateString
   * @return
   */
  public static Calendar stringToCalendar(final String dateString) {

    return stringToCalendarByDatePattern(dateString, DATE_PATTERN);
  }

  /**
   * Parser a string to object Calendar internationalization applying a specific
   * date pattern
   * 
   * @param dateString
   * @param datePattern
   * @return
   */
  public static Calendar stringToCalendarByDatePattern(final String dateString,
    final String datePattern) {

    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();

    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

    try {
      final Date date = simpleDateFormat.parse(dateString);
      calendar.setTime(date);
    }
    catch (final ParseException e) {
      logger.info(e.getMessage());
      throw new InternationalizationException("Can't parse date " + dateString,
        e);
    }
    return calendar;
  }

  public static Calendar stringToDate(final String dateString) {

    return stringToCalendarByDatePattern(dateString, DATE_PATTERN_CONFIGURATION);
  }

  /**
   * Parser a string to object Calendar internationalization with time
   * 
   * @param dateString
   * @return
   */
  public static Calendar stringToDateTime(final String dateString) {

    return stringToCalendarByDatePattern(dateString, DATE_TIME_PATTERN);
  }

}
