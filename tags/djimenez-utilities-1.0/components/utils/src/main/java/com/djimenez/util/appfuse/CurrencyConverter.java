package com.djimenez.util.appfuse;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is converts a Double to a double-digit String (and vise-versa) by
 * BeanUtils when copying properties.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class CurrencyConverter implements Converter {

  private static final Log LOG = LogFactory.getLog(CurrencyConverter.class);

  private DecimalFormat formatter = new DecimalFormat("###,###.00");

  /**
   * Convert a String to a Double and a Double to a String
   * 
   * @param type
   *          the class type to output
   * @param value
   *          the object to convert
   * @return object the converted object (Double or String)
   */
  @SuppressWarnings("unchecked")
  public final Object convert(final Class type, final Object value) {
    // for a null value, return null
    if (value == null) {
      return null;
    }
    else {
      if (value instanceof String) {

        return stringConvert(value);
      }
      else
        if (value instanceof Double) {
          if (LOG.isDebugEnabled()) {
            LOG.debug("value (" + value + ") instance of Double");
            LOG.debug("returning double: " + formatter.format(value));
          }

          return formatter.format(value);
        }
    }

    throw new ConversionException("Could not convert " + value + " to "
      + type.getName() + "!");
  }

  public final void setDecimalFormatter(final DecimalFormat df) {
    this.formatter = df;
  }

  /**
   * @param value
   */
  private Double stringConvert(final Object value) {

    if (LOG.isDebugEnabled()) {
      LOG.debug("value (" + value + ") instance of String");
    }

    try {
      if (StringUtils.isBlank(String.valueOf(value))) {
        return null;
      }

      if (LOG.isDebugEnabled()) {
        LOG.debug("converting '" + value + "' to a decimal");
      }

      // formatter.setDecimalSeparatorAlwaysShown(true);
      final Number num = formatter.parse(String.valueOf(value));

      return Double.valueOf(num.doubleValue());
    }
    catch (final ParseException pe) {
      LOG.error(pe.getStackTrace());
    }
    return null;
  }
}
