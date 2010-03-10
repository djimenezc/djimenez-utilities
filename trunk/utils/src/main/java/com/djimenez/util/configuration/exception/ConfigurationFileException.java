package com.djimenez.util.configuration.exception;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public class ConfigurationFileException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ConfigurationFileException() {
    super();
  }

  public ConfigurationFileException(final String message) {
    super(message);
  }

  public ConfigurationFileException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ConfigurationFileException(final Throwable cause) {
    super(cause);
  }
}
