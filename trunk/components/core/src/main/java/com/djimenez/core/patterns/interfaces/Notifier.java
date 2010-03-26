package com.djimenez.core.patterns.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Notifier {

  Facade getFacade();

  void sendNotification(String notificationName, Object body, String type);

  void setFacade(Facade facade);
}
