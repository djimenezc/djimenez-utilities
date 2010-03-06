package com.djimenez.pattern.interfaces;

import java.util.Collection;
import java.util.List;

import com.djimenez.pattern.core.controller.CommandContainer;
import com.djimenez.pattern.core.view.MediatorContainer;
import com.djimenez.pattern.interfaces.mvc.Controller;
import com.djimenez.pattern.interfaces.mvc.Mediator;
import com.djimenez.pattern.interfaces.mvc.View;

/**
 * Facade is the initial point of contact for handling all related requests. The
 * Facade centralizes control logic that might otherwise be duplicated, and
 * manages the key request handling activities. Facade encapsulates the
 * complexity of the N2A system and provides coarse-grained access to business
 * objects.
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Facade extends Notifier {

  Controller getController();

  Model getModel();

  View getView();

  void dispatchEvent(Event event);

  void notifyObservers(Notification note) throws Throwable;

  void registerProxy(Proxy proxy);

  Proxy retrieveProxy(String proxyName);

  Proxy retrieveProxy(final Class<?> proxyClass);

  Proxy removeProxy(String proxyName);

  @Deprecated
  void registerCommand(String notificationName, Command command);

  @Deprecated
  Command removeCommand(String notificationName);

  @Deprecated
  void registerMediator(Mediator mediator);

  void setCommandContainerCollection(
    Collection<CommandContainer> commandContainerCollection);

  void setMediatorContainerCollection(
    Collection<MediatorContainer> mediatorContainerCollection);

  @Deprecated
  Mediator retrieveMediator(String mediatorName);

  @Deprecated
  Mediator removeMediator(String mediatorName);

  void setEventInterceptorList(List<EventInterceptor> eventInterceptorList);

  void registerEventInterceptor(EventInterceptor eventInterceptor);

  EventInterceptor getEventInterceptor(String eventInterceptorName);

  void processException(Throwable throwable);

  void setEnabledEventDispatching(boolean enabledEventDispatching);

  void removeAllProxies();

  void pauseAllRemoteEvents();

  void restartAllRemoteEvents();

  void startApplication();
}
