package com.djimenez.test.twip;

import net.sf.twip.Assume;
import net.sf.twip.AutoTwip;
import net.sf.twip.Values;

import org.junit.Test;

import com.djimenez.test.model.UserTest;

public class TwipExampleTest extends AbstractTwipTest {

  @AutoTwip
  public static UserTest crearPersona(final int id, final String nombre,
    final String apellido) {

    return new UserTest(id, nombre, apellido);
  }

  @Test
  public void testWithLong(final long b) {

    System.out.println("Numero " + b);
  }

  @Test
  public void testWithOwnObject(final UserTest userTest) {
    System.out.println(userTest);
  }

  @Test
  public void testWithString(@Values("DEFAULT_STRINGS") final String b) {
    System.out.println(b);
  }

  @Test
  public void testWithStringIncludeNull(@Assume("=null") final String b) {
    if ((b != null) && (b.length() == 1)) {
      final byte c = b.getBytes()[0];
      System.out.println("ASCII: " + c);
    }
    else {
      System.out.println(b);
    }
  }

}
