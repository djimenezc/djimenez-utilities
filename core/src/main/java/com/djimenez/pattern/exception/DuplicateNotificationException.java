package com.djimenez.pattern.exception;

/**
 * Exception thrown when trying to register an existing Command Notification.
 * 
 * @author djimenez
 * @version 1.0
 * @see es.dia.pos.n2a.mvc.interfaces.Command
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.Controller
 */
public class DuplicateNotificationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DuplicateNotificationException(final String message) {
    super(message);
  }
}
