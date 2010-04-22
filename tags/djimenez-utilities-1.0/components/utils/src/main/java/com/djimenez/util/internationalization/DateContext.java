package com.djimenez.util.internationalization;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public interface DateContext {

  Calendar getCalendar();

  DateFormat getDateAndTimeFormatter();

  DateFormat getDateFormatter();

  DateFormat getTimeFormatter();

  TimeZone getTimeZone();
}
