package com.djimenez.core.components.view;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.djimenez.core.exception.ViewException;
import com.djimenez.core.patterns.enumetates.view.ViewState;
import com.djimenez.core.patterns.impl.observer.ObserverEntry;
import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.Observer;
import com.djimenez.core.patterns.interfaces.mvc.Mediator;
import com.djimenez.core.patterns.interfaces.mvc.View;

/**
 * The View Container implementation.
 * 
 * @author djimenez
 * @version 1.0
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.View
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.Mediator
 */
public final class ViewImpl implements View, ViewImplMBean {

  protected static final Logger logger = Logger.getLogger(ViewImpl.class);
  public static View getInstance() {
    if (instance == null) {
      instance = new ViewImpl();
    }
    return instance;
  }

  private Mediator currentMediator;
  // private Notification currentNotification;

  private boolean commandRunning;
  private static View instance;

  private ViewState state;
  private final Map<String, Mediator> mediatorMap;

  private final Map<String, ObserverEntry> observerMap;
  private boolean justQueueBuffer;

  // private final Notification previousNotification;

  private boolean processingBuffer;

  private ViewImpl() {

    this.state = ViewState.RUN;
    this.mediatorMap = new Hashtable<String, Mediator>();
    this.observerMap = new Hashtable<String, ObserverEntry>();
    this.commandRunning = false;
    this.currentMediator = null;
  }

  @Override
  public Mediator getCurrentMediator() {
    return this.currentMediator;
  }

  @Override
  public Map<String, String> getMediatorMap() {

    final Map<String, String> map = new HashMap<String, String>();
    final Iterator<String> iterator = this.mediatorMap.keySet().iterator();
    while (iterator.hasNext()) {
      final String key = iterator.next();
      final String value = this.mediatorMap.get(key).getMediatorName();
      map.put(key, value);
    }
    return map;
  }

  @Override
  public Map<String, String> getObserverMap() {

    final Map<String, String> map = new HashMap<String, String>();

    final Iterator<String> iterator = this.observerMap.keySet().iterator();

    while (iterator.hasNext()) {

      // FIXME check
      // final String key = iterator.next();
      //
      // final Observer observer = this.observerMap.get(key).getObserver();
      // value =
      // value.concat("[Observer for context "
      // + observer.getNotifyContext().getClass().getSimpleName() + "] ");
      // map.put(key, value);
    }
    return map;
  }

  @Override
  public ViewState getState() {
    return this.state;
  }

  @Override
  public boolean isCommandRunning() {
    return commandRunning;
  }

  protected boolean isJustQueueBuffer() {
    return this.justQueueBuffer;
  }

  public boolean isProcessingBuffer() {
    return this.processingBuffer;
  }

  @Override
  public void notifyObservers(final Notification note) throws Throwable {

  }

  @Override
  public void onEvent(final Event event) {

  }

  @Override
  public void registerMediator(final Mediator mediator) throws ViewException {

  }

  @Override
  public void registerObserver(final String notificationName,
    final Observer observer) throws ViewException {
  }

  @Override
  public void removeAllMediators() {
    this.mediatorMap.clear();
  }

  @Override
  public void removeAllObservers() {
    this.observerMap.clear();
  }

  @Override
  public Mediator removeMediator(final String mediatorName) {
    for (final Enumeration<ObserverEntry> enumObserversList =
      ((Hashtable<String, ObserverEntry>) this.observerMap).elements(); enumObserversList
      .hasMoreElements();) {
      final ObserverEntry observersList = enumObserversList.nextElement();
      final Observer observer = observersList.getObserver();
      final Mediator mediator = this.retrieveMediator(mediatorName);
      if (observer.compareNotifyContext(mediator)) {
        observersList.deleteObserver(observer);
      }
      if (observersList.getObserver() == null) {
        this.observerMap.remove(observersList.getNotificationName());
      }

    }
    final Mediator mediatorRemoved = this.mediatorMap.remove(mediatorName);
    this.removeMediatorDependencies(mediatorRemoved);
    return mediatorRemoved;
  }

  private void removeMediatorDependencies(final Mediator mediator) {

    mediator.assignFacade(null);
  }

  @Override
  public Mediator retrieveMediator(final String mediatorName) {
    return this.mediatorMap.get(mediatorName);
  }

  @Override
  public void setCommandRunning(final boolean commandRunning) {
    this.commandRunning = commandRunning;
  }

  protected void setCurrentMediator(final Mediator currentMediator) {
    // Clean echo line. It could not be empty if an error happens.

    this.currentMediator = currentMediator;
  }

  public void setProcessingBuffer(final boolean processingBuffer) {
    if (logger.isDebugEnabled()) {
      logger.debug("Status processing buffer changed to: " + processingBuffer
        + " for " + this.currentMediator.getMediatorName());
    }
    this.processingBuffer = processingBuffer;
  }

  @Override
  public void setState(final ViewState state) {
    if (logger.isDebugEnabled()) {
      logger.debug("View state changed to: " + state);
    }
    this.state = state;
  }

}
