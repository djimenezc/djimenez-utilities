package com.djimenez.core.patterns.interfaces.command;

import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.Notification;

/**
 * Encapsulate a request as an object, thereby letting you parameterize clients
 * with different requests, queue or log requests, and support undoable
 * operations.
 * 
 * @author djimenez
 * @version 1.0
 */
public interface CommandNotification extends Command {

  void assignFacade(Facade facade);

  void execute(Notification notification);

  void handleEvent(Event event);

}
