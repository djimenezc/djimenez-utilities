package es.dia.pos.n2a.util.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

  public void testDeleteAccents() {

    final String stringWithAccents = "holá";

    final String cleanString =
      com.djimenez.util.string.StringUtils.deleteStrangeSimbols(stringWithAccents);

    assertFalse(org.apache.commons.lang.StringUtils.contains(cleanString, 'á'));

  }

  public void testEncodeString() throws UnsupportedEncodingException {

    final String stringWithAccents = "holá";

    final String stringEncode = URLEncoder.encode(stringWithAccents, "UTF-8");

    System.out.println("Encode accents from " + stringWithAccents);
    System.out.println("The result string is " + stringEncode);
  }
}