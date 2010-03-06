package com.djimenez.pattern.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 2.1
 */
public interface EventInterceptor {

  String getName();

  Object getSource();

  void dispatchInterceptedEvent(Event event);

  void setFacade(Facade facade);
}
