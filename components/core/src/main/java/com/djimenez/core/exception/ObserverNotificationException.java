package com.djimenez.core.exception;

public class ObserverNotificationException extends Exception {

  private static final long serialVersionUID = 1L;

  public ObserverNotificationException() {
    super();
  }

  public ObserverNotificationException(final String message) {
    super(message);
  }

  public ObserverNotificationException(final String arg0, final Throwable arg1) {
    super(arg0, arg1);
  }

  public ObserverNotificationException(final Throwable cause) {
    super(cause);
  }
}
