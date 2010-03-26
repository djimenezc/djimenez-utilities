package com.djimenez.core.components.context;

/**
 * Exception happens when loading application context along ContextHelp or
 * Spring Context.
 * 
 * @author djimenez
 * @version 1.0
 * @see es.dia.pos.n2a.mvc.core.context.ContextHelper
 * @see es.dia.pos.n2a.mvc.patterns.servicelocator.ServiceLocator
 */
public class ContextLoadingException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ContextLoadingException(final String msg, final Throwable t) {
    super(msg, t);
  }
}
