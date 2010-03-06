package com.djimenez.core.patterns.interfaces;

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

  void execute(Notification notification) throws Throwable;

  void handleEvent(Event event);

}
