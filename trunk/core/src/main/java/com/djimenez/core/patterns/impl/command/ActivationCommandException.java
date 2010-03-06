package com.djimenez.core.patterns.impl.command;

/**
 * An exception happening when Messaging Service fails in the <i>client
 * side</i>.
 * 
 * @author djimenez
 * @version 1.0
 */
public class ActivationCommandException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ActivationCommandException(final String message) {
    super(message);
  }

  public ActivationCommandException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
