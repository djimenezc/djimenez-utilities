package com.djimenez.util.appfuse;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is converts a java.util.Date to a String and a String to a
 * java.util.Date.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class DateConverter implements Converter {

  private static final Log LOG = LogFactory.getLog(DateConverter.class);

  /**
   * Convert a date to a String and a String to a Date
   * 
   * @param type
   *          String, Date or Timestamp
   * @param value
   *          value to convert
   * @return Converted value for property population
   */
  @SuppressWarnings("unchecked")
  public final Object convert(final Class type, final Object value) {
    if (value == null) {
      return null;
    }
    else
      if (type == Timestamp.class) {
        try {
          return convertToDate(type, value, DateUtil.getDateTimePattern());
        }
        catch (final ParseException e) {
          LOG.error(e.getStackTrace());
        }
      }
      else
        if (type == Date.class) {
          try {
            return convertToDate(type, value, DateUtil.getDatePattern());
          }
          catch (final ParseException e) {
            LOG.error(e.getStackTrace());
          }
        }
        else
          if (type == String.class) {
            return convertToString(type, value);
          }

    throw new ConversionException("Could not convert "
      + value.getClass().getName() + " to " + type.getName());
  }

  /**
   * Convert a String to a Date with the specified pattern.
   * 
   * @param type
   *          String
   * @param value
   *          value of String
   * @param pattern
   *          date pattern to parse with
   * @return Converted value for property population
   * @throws ParseException
   */
  public final Object convertToDate(final Class<?> type, final Object value,
    final String pattern) throws ParseException {

    final DateFormat df = new SimpleDateFormat(pattern);
    if (value instanceof String) {
      if (StringUtils.isEmpty(value.toString())) {
        return null;
      }

      final Date date = df.parse((String) value);
      if (type.equals(Timestamp.class)) {
        return new Timestamp(date.getTime());
      }
      return date;
    }

    throw new ConversionException("Could not convert "
      + value.getClass().getName() + " to " + type.getName());
  }

  /**
   * Convert a java.util.Date to a String
   * 
   * @param type
   *          Date or Timestamp
   * @param value
   *          value to convert
   * @return Converted value for property population
   */
  public final Object convertToString(final Class<?> type, final Object value) {

    if (value instanceof Date) {

      DateFormat df = new SimpleDateFormat(DateUtil.getDatePattern());

      if (value instanceof Timestamp) {
        df = new SimpleDateFormat(DateUtil.getDateTimePattern());
      }

      return df.format(value);
    }
    else {
      return value.toString();
    }
  }
}
