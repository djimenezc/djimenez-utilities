package com.djimenez.pattern.interfaces.mvc;

import com.djimenez.pattern.interfaces.Event;
import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.Notification;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Mediator {

  String getMediatorName();

  Object getViewComponent();

  void setViewComponent(Object viewComponent);

  String[] listNotificationInterests();

  void handleNotification(Notification notification);

  void handleEvent(Event event);

  void assignFacade(Facade facade);

  void processBufferedData();

  void checkKeepLineAndDefaultValue();

}
