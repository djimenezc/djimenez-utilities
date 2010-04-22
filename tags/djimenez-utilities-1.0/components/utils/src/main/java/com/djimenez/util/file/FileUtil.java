package com.djimenez.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/**
 * @author f.soberon.diego
 * @version 1.0
 */
public final class FileUtil {

  private static final int BUFFER_SIZE = 256;

  public static void copy(final File from, final File to) throws IOException {
    FileChannel source = null;
    FileChannel target = null;
    try {
      source = new FileInputStream(from).getChannel();
      target = new FileOutputStream(to).getChannel();
      source.transferTo(0, source.size(), target);
    }
    finally {
      if (source != null) {
        source.close();
      }

      if (target != null) {
        target.close();
      }
    }
  }

  public static File[] list(final File dir, final String regex) {
    if (!dir.isDirectory()) {
      throw new IllegalArgumentException(dir.getAbsolutePath()
        + " is not a directory");
    }

    final FilenameFilter filter = new FilenameFilter() {

      public boolean accept(final File directory, final String name) {
        return name.matches(regex);
      }
    };

    return dir.listFiles(filter);
  }

  public static void move(final File from, final File to) {
    if (!from.renameTo(to)) {
      throw new FileUtilException("Could not move from "
        + from.getAbsolutePath() + " to " + to.getAbsolutePath());
    }
  }

  public static String readBytes(final InputStream inputStream, final int count)
    throws Exception {

    final byte[] buffer = new byte[BUFFER_SIZE];

    if (inputStream.read(buffer, 0, count) < count) {
      throw new FileUtilException("Expected to read " + count
        + " bytes from file but EOF");
    }

    return new String(buffer, 0, count);
  }

  private FileUtil() {
  }
}
