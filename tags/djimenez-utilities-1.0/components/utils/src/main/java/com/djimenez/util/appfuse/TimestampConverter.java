package com.djimenez.util.appfuse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.compass.core.converter.ConversionException;

/**
 * This class is converts a java.util.Date to a String and a String to a
 * java.util.Date for use as a Timestamp. It is used by BeanUtils when copying
 * properties.
 * 
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
public class TimestampConverter {

  /**
   * i18n-ized timestamp format - based on values in
   * ApplicationResources.properties
   */
  public static final String TS_FORMAT =
    DateUtil.getDatePattern() + " HH:mm:ss.S";

  /**
   * Convert a String to a date
   * 
   * @param type
   *          java.util.Date
   * @param value
   *          the String value
   * @return a converted date
   * @throws ParseException
   */
  public final Object convertToDate(final Class<?> type, final Object value)
    throws ParseException {

    final DateFormat df = new SimpleDateFormat(TS_FORMAT);

    if (value instanceof String) {
      if (StringUtils.isEmpty(value.toString())) {
        return null;
      }

      return df.parse((String) value);
    }

    throw new ConversionException("Could not convert "
      + value.getClass().getName() + " to " + type.getName());
  }

  /**
   * Convert from a java.util.Date to a String
   * 
   * @param type
   *          java.lang.String
   * @param value
   *          the date instance
   * @return string version of date using default date pattern
   */
  public final Object convertToString(final Class<?> type, final Object value) {
    final DateFormat df = new SimpleDateFormat(TS_FORMAT);

    if (value instanceof Date) {
      return df.format(value);
    }

    return value.toString();
  }
}