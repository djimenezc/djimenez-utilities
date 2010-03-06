package com.djimenez.pattern.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Notifier {

  void sendNotification(String notificationName, Object body, String type);

  void setFacade(Facade facade);

  Facade getFacade();
}
