package com.gowex.util.helper;

/**
 * Class that handles string utilities
 * 
 * @author jlp002es
 * @version 1.0
 * @see es.dia.pos.n2a.util.StringHelperFO, DateHelperFO
 */

public final class NumberHelper {

  public static double stringToDouble(final String value) {
    return new Double(value).doubleValue();
  }

  public static int stringToInt(final String value) {
    return Integer.parseInt(value);
  }

  public static long stringToLong(final String value) {
    return Long.parseLong(value);
  }

  public static boolean validateNumberDouble(final String number) {
    boolean bOk = true;
    try {
      Double.parseDouble(number);
    }
    catch (final NumberFormatException e) {
      bOk = false;
    }
    return bOk;
  }

  public static boolean validateNumberInt(final String number) {
    boolean bOk = true;
    try {
      Integer.parseInt(number);
    }
    catch (final NumberFormatException e) {
      bOk = false;
    }
    return bOk;
  }

  public static boolean validateNumberLong(final String number) {
    boolean bOk = true;
    try {
      Long.parseLong(number);
    }
    catch (final NumberFormatException e) {
      bOk = false;
    }
    return bOk;
  }

  private NumberHelper() {

  }

}
