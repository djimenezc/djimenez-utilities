package com.djimenez.core.patterns.interfaces.mvc;

import java.util.Map;

import com.djimenez.core.components.view.ViewState;
import com.djimenez.core.exception.ViewException;
import com.djimenez.core.patterns.interfaces.EventListener;
import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.Observer;

/**
 * The View primarily caches named references to Mediators. Mediator code
 * stewards View Components, adding event listeners, sending and receiving
 * notifications to and from the rest of the system on their behalf and directly
 * manipulating their state.
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.Mediator
 */
public interface View extends EventListener {

  Mediator getCurrentMediator();

  Map<String, String> getMediatorMap();

  Map<String, String> getObserverMap();

  ViewState getState();

  boolean isCommandRunning();

  void notifyObservers(Notification notification) throws Throwable;

  void registerMediator(Mediator mediator) throws ViewException;

  void registerObserver(String noteName, Observer observer)
    throws ViewException;

  void removeAllMediators();

  void removeAllObservers();

  Mediator removeMediator(String mediatorName);

  Mediator retrieveMediator(String mediatorName);

  void setCommandRunning(boolean commandRunning);

  void setState(ViewState state);

}
