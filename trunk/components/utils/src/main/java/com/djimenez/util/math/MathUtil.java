package com.djimenez.util.math;

/**
 * @author a.pastoriza.barcia
 */
public final class MathUtil {

  public static double round(final double value, final int decimalPlaces) {

    final double powedValue = Math.pow(10, decimalPlaces);

    final long roundValue = Math.round(value * powedValue);

    return roundValue / powedValue;
  }

  private MathUtil() {

  }
}
