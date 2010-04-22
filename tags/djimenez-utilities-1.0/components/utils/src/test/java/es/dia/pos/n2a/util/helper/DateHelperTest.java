package es.dia.pos.n2a.util.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.junit.Test;

import com.djimenez.model.DefaultValues;
import com.djimenez.util.helper.DateHelper;

/**
 * @author sara.gonzalez.ming
 * @version 1.0
 */
public class DateHelperTest extends TestCase {

  private static final int BEGIN_YEAR_DATE = 1970;
  private static final int MILLISECONDS_1970 = 345600000;
  private static final String DATE_PATTERN = "ddMMyyyy";
  private static final String FORMAT_DATE_SLASH = "dd/MM/yyyy";
  private static final String FORMAT_DATE_HYPHEN = "dd-MM-yyyy";
  private static final String FORMAT_HOUR = "HH:mm";
  private static final String TIME_PATTERN = "HHmm";
  private static final String FORMAT_DATE_SLASH_INVERTED = "yyyy/MM/dd";

  @Test
  public final void testCheckDateBeforeToday() {

    Date date = new Date(System.currentTimeMillis() + MILLISECONDS_1970);
    assertTrue(DateHelper.getInstance().checkDateBeforeToday(date)
      .booleanValue());
    date = new Date(System.currentTimeMillis() - MILLISECONDS_1970);
    assertFalse(DateHelper.getInstance().checkDateBeforeToday(date)
      .booleanValue());
  }

  @Test
  public final void testCheckDateIntoRange() {

    final Calendar calendar = new GregorianCalendar();
    final int value = 4;
    calendar.set(Calendar.DAY_OF_MONTH, value);
    calendar.set(Calendar.MONTH, DefaultValues.ZERO_INT);
    calendar.set(Calendar.YEAR, BEGIN_YEAR_DATE);
    calendar.set(Calendar.HOUR_OF_DAY, DefaultValues.ZERO_INT);
    calendar.set(Calendar.MINUTE, DefaultValues.ZERO_INT);
    calendar.set(Calendar.SECOND, DefaultValues.ZERO_INT);
    final Date date1 = calendar.getTime();

    final int value2 = 1;
    calendar.set(Calendar.DAY_OF_MONTH, value2);
    calendar.set(Calendar.MONTH, DefaultValues.ZERO_INT);
    calendar.set(Calendar.YEAR, BEGIN_YEAR_DATE);
    calendar.set(Calendar.HOUR_OF_DAY, DefaultValues.ZERO_INT);
    calendar.set(Calendar.MINUTE, DefaultValues.ZERO_INT);
    calendar.set(Calendar.SECOND, DefaultValues.ZERO_INT);
    final Date date2 = calendar.getTime();

    final int days = 6;

    assertTrue(DateHelper.getInstance().checkDateIntoRange(date1, date2, days)
      .booleanValue());
    final int days2 = 4;
    assertTrue(DateHelper.getInstance().checkDateIntoRange(date1, date2, days2)
      .booleanValue());
    final int days3 = 2;
    assertFalse(DateHelper.getInstance()
      .checkDateIntoRange(date1, date2, days3).booleanValue());
  }

  @Test
  public final void testCheckDateNotAfterLimit() {

    // 4 days before today
    final Calendar calendar = new GregorianCalendar();

    final int amount = -4;
    calendar.roll(Calendar.DAY_OF_MONTH, amount);

    final Date dateLimit = calendar.getTime();

    final int i = 30;
    assertTrue(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(i)).booleanValue());

    final int i2 = 15;
    assertTrue(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(i2)).booleanValue());

    final int i3 = 5;
    assertTrue(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(i3)).booleanValue());

    final int i4 = 3;
    assertFalse(DateHelper.getInstance().checkDateNotAfterLimit(dateLimit,
      Integer.valueOf(i4)).booleanValue());
  }

  @Test
  public final void testCheckDateNotExceedLimit() {

    final Calendar calendar = new GregorianCalendar();

    final int value = 4;
    calendar.set(Calendar.DAY_OF_MONTH, value);
    calendar.set(Calendar.MONTH, DefaultValues.ZERO_INT);
    calendar.set(Calendar.YEAR, BEGIN_YEAR_DATE);
    calendar.set(Calendar.HOUR_OF_DAY, DefaultValues.ZERO_INT);
    calendar.set(Calendar.MINUTE, DefaultValues.ZERO_INT);
    calendar.set(Calendar.SECOND, DefaultValues.ZERO_INT);

    final Date date1 = calendar.getTime();

    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.MONTH, DefaultValues.ZERO_INT);
    calendar.set(Calendar.YEAR, BEGIN_YEAR_DATE);
    calendar.set(Calendar.HOUR_OF_DAY, DefaultValues.ZERO_INT);
    calendar.set(Calendar.MINUTE, DefaultValues.ZERO_INT);
    calendar.set(Calendar.SECOND, DefaultValues.ZERO_INT);

    final Date date2 = calendar.getTime();

    final int days = 2;
    assertFalse(DateHelper.getInstance().checkDateNotExceedLimit(date1, date2,
      days).booleanValue());

    final int days2 = 4;
    assertTrue(DateHelper.getInstance().checkDateNotExceedLimit(date1, date2,
      days2).booleanValue());

    final int days3 = 6;
    assertTrue(DateHelper.getInstance().checkDateNotExceedLimit(date1, date2,
      days3).booleanValue());
  }

  @Test
  public final void testCheckDateToday() {

    Date date = new Date(System.currentTimeMillis() - MILLISECONDS_1970);

    assertFalse(DateHelper.getInstance().checkDateToday(date).booleanValue());

    assertTrue(DateHelper.getInstance().checkDateToday(new Date())
      .booleanValue());

    date = new Date(System.currentTimeMillis() + MILLISECONDS_1970);
    assertFalse(DateHelper.getInstance().checkDateToday(date).booleanValue());
  }

  @Test
  public final void testDateToString() {
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
  public final void testStringToDate() {
    final Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.MONTH, DefaultValues.ZERO_INT);
    calendar.set(Calendar.YEAR, BEGIN_YEAR_DATE);
    calendar.set(Calendar.HOUR_OF_DAY, DefaultValues.ZERO_INT);
    calendar.set(Calendar.MINUTE, DefaultValues.ZERO_INT);
    calendar.set(Calendar.SECOND, DefaultValues.ZERO_INT);
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
  public final void testStringToDateLimitYear() {

    final int limitYear = 2001;

    assertNotNull(DateHelper.getInstance().stringToDateLimitYear("01011970",
      DATE_PATTERN, limitYear));

    assertNull(DateHelper.getInstance().stringToDateLimitYear("01012010",
      DATE_PATTERN, limitYear));
  }

}
