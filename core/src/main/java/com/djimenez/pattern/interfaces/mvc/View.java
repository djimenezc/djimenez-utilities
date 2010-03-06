package com.djimenez.pattern.interfaces.mvc;

import java.util.Map;

import com.djimenez.pattern.core.view.ViewState;
import com.djimenez.pattern.exception.ViewException;
import com.djimenez.pattern.interfaces.EventListener;
import com.djimenez.pattern.interfaces.Notification;
import com.djimenez.pattern.interfaces.Observer;

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

  void registerObserver(String noteName, Observer observer)
    throws ViewException;

  void notifyObservers(Notification notification) throws Throwable;

  void registerMediator(Mediator mediator) throws ViewException;

  Mediator retrieveMediator(String mediatorName);

  Mediator removeMediator(String mediatorName);

  Mediator getCurrentMediator();

  void removeAllObservers();

  void removeAllMediators();

  Map<String, String> getMediatorMap();

  Map<String, String> getObserverMap();

  void setState(ViewState state);

  ViewState getState();

  boolean isCommandRunning();

  void setCommandRunning(boolean commandRunning);

}
