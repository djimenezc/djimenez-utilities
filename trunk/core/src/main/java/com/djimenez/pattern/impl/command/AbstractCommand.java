package com.djimenez.pattern.impl.command;

import com.djimenez.pattern.impl.observer.AbstractNotifier;
import com.djimenez.pattern.interfaces.CommandNotification;
import com.djimenez.pattern.interfaces.Event;
import com.djimenez.pattern.interfaces.Facade;

/**
 * An abstract Command implemantation. Its one and only faeture is handling
 * Notifiers and Facade Status.
 * 
 * @author djimenez
 * @version 1.0
 */
public abstract class AbstractCommand extends AbstractNotifier implements
  CommandNotification {

  @Override
  public void handleEvent(final Event event) {
    // do nothing yet
  }

  @Override
  public void assignFacade(final Facade commandFacade) {
    this.setFacade(commandFacade);
  }

}
