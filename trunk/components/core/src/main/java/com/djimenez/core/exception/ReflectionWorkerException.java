package com.djimenez.core.exception;

public class ReflectionWorkerException extends Exception {

  private static final long serialVersionUID = 1L;

  public ReflectionWorkerException(final String message) {
    super(message);
  }

  public ReflectionWorkerException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ReflectionWorkerException(final Throwable cause) {
    super(cause);
  }

}
