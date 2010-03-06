package com.djimenez.pattern.core.view;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.djimenez.pattern.exception.ViewException;
import com.djimenez.pattern.impl.observer.ObserverEntry;
import com.djimenez.pattern.interfaces.Event;
import com.djimenez.pattern.interfaces.Notification;
import com.djimenez.pattern.interfaces.Observer;
import com.djimenez.pattern.interfaces.mvc.Mediator;
import com.djimenez.pattern.interfaces.mvc.View;

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
  private Mediator currentMediator;
  // private Notification currentNotification;

  private boolean commandRunning;

  private static View instance;
  private ViewState state;

  private final Map<String, Mediator> mediatorMap;
  private final Map<String, ObserverEntry> observerMap;

  private boolean justQueueBuffer;
  private boolean processingBuffer;

  // private final Notification previousNotification;

  private ViewImpl() {

    this.state = ViewState.RUN;
    this.mediatorMap = new Hashtable<String, Mediator>();
    this.observerMap = new Hashtable<String, ObserverEntry>();
    this.commandRunning = false;
    this.currentMediator = null;
  }

  public static View getInstance() {
    if (instance == null) {
      instance = new ViewImpl();
    }
    return instance;
  }

  @Override
  public Mediator getCurrentMediator() {
    return this.currentMediator;
  }

  protected void setCurrentMediator(final Mediator currentMediator) {
    // Clean echo line. It could not be empty if an error happens.

    this.currentMediator = currentMediator;
  }

  @Override
  public void notifyObservers(final Notification note) throws Throwable {

  }

  @Override
  public void registerMediator(final Mediator mediator) throws ViewException {

  }

  @Override
  public void registerObserver(final String notificationName,
    final Observer observer) throws ViewException {
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
  public void onEvent(final Event event) {

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
  public void setState(final ViewState state) {
    if (logger.isDebugEnabled()) {
      logger.debug("View state changed to: " + state);
    }
    this.state = state;
  }

  public boolean isProcessingBuffer() {
    return this.processingBuffer;
  }

  public void setProcessingBuffer(final boolean processingBuffer) {
    if (logger.isDebugEnabled()) {
      logger.debug("Status processing buffer changed to: " + processingBuffer
        + " for " + this.currentMediator.getMediatorName());
    }
    this.processingBuffer = processingBuffer;
  }

  protected boolean isJustQueueBuffer() {
    return this.justQueueBuffer;
  }

  @Override
  public void removeAllObservers() {
    this.observerMap.clear();
  }

  @Override
  public void removeAllMediators() {
    this.mediatorMap.clear();
  }

  @Override
  public boolean isCommandRunning() {
    return commandRunning;
  }

  @Override
  public void setCommandRunning(final boolean commandRunning) {
    this.commandRunning = commandRunning;
  }

}
