package com.djimenez.util.os.configuration.files.validators;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

/**
 * Check the IP format.
 * 
 * @author Rodrigo Villamil Perez
 */
public class ValidatorIPFormat implements Validator<String> {

  // Messages
  private final String UTIL_MESSAGES_FILE_NAME = "n2a-core-utils-messages";

  @Override
  public String getErrorMesg() {
    return ResourceBundle.getBundle(this.UTIL_MESSAGES_FILE_NAME).getString(
      "invalid.ip");
  }

  @Override
  public boolean validate(final String ip) {

    try {
      InetAddress.getByName(ip);

    }
    catch (final UnknownHostException e) {
      return false;
    }
    return true;
  }
}