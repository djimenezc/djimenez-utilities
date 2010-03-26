package com.djimenez.core.exception;

public class ViewException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ViewException() {
    super();
  }

  public ViewException(final String message) {
    super(message);
  }

  public ViewException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ViewException(final Throwable cause) {
    super(cause);
  }

}
