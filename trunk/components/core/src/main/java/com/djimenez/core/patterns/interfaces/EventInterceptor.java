package com.djimenez.core.patterns.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 2.1
 */
public interface EventInterceptor {

  void dispatchInterceptedEvent(Event event);

  String getName();

  Object getSource();

  void setFacade(Facade facade);
}
