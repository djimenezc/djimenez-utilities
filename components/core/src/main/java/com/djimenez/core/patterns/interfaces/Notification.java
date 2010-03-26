package com.djimenez.core.patterns.interfaces;

/**
 * When Notifications are broadcasted by the View, the Controller instantiates
 * the appropriate Command class and calls the execute() method, passing in the
 * Notification.
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 * @see com.djimenez.core.patterns.interfaces.command.mvc.interfaces.Command
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.View
 * @see es.dia.pos.n2a.mvc.patterns.observer.AbstractNotifier
 */
public interface Notification {

  Object getBody();

  String getName();

  String getType();

  void setBody(Object body);

  void setType(String type);
}
