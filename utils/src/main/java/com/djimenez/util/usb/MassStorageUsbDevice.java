package com.djimenez.util.usb;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.djimenez.util.configuration.ConfigurationHelper;

/**
 * @author javier.perdices
 */
public class MassStorageUsbDevice {

  private static final Logger logger =
    Logger.getLogger(MassStorageUsbDevice.class);

  private static final String N2A_HOME = System.getProperty("N2A_HOME");
  private static final String USB_SCRIPT =
    ConfigurationHelper.getInstance().getProperty(
      "massStorageUsbDeviceMountScriptPath");
  private static final String USB_PATH =
    ConfigurationHelper.getInstance().getProperty("massStorageUsbDevicePath");
  private static final String MOUNT = "mount";
  private static final String UMOUNT = "umount";

  private boolean isMounted = false;

  public MassStorageUsbDevice() {
  }

  public boolean close() {
    boolean result = false;
    try {
      if (isMounted) {
        logger.debug("MassStorageUsbDevice umount: " + N2A_HOME + USB_SCRIPT
          + " " + UMOUNT + " " + USB_PATH);
        final Process process =
          Runtime.getRuntime().exec(
            new String[] { N2A_HOME + USB_SCRIPT, UMOUNT, USB_PATH });
        if (process.waitFor() > 0) {
          logger.error("MassStorageUsbDevice umount failed: Reason: "
            + getError(process));
        }
        else {
          result = true;
          isMounted = false;
          logger.debug("MassStorageUsbDevice umount OK");
        }
      }
      else {
        logger.debug("MassStorageUsbDevice is closed: do nothing");
      }
    }
    catch (final Exception e) {
      logger.error("MassStorageUsbDevice close Exception: " + e.toString());
    }
    return result;
  }

  private String getError(final Process process) throws IOException {
    int counter = 0;
    final String reason = "";
    while (counter >= 0) {
      final byte[] b = new byte[256];
      counter = process.getErrorStream().read(b);
      reason.concat(new String(b));
    }
    return reason;
  }

  public File getMassStorageUsbDevice() {
    final File file = new File(USB_PATH);
    return file;
  }

  public boolean open() {
    boolean result = false;
    try {
      if (!isMounted) {
        logger.debug("MassStorageUsbDevice mount: " + N2A_HOME + USB_SCRIPT
          + " " + MOUNT + " " + USB_PATH);
        final Process process =
          Runtime.getRuntime().exec(
            new String[] { N2A_HOME + USB_SCRIPT, MOUNT, USB_PATH });
        if (process.waitFor() > 0) {
          logger.error("MassStorageUsbDevice mount failed: Reason: "
            + getError(process));
        }
        else {
          result = true;
          isMounted = true;
          logger.debug("MassStorageUsbDevice mounted OK");
        }
      }
      else {
        logger.debug("MassStorageUsbDevice is opened: do nothing");
        result = true;
      }
    }
    catch (final Exception e) {
      logger.error("MassStorageUsbDevice open Exception: " + e.toString());
    }
    return result;
  }

}
