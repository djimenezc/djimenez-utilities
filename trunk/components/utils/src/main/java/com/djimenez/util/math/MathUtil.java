package com.djimenez.util.math;

/**
 * @author a.pastoriza.barcia
 */
public class MathUtil {

  public static double round(double value, final int decimalPlaces) {
    final double powedValue = Math.pow(10, decimalPlaces);
    value = value * powedValue;
    final long tmp = Math.round(value);
    return tmp / powedValue;
  }
}
