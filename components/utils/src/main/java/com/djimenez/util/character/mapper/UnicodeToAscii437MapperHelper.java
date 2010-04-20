package com.djimenez.util.character.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.djimenez.util.configuration.AbstractConfigurationFileHelper;

public final class UnicodeToAscii437MapperHelper {

  private static UnicodeToAscii437MapperHelper instance;
  private Map<String, String> unicodeToAscii437Map;

  private static final String CHARACTERS_UNICODE_FILE_NAME =
    "characters-unicode.properties";
  private static final String CHARACTERS_ASCII437_FILE_NAME =
    "characters-ascii437.properties";

  public static UnicodeToAscii437MapperHelper getInstance() throws IOException {

    if (instance == null) {
      instance = new UnicodeToAscii437MapperHelper();
    }

    return instance;
  }

  private UnicodeToAscii437MapperHelper() throws IOException {

    final Properties charactersUnicode = new Properties();
    final Properties charactersAscii437 = new Properties();

    InputStream inputStreamUnicode = null;
    InputStream inputStreamAscii437 = null;

    try {
      inputStreamUnicode =
        AbstractConfigurationFileHelper.class.getClassLoader()
          .getResourceAsStream(CHARACTERS_UNICODE_FILE_NAME);
      inputStreamAscii437 =
        AbstractConfigurationFileHelper.class.getClassLoader()
          .getResourceAsStream(CHARACTERS_ASCII437_FILE_NAME);
      charactersUnicode.load(inputStreamUnicode);
      charactersAscii437.load(inputStreamAscii437);

      unicodeToAscii437Map = new HashMap<String, String>();

      final Enumeration<Object> characters = charactersUnicode.keys();
      while (characters.hasMoreElements()) {
        final String character = (String) characters.nextElement();
        final String characterUnicode =
          (String) charactersUnicode.get(character);
        final String characterAscii437 =
          (String) charactersAscii437.get(character);
        if (!characterAscii437.equals("")) {
          unicodeToAscii437Map.put(characterUnicode, characterAscii437);
        }
      }

    }
    finally {
      if (inputStreamUnicode != null) {
        inputStreamUnicode.close();
      }
      if (inputStreamAscii437 != null) {
        inputStreamAscii437.close();
      }
    }
  }

  public String replaceUnicodeForAscii437(final String text) {
    String unicodeText = text;
    final Set<String> unicode = unicodeToAscii437Map.keySet();

    final Iterator<String> unicodeIterator = unicode.iterator();

    while (unicodeIterator.hasNext()) {
      final String unicodeCharacter = unicodeIterator.next();
      unicodeText =
        unicodeText.replace(unicodeCharacter, unicodeToAscii437Map
          .get(unicodeCharacter));
    }

    return unicodeText;

  }

}
