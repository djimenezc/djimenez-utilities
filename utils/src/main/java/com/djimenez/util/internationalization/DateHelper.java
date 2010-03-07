package com.djimenez.util.internationalization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * @author sara.gonzalez.ming
 * @version 1.0
 */
public class DateHelper {

  private static final Logger logger = Logger.getLogger(DateHelper.class);

  // private static final int DATE_LENGTH = 8;
  //	
  // private static final String DATE_PATTERN = "ddMMyyyy";
  // private static final String FORMAT_DATE_SLASH = "dd/MM/yyyy";
  // private static final String FORMAT_DATE_HYPHEN = "dd-MM-yyyy";
  // private static final String FORMAT_HOUR = "HH:mm";
  // private static final String TIME_PATTERN = "HHmm";
  // private static final String FORMAT_DATE_SLASH_INVERTED = "yyyy/MM/dd";
  //	
  // private static final SimpleDateFormat simpleDateFormat = new
  // SimpleDateFormat(DATE_PATTERN);
  // private static final SimpleDateFormat simpleDateFormatSlash = new
  // SimpleDateFormat(FORMAT_DATE_SLASH);
  // private static final SimpleDateFormat simpleDateFormatSlashInverted = new
  // SimpleDateFormat(FORMAT_DATE_SLASH_INVERTED);
  // private static final SimpleDateFormat simpleDateFormatHyphen = new
  // SimpleDateFormat(FORMAT_DATE_HYPHEN);
  // private static final SimpleDateFormat simpleHourFormat = new
  // SimpleDateFormat(FORMAT_HOUR);

  // public static Calendar stringToCalendar(final String dateString) {
  // final Calendar calendar = new GregorianCalendar();
  // try {
  // final Date date = simpleDateFormat.parse(dateString);
  // if (!simpleDateFormat.format(date).toString().equals(dateString)) {
  // throw new InternationalizationException("Can't parse date " + dateString);
  // }
  // calendar.setTime(date);
  // } catch (Exception e) {
  // throw new InternationalizationException("Can't parse date " + dateString,
  // e);
  // }
  // return calendar;
  // }

  // public static String dateToString(final Date date) {
  // return simpleDateFormat.format(date);
  // }

  /**
   * Method to check if date is before today.
   * 
   * @param date
   * @return true date is grater today false date is minor or equal today
   */
  public static Boolean checkDateBeforeToday(final Date date) {
    final Date actualDate =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar().getTime();
    return Boolean.valueOf(actualDate.before(date));
  }

  // public static String dateToStringSlash(final Date date) {
  // return simpleDateFormatSlash.format(date);
  // }
  //	
  // public static String dateToStringHyphen(final Date date) {
  // return simpleDateFormatHyphen.format(date);
  // }
  //	
  // public static String dateToStringSlashInverted(final Date date){
  // return simpleDateFormatSlashInverted.format(date);
  // }
  //	
  // public static String hourToString(final Date date) {
  // final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
  // return simpleDateFormat.format(date);
  // }
  //
  // public static String hourHHMMToString(final Date date) {
  // return simpleHourFormat.format(date);
  // }
  //	
  // public static Date stringToDate(final String dateString, final String
  // format) {
  // final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
  //
  // Date date = null;
  // try {
  // date = simpleDateFormat.parse(dateString);
  // } catch (ParseException e) {
  // logger.error(e.getMessage(), e.getCause());
  // }
  // final String transformed = simpleDateFormat.format(date).toString();
  //		
  // if (!transformed.equals(dateString)){
  // date = null;
  // }
  //		
  // return date;
  // }

