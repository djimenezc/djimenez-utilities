package com.djimenez.util.properties;

/**
 * @author jlp002es
 * @version 1.0
 */
public class ConfigurationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ConfigurationException() {
    super();
  }

  public ConfigurationException(final String message) {
    super(message);
  }

}
