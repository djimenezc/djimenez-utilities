package com.djimenez.util.usb;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.djimenez.util.configuration.main.MainConfigurationFileHelper;

/**
 * @author javier.perdices
 */
public class MassStorageUsbDevice {

  private static final int BUFFER_SIZE = 256;

  private static Logger logger = Logger.getLogger(MassStorageUsbDevice.class);

  private final String n2aHome;
  private final String usbScript;
  private final String usbPath;
  private static final String MOUNT = "mount";
  private static final String UMOUNT = "umount";

  private boolean isMounted = false;

  public MassStorageUsbDevice() throws IOException {

    n2aHome = System.getProperty("N2A_HOME");
    usbScript =
      MainConfigurationFileHelper.getInstance().getProperty(
        "massStorageUsbDeviceMountScriptPath");
    usbPath =
      MainConfigurationFileHelper.getInstance().getProperty(
        "massStorageUsbDevicePath");
  }

  public final boolean close() {
    boolean result = false;
    try {
      if (isMounted) {
        logger.debug("MassStorageUsbDevice umount: " + n2aHome + usbScript
          + " " + UMOUNT + " " + usbPath);
        final Process process =
          Runtime.getRuntime().exec(
            new String[] { n2aHome + usbScript, UMOUNT, usbPath });
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
    String reason = "";

    while (counter >= 0) {

      final byte[] b = new byte[BUFFER_SIZE];

      counter = process.getErrorStream().read(b);
      reason = reason.concat(new String(b));
    }
    return reason;
  }

  public final File getMassStorageUsbDevice() {

    return new File(usbPath);
  }

  public final boolean open() {
    boolean result = false;
    try {
      if (!isMounted) {
        logger.debug("MassStorageUsbDevice mount: " + n2aHome + usbScript + " "
          + MOUNT + " " + usbPath);
        final Process process =
          Runtime.getRuntime().exec(
            new String[] { n2aHome + usbScript, MOUNT, usbPath });
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
