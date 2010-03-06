package com.djimenez.pattern.exception;

/**
 * @author djimenez
 * @version 1.0
 */
public class ObserverException extends RuntimeException {

  public static final long serialVersionUID = 1L;

  public ObserverException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
