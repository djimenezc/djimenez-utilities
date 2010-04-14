package com.djimenez.util.string;

public class StringUtils {

  public static String deleteStrangeSimbols(final String string) {

    String encodeString = String.valueOf(string);

    encodeString = encodeString.replace('Á', 'a');
    encodeString = encodeString.replace('É', 'e');
    encodeString = encodeString.replace('Í', 'i');
    encodeString = encodeString.replace('Ó', 'o');
    encodeString = encodeString.replace('Ú', 'u');
    encodeString = encodeString.replace('á', 'a');
    encodeString = encodeString.replace('é', 'e');
    encodeString = encodeString.replace('í', 'i');
    encodeString = encodeString.replace('ó', 'o');
    encodeString = encodeString.replace('ú', 'u');

    encodeString = encodeString.replace('ñ', 'n');
    encodeString = encodeString.replace('ç', 'c');

    encodeString = encodeString.replace('ä', 'a');
    encodeString = encodeString.replace('ë', 'e');
    encodeString = encodeString.replace('ï', 'i');
    encodeString = encodeString.replace('ö', 'o');
    encodeString = encodeString.replace('ü', 'u');
    encodeString = encodeString.replace('Ä', 'a');
    encodeString = encodeString.replace('Ë', 'e');
    encodeString = encodeString.replace('Ï', 'i');
    encodeString = encodeString.replace('Ö', 'o');
    encodeString = encodeString.replace('Ü', 'u');

    encodeString = encodeString.replace('à', 'a');
    encodeString = encodeString.replace('è', 'e');
    encodeString = encodeString.replace('ì', 'i');
    encodeString = encodeString.replace('ò', 'o');
    encodeString = encodeString.replace('ù', 'u');
    encodeString = encodeString.replace('À', 'a');
    encodeString = encodeString.replace('È', 'e');
    encodeString = encodeString.replace('Ì', 'i');
    encodeString = encodeString.replace('Ò', 'o');
    encodeString = encodeString.replace('Ù', 'u');

    encodeString = encodeString.replace('Â', 'a');
    encodeString = encodeString.replace('Ê', 'e');
    encodeString = encodeString.replace('Î', 'i');
    encodeString = encodeString.replace('Ô', 'o');
    encodeString = encodeString.replace('Û', 'u');
    encodeString = encodeString.replace('â', 'a');
    encodeString = encodeString.replace('ê', 'e');
    encodeString = encodeString.replace('î', 'i');
    encodeString = encodeString.replace('ô', 'o');
    encodeString = encodeString.replace('û', 'u');

    return encodeString;
  }

}
