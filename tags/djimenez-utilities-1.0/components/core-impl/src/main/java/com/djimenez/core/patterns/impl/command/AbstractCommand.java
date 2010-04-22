package com.djimenez.core.patterns.impl.command;

import com.djimenez.core.patterns.impl.observer.AbstractNotifier;
import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.command.CommandNotification;

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
  public final void assignFacade(final Facade commandFacade) {
    this.setFacade(commandFacade);
  }

  @Override
  public void handleEvent(final Event event) {
    // do nothing yet
  }

}
