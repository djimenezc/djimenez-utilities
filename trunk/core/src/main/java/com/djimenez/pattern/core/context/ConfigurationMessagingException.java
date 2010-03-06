package com.djimenez.pattern.core.context;

/**
 * An Exception happening during Messaging configuration
 * 
 * @see es.dia.pos.n2a.mvc.core.context.ConfigurationMessaging
 * @author djimenez
 * @version 1.0
 */
public class ConfigurationMessagingException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ConfigurationMessagingException(final String message,
    final Throwable cause) {
    super(message, cause);
  }
}
