package es.dia.pos.n2a.util.internationalization;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.junit.Test;

import com.djimenez.util.internationalization.DateHelper;

/**
 * @author sara.gonzalez.ming
 * @version 1.0
 */
public class DateHelperTest extends TestCase {

  private static final String DATE_PATTERN = "ddMMyyyy";
  private static final String FORMAT_DATE_SLASH = "dd/MM/yyyy";
  private static final String FORMAT_DATE_HYPHEN = "dd-MM-yyyy";
  private static final String FORMAT_HOUR = "HH:mm";
  private static final String TIME_PATTERN = "HHmm";
  private static final String FORMAT_DATE_SLASH_INVERTED = "yyyy/MM/dd";

  @Test
  public void testCheckDateBeforeToday() {
    Date date = new Date(System.currentTimeMillis() + 345600000);
    assertTrue(DateHelper.checkDateBeforeToday(date).booleanValue());
    date = new Date(System.currentTimeMillis() - 345600000);
    assertFalse(DateHelper.checkDateBeforeToday(date).booleanValue());
  }

  @Test
  public void testCheckDateIntoRange() {
    final Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DAY_OF_MONTH, 4);
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.YEAR, 1970);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    final Date date1 = calendar.getTime();

    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.YEAR, 1970);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    final Date date2 = calendar.getTime();
    assertTrue(DateHelper.checkDateIntoRange(date1, date2, 6).booleanValue());
    assertTrue(DateHelper.checkDateIntoRange(date1, date2, 4).booleanValue());
    assertFalse(DateHelper.checkDateIntoRange(date1, date2, 2).booleanValue());
  }

  @Test
  public void testCheckDateNotAfterLimit() {
    // 4 days before today
    final Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DAY_OF_MONTH, 15);
    final Date date = calendar.getTime();
    assertTrue(DateHelper.checkDateNotAfterLimit(date, Integer.valueOf(30))
      .booleanValue());
    assertTrue(DateHelper.checkDateNotAfterLimit(date, Integer.valueOf(15))
      .booleanValue());
    assertFalse(DateHelper.checkDateNotAfterLimit(date, Integer.valueOf(5))
      .booleanValue());
  }

  @Test
  public void testCheckDateNotExceedLimit() {
    final Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DAY_OF_MONTH, 4);
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.YEAR, 1970);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    final Date date1 = calendar.getTime();

    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.YEAR, 1970);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    final Date date2 = calendar.getTime();
    assertFalse(DateHelper.checkDateNotExceedLimit(date1, date2, 2)
      .booleanValue());
    assertTrue(DateHelper.checkDateNotExceedLimit(date1, date2, 4)
      .booleanValue());
    assertTrue(DateHelper.checkDateNotExceedLimit(date1, date2, 6)
      .booleanValue());
  }

  @Test
  public void testCheckDateToday() {
    Date date = new Date(System.currentTimeMillis() - 345600000);
    assertFalse(DateHelper.checkDateToday(date).booleanValue());
    assertTrue(DateHelper.checkDateToday(new Date()).booleanValue());
    date = new Date(System.currentTimeMillis() + 345600000);
    assertFalse(DateHelper.checkDateToday(date).booleanValue());
  }

  @Test
  public void testDateToString() {
    final Date date = new Date();
    date.setTime(0L);
    assertEquals("01011970", DateHelper.dateToString(date, DATE_PATTERN));
    assertEquals("01/01/1970", DateHelper.dateToString(date, FORMAT_DATE_SLASH));
    assertEquals("01-01-1970", DateHelper
      .dateToString(date, FORMAT_DATE_HYPHEN));
    assertEquals("01:00", DateHelper.dateToString(date, FORMAT_HOUR));
    assertEquals("0100", DateHelper.dateToString(date, TIME_PATTERN));
    assertEquals("1970/01/01", DateHelper.dateToString(date,
      FORMAT_DATE_SLASH_INVERTED));
  }

  @Test
  public void testStringToDate() {
    final Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.YEAR, 1970);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    final Date date = calendar.getTime();
    assertEquals(date.toString(), DateHelper.stringToDate("01011970",
      DATE_PATTERN).toString());
    assertEquals(date.toString(), DateHelper.stringToDate("01/01/1970",
      FORMAT_DATE_SLASH).toString());
    assertEquals(date.toString(), DateHelper.stringToDate("01-01-1970",
      FORMAT_DATE_HYPHEN).toString());
    assertEquals(date.toString(), DateHelper.stringToDate("1970/01/01",
      FORMAT_DATE_SLASH_INVERTED).toString());
    assertEquals(date.toString(), DateHelper.stringToDate("00:00", FORMAT_HOUR)
      .toString());
    assertEquals(date.toString(), DateHelper.stringToDate("0000", TIME_PATTERN)
      .toString());
    assertNotNull(DateHelper.stringToDate("2300", TIME_PATTERN).toString());
    assertNull(DateHelper.stringToDate("33011970", TIME_PATTERN));
    assertNull(DateHelper.stringToDate("01131970", TIME_PATTERN));
    assertNull(DateHelper.stringToDate("25:35", TIME_PATTERN));
    assertNull(DateHelper.stringToDate("12:65", TIME_PATTERN));
  }

  @Test
  public void testStringToDateLimitYear() {
    assertNotNull(DateHelper.stringToDateLimitYear("01011970", DATE_PATTERN,
      2001));
    assertNull(DateHelper.stringToDateLimitYear("01012010", DATE_PATTERN, 2001));
  }

}
