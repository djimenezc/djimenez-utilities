package com.djimenez.pattern.interfaces;

/**
 * When Notifications are broadcasted by the View, the Controller instantiates
 * the appropriate Command class and calls the execute() method, passing in the
 * Notification.
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 * @see es.dia.pos.n2a.mvc.interfaces.Command
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.View
 * @see es.dia.pos.n2a.mvc.patterns.observer.AbstractNotifier
 */
public interface Notification {

  String getName();

  void setBody(Object body);

  Object getBody();

  void setType(String type);

  String getType();
}
