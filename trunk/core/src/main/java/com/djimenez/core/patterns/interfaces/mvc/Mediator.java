package com.djimenez.core.patterns.interfaces.mvc;

import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.Notification;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Mediator {

  void assignFacade(Facade facade);

  void checkKeepLineAndDefaultValue();

  String getMediatorName();

  Object getViewComponent();

  void handleEvent(Event event);

  void handleNotification(Notification notification);

  String[] listNotificationInterests();

  void processBufferedData();

  void setViewComponent(Object viewComponent);

}
