package es.dia.pos.n2a.util.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtilTest extends TestCase {

  private static final Log LOG = LogFactory.getLog(StringUtilTest.class);

  public final void testDeleteAccents() {

    final String stringWithAccents = "holá";

    final String cleanString =
      com.djimenez.util.string.StringUtils
        .deleteStrangeSimbols(stringWithAccents);

    assertFalse(org.apache.commons.lang.StringUtils.contains(cleanString, 'á'));

  }

  public final void testEncodeString() throws UnsupportedEncodingException {

    final String stringWithAccents = "holá";

    final String stringEncode = URLEncoder.encode(stringWithAccents, "UTF-8");

    LOG.info("Encode accents from " + stringWithAccents);
    LOG.info("The result string is " + stringEncode);
  }
}