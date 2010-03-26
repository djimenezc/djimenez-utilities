package com.djimenez.util.internationalization;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public interface NumericContext {

  DecimalFormat getDecimalFormatter();

  NumberFormat getNumberFormatter();

  NumberFormat getPercentFormatter();
}
