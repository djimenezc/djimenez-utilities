package com.djimenez.model.keys;

/**
 * @author sara.gonzalez.ming
 * @version 1.0
 * @since 2.1
 */
public enum KeyType {

  KEY_0001("0001"),
  KEY_0002("0002"),
  KEY_0003("0003"),
  KEY_0004("0004"),
  KEY_0005("0005"),
  KEY_0006("0006"),
  KEY_0007("0007"),
  KEY_0008("0008"),
  KEY_0009("0009"),
  KEY_0010("0010"),
  KEY_0011("0011"),
  KEY_0012("0012"),
  KEY_0013("0013"),
  KEY_0014("0014"),
  KEY_0015("0015"),
  KEY_0016("0016"),
  KEY_0017("0017"),
  KEY_0018("0018"),
  KEY_0019("0019"),
  KEY_0020("0020"),
  KEY_0021("0021"),
  KEY_0022("0022"),
  KEY_0023("0023"),
  KEY_0024("0024"),
  KEY_0025("0025"),
  KEY_0026("0026"),
  KEY_0027("0027"),
  KEY_0028("0028"),
  KEY_0029("0029"),
  KEY_0030("0030"),
  KEY_0031("0031"),
  KEY_0032("0032"),
  KEY_0033("0033"),
  KEY_0034("0034"),
  KEY_0035("0035"),
  KEY_0036("0036"),
  KEY_0037("0037"),
  KEY_0038("0038");

  private static final String KEY = "KEY_";
  public static KeyType fromString(final String value) {
    final String keyValue = KEY.concat(value);
    KeyType typeValue = null;
    typeValue = KeyType.valueOf(keyValue);
    return typeValue;
  }

  private String value;

  private KeyType(final String value) {
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
