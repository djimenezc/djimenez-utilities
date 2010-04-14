package com.djimenez.util.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.djimenez.util.internationalization.InternationalizationContextHolder;
import com.djimenez.util.internationalization.InternationalizationException;
import com.djimenez.util.properties.date.DatePropertyHelper;

/**
 * Manager date with Internationalization
 * 
 * @author djimenez
 */
public class DateHelper {

  private static final Logger logger = Logger.getLogger(DateHelper.class);

  private static DateHelper instance;

  public static DateHelper getInstance() {

    if (instance == null) {
      instance = new DateHelper();
    }

    return instance;
  }

  private DateHelper() {
    super();
  }

  /**
   * Method to check if date is before today.
   * 
   * @param date
   * @return true date is grater today false date is minor or equal today
   */
  public Boolean checkDateBeforeToday(final Date date) {
    final Date actualDate =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar().getTime();
    return Boolean.valueOf(actualDate.before(date));
  }

  public Boolean checkDateIntoRange(final Date dateToCheck, final Date refDate,
    final int days) {

    final Calendar cal = new GregorianCalendar();
    cal.setTimeInMillis(refDate.getTime());
    cal.add(Calendar.DATE, days);
    final Date calcDate = new Date(cal.getTimeInMillis());
    Boolean valid = Boolean.FALSE;
    if (days >= 0) {
      if ((dateToCheck.after(refDate) || dateToCheck.equals(refDate))
        && dateToCheck.before(calcDate)) {
        valid = Boolean.TRUE;
      }
    }
    else {
      if ((dateToCheck.after(calcDate) || dateToCheck.equals(calcDate))
        && dateToCheck.before(refDate)) {
        valid = Boolean.TRUE;
      }
    }
    return valid;
  }

  /**
   * This method return true if (date <= today && date >= today - days)
   * 
   * @param date
   * @param days
   * @return true if (date <= today && date >= today - days)
   */
  public Boolean checkDateNotAfterLimit(final Date date, final Integer days) {

    final Calendar actualDateCalendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();

    actualDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
    actualDateCalendar.set(Calendar.MINUTE, 0);
    actualDateCalendar.set(Calendar.SECOND, 0);
    actualDateCalendar.set(Calendar.MILLISECOND, 0);
    final Date actualDate = actualDateCalendar.getTime();

    final Calendar c =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    c.setTime(date);
    c.add(Calendar.DAY_OF_YEAR, days.intValue());
    final Date prev = c.getTime();

    return Boolean.valueOf(actualDate.equals(prev) || actualDate.before(prev));
  }

  public Boolean checkDateNotExceedLimit(final Date dateToCheck,
    final Date refDate, final int days) {
    final Calendar cal = new GregorianCalendar();
    cal.setTimeInMillis(refDate.getTime());
    cal.add(Calendar.DATE, days);
    final Date calcDate = new Date(cal.getTimeInMillis());
    Boolean valid = Boolean.TRUE;
    if (days >= 0) {
      if (dateToCheck.after(calcDate)) {
        valid = Boolean.FALSE;
      }
    }
    else {
      if (dateToCheck.before(calcDate)) {
        valid = Boolean.FALSE;
      }
    }
    return valid;
  }

  /**
   * Method to check if date is today.
   * 
   * @param date
   * @return true date is equals today false date is not equals today
   */
  public Boolean checkDateToday(final Date date) {
    final Calendar actualDate =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    final Calendar newDate =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    newDate.setTime(date);
    return Boolean.valueOf((actualDate.get(Calendar.DAY_OF_MONTH) == newDate
      .get(Calendar.DAY_OF_MONTH))
      && (actualDate.get(Calendar.MONTH) == newDate.get(Calendar.MONTH))
      && (actualDate.get(Calendar.YEAR) == newDate.get(Calendar.YEAR)));
  }

  /**
   * Parser a date to object Calendar internationalization
   * 
   * @param date
   * @return
   */
  public Calendar dateToCalendar(final Date date) {
    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    calendar.setTime(date);
    return calendar;

  }

  public String dateToString(final Date date, final String pattern) {
    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(pattern, InternationalizationContextHolder
        .getInstance().getLocale());
    return simpleDateFormat.format(date);
  }

  /**
   * Parser date to String with HYPHEN
   * 
   * @param date
   * @return string
   */

  public String dateToStringHyphen(final Date date) {

    final SimpleDateFormat simpleDateFormatSlashInverted =
      new SimpleDateFormat(DatePropertyHelper.getInstance().getProperty(
        "date.format.hyphen"));
    return simpleDateFormatSlashInverted.format(date);
  }

