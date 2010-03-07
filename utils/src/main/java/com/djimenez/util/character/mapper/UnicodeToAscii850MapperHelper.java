package com.djimenez.util.character.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.djimenez.util.configuration.ConfigurationException;
import com.djimenez.util.configuration.ConfigurationHelper;

public final class UnicodeToAscii850MapperHelper {

  private static enum ProblematicCharacter {
    CAPITAL_E_WITH_ACUTE("capital.e.with.acute"),
    CAPITAL_E_WITH_DIAERESIS("capital.e.with.diaeresis"),
    CAPITAL_I_WITH_ACUTE("capital.i.with.acute");

    public static boolean contains(final String value) {
      boolean contains = false;
      final ProblematicCharacter[] collection = ProblematicCharacter.values();
      for (final ProblematicCharacter problematicCharacter : collection) {
        if (problematicCharacter.getValue().equals(value)) {
          contains = true;
        }
      }
      return contains;
    }

    private String value;

    private ProblematicCharacter(final String value) {
      this.value = value;
    }

    public String getValue() {
      return this.value;
    }

    @Override
    public String toString() {
      return String.valueOf(this.value);
    }

  }

  private static UnicodeToAscii850MapperHelper instance;
  private Map<String, String> unicodeToAscii850Map;

  private Map<String, String> unicodeToAscii850ProblematicCharactersMap;
  private static final String CHARACTERS_UNICODE_FILE_NAME =
    "characters-unicode.properties";

  private static final String CHARACTERS_ASCII850_FILE_NAME =
    "characters-ascii850.properties";

  public static UnicodeToAscii850MapperHelper getInstance() {
    if (instance == null) {
      instance = new UnicodeToAscii850MapperHelper();
    }
    return instance;
  }

  private UnicodeToAscii850MapperHelper() {

    final Properties charactersUnicode = new Properties();
    final Properties charactersAscii850 = new Properties();

    InputStream inputStreamUnicode = null;
    InputStream inputStreamAscii850 = null;

    try {
      inputStreamUnicode =
        ConfigurationHelper.class.getClassLoader().getResourceAsStream(
          CHARACTERS_UNICODE_FILE_NAME);
      inputStreamAscii850 =
        ConfigurationHelper.class.getClassLoader().getResourceAsStream(
          CHARACTERS_ASCII850_FILE_NAME);
      charactersUnicode.load(inputStreamUnicode);
      charactersAscii850.load(inputStreamAscii850);

      this.unicodeToAscii850Map = new HashMap<String, String>();
      this.unicodeToAscii850ProblematicCharactersMap =
        new HashMap<String, String>();

      final Enumeration<Object> characters = charactersUnicode.keys();
      while (characters.hasMoreElements()) {
        final String character = (String) characters.nextElement();
        final String characterUnicode =
          (String) charactersUnicode.get(character);
        final String characterAscii850 =
          (String) charactersAscii850.get(character);
        if (!characterAscii850.equals("")) {
          if (!ProblematicCharacter.contains(character)) {
            this.unicodeToAscii850Map.put(characterUnicode, characterAscii850);
          }
          else {
            this.unicodeToAscii850ProblematicCharactersMap.put(
              characterUnicode, characterAscii850);
          }
        }
      }

    }
    catch (final IOException e) {
      throw new ConfigurationException(e.getMessage(), e.getCause());
    }
    finally {
      try {
        if (inputStreamUnicode != null) {
          inputStreamUnicode.close();
        }
        if (inputStreamAscii850 != null) {
          inputStreamAscii850.close();
        }
      }
      catch (final IOException e) {
        throw new ConfigurationException(e.getMessage(), e.getCause());
      }

    }

  }

  public String replaceUnicodeForAscii850(final String text) {
    String unicodeText = text;

    final Set<String> unicode = this.unicodeToAscii850Map.keySet();

    final Iterator<String> unicodeIterator = unicode.iterator();

    while (unicodeIterator.hasNext()) {
      final String unicodeCharacter = unicodeIterator.next();
      unicodeText =
        unicodeText.replace(unicodeCharacter, this.unicodeToAscii850Map
          .get(unicodeCharacter));
    }

    final Set<String> unicodeProblematicCharacters =
      this.unicodeToAscii850ProblematicCharactersMap.keySet();

    final Iterator<String> unicodeProblematicCharactersIterator =
      unicodeProblematicCharacters.iterator();

    while (unicodeProblematicCharactersIterator.hasNext()) {
      final String unicodeProblematicCharacter =
        unicodeProblematicCharactersIterator.next();
      unicodeText =
        unicodeText.replace(unicodeProblematicCharacter,
          this.unicodeToAscii850ProblematicCharactersMap
            .get(unicodeProblematicCharacter));
    }

    return unicodeText;

  }

}
