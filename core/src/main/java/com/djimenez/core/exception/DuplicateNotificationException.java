package com.djimenez.core.exception;

/**
 * Exception thrown when trying to register an existing Command Notification.
 * 
 * @author djimenez
 * @version 1.0
 * @see com.djimenez.core.patterns.interfaces.command.mvc.interfaces.Command
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.Controller
 */
public class DuplicateNotificationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DuplicateNotificationException(final String message) {
    super(message);
  }
}
