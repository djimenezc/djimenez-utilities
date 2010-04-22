package com.djimenez.model;

import java.util.Date;

/**
 * Static default values of basic types
 */
public final class DefaultValues {

  // String
  public static final String DEFAULT_STRING = "";
  public static final String ZERO_STRING = "0";
  public static final String ONE_HUNDRED = "100";
  public static final String ONE_STRING = "1";

  // Long
  public static final Long DEFAULT_LONG = Long.valueOf(0);
  public static final Long ZERO_LONG = Long.valueOf(0);

  // Integer
  public static final Integer DEFAULT_INTEGER = Integer.valueOf(0);

  // Dates
  public static final Date DEFAULT_DATE = new Date(0L);

  // int
  public static final int ZERO_INT = 0;
  public static final int UNO_INT = 1;
  public static final int DOS_INT = 2;

  // double
  public static final double DOUBLE_ZERO = 0.0;
  public static final int DEFAULT_INT = 0;

  /************************************ STATIC METHODS **********************************/

  private DefaultValues() {

  }
}
