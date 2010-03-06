package com.djimenez.pattern.exception;

public class MvcException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public MvcException(final String arg) {
    super(arg);
  }

  public MvcException(final Throwable throwable) {
    super(throwable);
  }

  public MvcException(final String arg, final Throwable throwable) {
    super(arg, throwable);
  }
}
