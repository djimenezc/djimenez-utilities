package com.gowex.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

  public static String fromFileToString(final String path) {
    BufferedReader reader = null;
    String line = null;
    final StringBuffer stringBuffer = new StringBuffer();

    try {
      reader = new BufferedReader(new FileReader(path));

      line = reader.readLine();

      while (line != null) {
        stringBuffer.append(line);
        stringBuffer.append(System.getProperty("line.separator"));
        line = reader.readLine();
      }
    }
    catch (final FileNotFoundException e1) {
      e1.printStackTrace();
    }
    catch (final IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        reader.close();
      }
      catch (final IOException e) {
        e.printStackTrace();
      }
    }

    return stringBuffer.toString();
  }
}