  public static Boolean checkDateIntoRange(final Date dateToCheck,
    final Date refDate, final int days) {
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

  // public static Boolean isDateValid(final String date){
  // Boolean valid = Boolean.FALSE;
  //		
  // if (date.length()>=DATE_LENGTH){
  // Date fecha = null;
  // try {
  // fecha = simpleDateFormat.parse(date);
  // } catch (ParseException e) {
  // logger.error(e.getMessage(), e.getCause());
  // }
  // final String transformed = simpleDateFormat.format(fecha).toString();
  //			
  // if (transformed.equals(date)){
  // valid = Boolean.TRUE;
  // }
  //		
  // }
  // return valid;
  // }

  // public static Boolean isDateValidLimitYear(final String date, final int
  // limitYear) {
  // Boolean valid = Boolean.FALSE;
  //
  // if (date.length() >= DATE_LENGTH) {
  // Date fecha = null;
  // try {
  // fecha = simpleDateFormat.parse(date);
  // } catch (ParseException e) {
  // logger.error(e.getMessage(), e.getCause());
  // }
  // final String transformed = simpleDateFormat.format(fecha).toString();
  //
  // final int year = Integer.parseInt(date.substring(4));
  // if (transformed.equals(date) && year <= limitYear) {
  // valid = Boolean.TRUE;
  // }
  //
  // }
  // return valid;
  // }

  /**
   * This method return true if (date <= today && date >= today - days)
   * 
   * @param date
   * @param days
   * @return true if (date <= today && date >= today - days)
   */
  public static Boolean checkDateNotAfterLimit(final Date date,
    final Integer days) {
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

  public static Boolean checkDateNotExceedLimit(final Date dateToCheck,
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
  public static Boolean checkDateToday(final Date date) {
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

  public static String dateToString(final Date date, final String pattern) {
    final SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat(pattern, InternationalizationContextHolder
        .getInstance().getLocale());
    return simpleDateFormat.format(date);
  }

  // public static Date hourToDate(final String dateString) {
  // final SimpleDateFormat simpleDateFormat = new
  // SimpleDateFormat(TIME_PATTERN);
  // try {
  // Date date = simpleDateFormat.parse(dateString);
  // if (!simpleDateFormat.format(date).toString().equals(dateString)) {
  // date = null;
  // }
  // return date;
  // } catch (ParseException e) {
  // return null;
  // }
  // }
  //
  // public static boolean isHourValid(final String hour) {
  // boolean res = false;
  // try {
  // final long hh = Long.parseLong(hour.substring(0, 2));
  // final long mm = Long.parseLong(hour.substring(2, 4));
  // if (hh < 24 && hh >= 0 && mm < 60 && mm >= 0) {
  // res = true;
  // }
  // } catch (Exception e) {
  // res = false;
  // }
  // return res;
  // }

  // /**
  // * Static Method parses a String to a Date.
  // * @param date
  // * @return a Date
  // */
  // public static Date parseDate(final String dateString) {
  // try {
  // Date date = simpleDateFormat.parse(dateString);
  // if (!simpleDateFormat.format(date).toString().equals(dateString)) {
  // date = null;
  // }
  // return date;
  // } catch (ParseException e) {
  // return null;
  // }
  // }

  // /**
  // * Static method parses a String to a Time
  // * @param date
  // * @return a Time
  // */
  // public static Date parseTime(final String date) {
  // final SimpleDateFormat simpleDateFormat = new
  // SimpleDateFormat(TIME_PATTERN);
  // try {
  // return simpleDateFormat.parse(date);
  // } catch (ParseException e) {
  // return null;
  // }
  // }

  // /**
  // * Method to check hour.
  // * @param hour
  // * @return true if is correct, otherwise false
  // */
  // public static boolean checkHour(final String hour) {
  // boolean res = false;
  // try {
  // final long hh = Long.parseLong(hour.substring(0, 2));
  // final long mm = Long.parseLong(hour.substring(2, 4));
  // if (hh < 24 && hh >= 0 && mm < 60 && mm >= 0) {
  // res = true;
  // }
  // } catch (Exception e) {
  // res = false;
  // }
  // return res;
  // }

  /**
   * Return current date in Long without miliseconds
   * 
   * @return Long
   */
  public static Long getLongCurrentDate() {
    final Calendar calendar =
      InternationalizationContextHolder.getInstance().getDateContext()
        .getCalendar();
    calendar.clear(Calendar.MILLISECOND);

    return calendar.getTimeInMillis();
  }

  // /**
  // * Method to check if startDate is before endDate.
  // * @param startDate
  // * @param endDate
  // * @return <b>true:</b> if the startDate < endDate<br>
  // * <b>false:</b> if the startDate > endDate
  // */
  // public static Boolean checkTwoDate(final Date startDate, final Date
  // endDate) {
  // return Boolean.valueOf(startDate.before(endDate));
  // }

  // /**
  // * Method to check if date is before today.
  // * @param date
  // * @return true date is grater today
  // * false date is minor or equal today
  // */
  // public static Boolean checkDateToday(final Date date) {
  // final Date actualDate =
  // InternationalizationContextHolder.getInstance().getDateContext().getCalendar().getTime();
  // return Boolean.valueOf(actualDate.before(date));
  // }

  public static Date stringToDate(final String dateString, final String pattern) {
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

  // /**
  // * Method to check if date is today.
  // * @param date
  // * @return true date is equals today
  // * false date is not equals today
  // */
  // public static Boolean checkDateTodayOnlyDate(final Date date) {
  // final Calendar actualDate =
  // InternationalizationContextHolder.getInstance().getDateContext().getCalendar();
  // final Calendar newDate =
  // InternationalizationContextHolder.getInstance().getDateContext().getCalendar();
  // actualDate.setTime(date);
  // return Boolean.valueOf((actualDate.get(Calendar.DAY_OF_MONTH) ==
  // newDate.get(Calendar.DAY_OF_MONTH)) &&
  // (actualDate.get(Calendar.MONTH) == newDate.get(Calendar.MONTH)) &&
  // (actualDate.get(Calendar.YEAR) == newDate.get(Calendar.YEAR)));
  // }

  public static Date stringToDateLimitYear(final String dateString,
    final String pattern, final int limitYear) {
    Date date = DateHelper.stringToDate(dateString, pattern);
    if (date != null) {
      final int year = Integer.parseInt(dateString.substring(4));
      if (year > limitYear) {
        date = null;
      }
    }
    return date;
  }

  // /**
  // * Method to create a Date.
  // * @param date
  // * @param hour
  // * @return true date is grater today
  // * false date is minor or equal today
  // */
  // public static Date createDate(final String date, final String hour) {
  // final SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyHHmm");
  // Date newDate = null;
  // try {
  // String dateString = date.concat(hour);
  // newDate = s.parse(dateString);
  // if (!s.format(newDate).toString().equals(dateString)) {
  // newDate = null;
  // }
  // } catch (ParseException e) {
  // logger.warn(e.getMessage(), e.getCause());
  // }
  // return newDate;
  // }

}