  /**
   * Parse a date to string with pattern ddMMyyy
   * 
   * @param date
   * @return
   */
  public String dateToStringPatternKeyBoard(final Date date) {
    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(DatePropertyHelper.getInstance().getProperty(
        "date.pattern"));
    return simpleDateFormat.format(date);
  }

  /**
   * Parser date to String with slash inverted
   * 
   * @param date
   * @return string
   */

  public String dateToStringSlashInverted(final Date date) {

    final SimpleDateFormat simpleDateFormatSlashInverted =
      new SimpleDateFormat(DatePropertyHelper.getInstance().getProperty(
        "date.format.slash.inverted"));

    return simpleDateFormatSlashInverted.format(date);
  }

  /**
   * Return current date in Calendar
   * 
   * @return Long
   */
  public Calendar getCurrentCalendar() {

    return InternationalizationContextHolder.getInstance().getDateContext()
      .getCalendar();
  }

  /**
   * Return the actual date with InternationalizationContextHolder, without
   * hour, minutes or seconds
   * 
   * @return
   */
  public Date getCurrentDate() {

    return new Date(getLongCurrentDateWithoutTime());
  }

  /**
   * Return the actual date with InternationalizationContextHolder
   * 
   * @return
   */
  public Date getCurrentDatetime() {

    return new Date(getLongCurrentDate());
  }

  public Integer getCurrentDay() {

    // 4 days before today
    final Calendar calendar = Calendar.getInstance();

    final int day = calendar.get(Calendar.DATE);

    return day;
  }

  /**
   * Return current date in Long without miliseconds
   * 
   * @return Long
   */
  public Long getLongCurrentDate() {
    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    calendar.clear(Calendar.MILLISECOND);

    return calendar.getTimeInMillis();
  }

  /**
   * Return current date in Long without time
   * 
   * @return Long
   */
  public Long getLongCurrentDateWithoutTime() {

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
  public String getStringCurrentDate() {

    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(DatePropertyHelper.getInstance().getProperty(
        "date.pattern"));
    final Date hoy = new Date(calendar.getTimeInMillis());
    return simpleDateFormat.format(hoy);
  }

  /**
   * Check pattern hour (HHmm or HHmmSS)
   * 
   * @param date
   * @return
   */
  public boolean isHourValid(final String hour) {
    boolean res = false;

    final SimpleDateFormat simpleHourMinFormat =
      new SimpleDateFormat(DatePropertyHelper.getInstance().getProperty(
        DatePropertyHelper.getInstance().getProperty("hour.minutes.format")));

    final SimpleDateFormat simpleHourFormat =
      new SimpleDateFormat(DatePropertyHelper.getInstance().getProperty(
        "hour.format"));
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
      catch (final ParseException e1) {
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
  public Calendar stringToCalendar(final String dateString) {

    final Calendar calendar =
      stringToCalendarByDatePattern(dateString, DatePropertyHelper
        .getInstance().getProperty("date.pattern"));

    return calendar;
  }

  /**
   * Parser a string to object Calendar internationalization applying a specific
   * date pattern
   * 
   * @param dateString
   * @param datePattern
   * @return
   */
  public Calendar stringToCalendarByDatePattern(final String dateString,
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

  public Calendar stringToDate(final String dateString) {

    return stringToCalendarByDatePattern(dateString, DatePropertyHelper
      .getInstance().getProperty("date.pattern.configuration"));
  }

  public Date stringToDate(final String dateString, final String pattern) {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    Date date = null;
    try {
      date = simpleDateFormat.parse(dateString);
    }
    catch (final ParseException e) {
      logger.error(e.getMessage(), e.getCause());
    }
    if (date != null) {
      final String transformed = simpleDateFormat.format(date).toString();

      if (!transformed.equals(dateString)) {
        date = null;
      }
    }

    return date;
  }

  public Date stringToDateLimitYear(final String dateString,
    final String pattern, final int limitYear) {

    Date date = stringToDate(dateString, pattern);

    if (date != null) {
      final int year = Integer.parseInt(dateString.substring(4));
      if (year > limitYear) {
        date = null;
      }
    }
    return date;
  }

  /**
   * Parser a string to object Calendar internationalization with time
   * 
   * @param dateString
   * @return
   */
  public Calendar stringToDateTime(final String dateString) {

    return stringToCalendarByDatePattern(dateString, DatePropertyHelper
      .getInstance().getProperty("date.time.pattern"));
  }

}
