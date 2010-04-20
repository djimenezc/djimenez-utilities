package com.djimenez.test.twip;

import net.sf.twip.Assume;
import net.sf.twip.AutoTwip;
import net.sf.twip.Values;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.djimenez.test.model.UserTestBean;

public class TwipExampleTest extends AbstractTwipTest {

  private static final Log LOG = LogFactory.getLog(TwipExampleTest.class);

  @AutoTwip
  public static UserTestBean crearPersona(final int id, final String nombre,
    final String apellido) {

    return new UserTestBean(id, nombre, apellido);
  }

  @Test
  public void testWithLong(final long b) {

    LOG.info("Numero " + b);
  }

  @Test
  public void testWithOwnObject(final UserTestBean userTestBean) {
    LOG.info(userTestBean);
  }

  @Test
  public void testWithString(@Values("DEFAULT_STRINGS") final String b) {
    LOG.info(b);
  }

  @Test
  public void testWithStringIncludeNull(@Assume("=null") final String b) {
    if ((b != null) && (b.length() == 1)) {
      final byte c = b.getBytes()[0];
      LOG.info("ASCII: " + c);
    }
    else {
      LOG.info(b);
    }
  }

}
