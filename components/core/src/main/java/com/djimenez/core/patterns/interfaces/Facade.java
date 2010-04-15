package com.djimenez.core.patterns.interfaces;

import java.util.Collection;
import java.util.List;

import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.core.patterns.interfaces.command.CommandContainer;
import com.djimenez.core.patterns.interfaces.mvc.Controller;
import com.djimenez.core.patterns.interfaces.mvc.Mediator;
import com.djimenez.core.patterns.interfaces.mvc.MediatorContainer;
import com.djimenez.core.patterns.interfaces.mvc.View;

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

  void dispatchEvent(Event event);

  Controller getController();

  EventInterceptor getEventInterceptor(String eventInterceptorName);

  Model getModel();

  View getView();

  void notifyObservers(Notification note) throws Exception;

  void pauseAllRemoteEvents();

  void processException(Throwable throwable);

  void registerCommand(String notificationName, Command command);

  void registerEventInterceptor(EventInterceptor eventInterceptor);

  void registerMediator(Mediator mediator);

  void registerProxy(Proxy proxy);

  void removeAllProxies();

  Command removeCommand(String notificationName);

  @Deprecated
  Mediator removeMediator(String mediatorName);

  Proxy removeProxy(String proxyName);

  void restartAllRemoteEvents();

  @Deprecated
  Mediator retrieveMediator(String mediatorName);

  Proxy retrieveProxy(final Class<?> proxyClass);

  Proxy retrieveProxy(String proxyName);

  void setCommandContainerCollection(
    Collection<CommandContainer> commandContainerCollection);

  void setEnabledEventDispatching(boolean enabledEventDispatching);

  void setEventInterceptorList(List<EventInterceptor> eventInterceptorList);

  void setMediatorContainerCollection(
    Collection<MediatorContainer> mediatorContainerCollection);

  void startApplication();
}
