package com.djimenez.core.exception;

/**
 * Exception thrown when trying to register an existing Mediator.
 * 
 * @author djimenez
 * @version 1.0
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.View
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.Mediator
 */
public class DuplicateMediatorException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DuplicateMediatorException(final String message) {
    super(message);
  }
}
