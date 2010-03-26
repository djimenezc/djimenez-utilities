package com.djimenez.core.exception;

public class MvcException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public MvcException(final String arg) {
    super(arg);
  }

  public MvcException(final String arg, final Throwable throwable) {
    super(arg, throwable);
  }

  public MvcException(final Throwable throwable) {
    super(throwable);
  }
}
