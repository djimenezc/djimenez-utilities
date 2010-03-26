package com.djimenez.util.internationalization;

import java.text.NumberFormat;
import java.util.Currency;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public interface CurrencyContext {

  Currency getCurrency();

  NumberFormat getCurrencyFormatter();

}
