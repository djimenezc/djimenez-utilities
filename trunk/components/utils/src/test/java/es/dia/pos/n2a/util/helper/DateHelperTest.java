package es.dia.pos.n2a.util.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.junit.Test;

import com.djimenez.util.helper.DateHelper;

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
    assertTrue(DateHelper.getInstance().checkDateBeforeToday(date)
      .booleanValue());
    date = new Date(System.currentTimeMillis() - 345600000);
    assertFalse(DateHelper.getInstance().checkDateBeforeToday(date)
      .booleanValue());
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
    assertTrue(DateHelper.getInstance().checkDateIntoRange(date1, date2, 6)
      .booleanValue());
    assertTrue(DateHelper.getInstance().checkDateIntoRange(date1, date2, 4)
      .booleanValue());
    assertFalse(DateHelper.getInstance().checkDateIntoRange(date1, date2, 2)
      .booleanValue());
  }

  @Test
  public void testCheckDateNotAfterLimit() {

    // 4 days before today
    final Calendar calendar = new GregorianCalendar();

    calendar.roll(Calendar.DAY_OF_MONTH, -4);

    final Date dateLimit = calendar.getTime();

    assertTrue(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(30)).booleanValue());

    assertTrue(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(15)).booleanValue());

    assertTrue(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(5)).booleanValue());

    assertFalse(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(3)).booleanValue());
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

    assertFalse(DateHelper.getInstance().checkDateNotExceedLimit(date1, date2,
      2).booleanValue());
    assertTrue(DateHelper.getInstance()
      .checkDateNotExceedLimit(date1, date2, 4).booleanValue());
    assertTrue(DateHelper.getInstance()
      .checkDateNotExceedLimit(date1, date2, 6).booleanValue());
  }

  @Test
  public void testCheckDateToday() {
    Date date = new Date(System.currentTimeMillis() - 345600000);
    assertFalse(DateHelper.getInstance().checkDateToday(date).booleanValue());
    assertTrue(DateHelper.getInstance().checkDateToday(new Date())
      .booleanValue());
    date = new Date(System.currentTimeMillis() + 345600000);
    assertFalse(DateHelper.getInstance().checkDateToday(date).booleanValue());
  }

  @Test
  public void testDateToString() {
    final Date date = new Date();
    date.setTime(0L);
    assertEquals("01011970", DateHelper.getInstance().dateToString(date,
      DATE_PATTERN));
    assertEquals("01/01/1970", DateHelper.getInstance().dateToString(date,
      FORMAT_DATE_SLASH));
    assertEquals("01-01-1970", DateHelper.getInstance().dateToString(date,
      FORMAT_DATE_HYPHEN));
    assertEquals("01:00", DateHelper.getInstance().dateToString(date,
      FORMAT_HOUR));
    assertEquals("0100", DateHelper.getInstance().dateToString(date,
      TIME_PATTERN));
    assertEquals("1970/01/01", DateHelper.getInstance().dateToString(date,
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
    assertEquals(date.toString(), DateHelper.getInstance().stringToDate(
      "01011970", DATE_PATTERN).toString());
    assertEquals(date.toString(), DateHelper.getInstance().stringToDate(
      "01/01/1970", FORMAT_DATE_SLASH).toString());
    assertEquals(date.toString(), DateHelper.getInstance().stringToDate(
      "01-01-1970", FORMAT_DATE_HYPHEN).toString());
    assertEquals(date.toString(), DateHelper.getInstance().stringToDate(
      "1970/01/01", FORMAT_DATE_SLASH_INVERTED).toString());
    assertEquals(date.toString(), DateHelper.getInstance().stringToDate(
      "00:00", FORMAT_HOUR).toString());
    assertEquals(date.toString(), DateHelper.getInstance().stringToDate("0000",
      TIME_PATTERN).toString());
    assertNotNull(DateHelper.getInstance().stringToDate("2300", TIME_PATTERN)
      .toString());
    assertNull(DateHelper.getInstance().stringToDate("33011970", TIME_PATTERN));
    assertNull(DateHelper.getInstance().stringToDate("01131970", TIME_PATTERN));
    assertNull(DateHelper.getInstance().stringToDate("25:35", TIME_PATTERN));
    assertNull(DateHelper.getInstance().stringToDate("12:65", TIME_PATTERN));
  }

  @Test
  public void testStringToDateLimitYear() {
    assertNotNull(DateHelper.getInstance().stringToDateLimitYear("01011970",
      DATE_PATTERN, 2001));
    assertNull(DateHelper.getInstance().stringToDateLimitYear("01012010",
      DATE_PATTERN, 2001));
  }

}
