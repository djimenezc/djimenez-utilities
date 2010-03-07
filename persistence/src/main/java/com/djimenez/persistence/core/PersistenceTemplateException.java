package com.djimenez.persistence.core;

/**
 * Runtime Exceptions due to Persistence Layer Failure
 * 
 * @author javier.perdices
 * @version 1.0
 */
public class PersistenceTemplateException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public PersistenceTemplateException(final String message) {
    super(message);
  }

  public PersistenceTemplateException(final String message,
    final Throwable cause) {
    super(message, cause);
  }
}
