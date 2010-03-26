package com.djimenez.core.patterns.impl.facade;

public class ApplicationFacadeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ApplicationFacadeException() {
    super();
  }

  public ApplicationFacadeException(final String message) {
    super(message);
  }

  public ApplicationFacadeException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ApplicationFacadeException(final Throwable cause) {
    super(cause);
  }

}
