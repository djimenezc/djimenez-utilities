package com.djimenez.core.patterns.impl.facade;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.djimenez.core.components.controller.ControllerImpl;
import com.djimenez.core.components.model.ModelImpl;
import com.djimenez.core.components.view.ViewImpl;
import com.djimenez.core.components.worker.WorkerImpl;
import com.djimenez.core.patterns.impl.observer.SimpleNotification;
import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.EventInterceptor;
import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.Model;
import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.Proxy;
import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.core.patterns.interfaces.command.CommandContainer;
import com.djimenez.core.patterns.interfaces.mvc.Controller;
import com.djimenez.core.patterns.interfaces.mvc.Mediator;
import com.djimenez.core.patterns.interfaces.mvc.MediatorContainer;
import com.djimenez.core.patterns.interfaces.mvc.View;
import com.djimenez.core.patterns.interfaces.worker.Worker;

/**
 * @author djimenez
 * @version 1.6
 * @since 1.0
 */
public abstract class ApplicationFacade implements Facade {

  private static Logger logger = Logger.getLogger(ApplicationFacade.class);

  private Facade parentFacade;
  private Map<String, EventInterceptor> eventInterceptorMap;
  private Controller controller = null;
  private View view = null;
  private Model model = null;
  private Worker worker = null;
  private boolean enabledEventDispatching;

  public ApplicationFacade() {
    logger.info("[Facade] Initializing " + this.getClass().getSimpleName()
      + "...");
    this.initializeFacade();
    logger.info("[Facade] Initialized " + this.getClass().getSimpleName());
  }

  @Override
  public final void dispatchEvent(final Event event) {
    try {
      if (this.isEnabledEventDispatching()) {
        if (this.view != null) {
          this.view.onEvent(event);
        }
        else {
          logger.warn("View not initialized yet for event: " + event);
        }
        if (this.controller != null) {
          this.controller.onEvent(event);
        }
        else {
          logger.warn("Controller not initialized yet for event: " + event);
        }
      }
      else {
        logger.warn("Event dispatching is disabled");
      }

    }
    catch (final Throwable throwable) {
      this.processException(throwable);
    }
  }

  @Override
  public final Controller getController() {
    return controller;
  }

  @Override
  public final EventInterceptor getEventInterceptor(
    final String eventInterceptorName) {
    return this.eventInterceptorMap.get(eventInterceptorName);
  }

  @Override
  public final Model getModel() {
    return model;
  }

  /**
   * @return the parentFacade
   */
  public final Facade getParentFacade() {
    return parentFacade;
  }

  @Override
  public final View getView() {
    return view;
  }

  private void initializeController() {

    if (this.controller == null) {
      this.controller = ControllerImpl.getInstance();
      logger.info("Initializing Controller");
    }
    else {
      logger.trace("Controller already initialized");
    }

  }

  private void initializeFacade() {
    this.initializeModel();
    this.initializeController();
    this.initializeView();
    this.initializeWorker();

    this.eventInterceptorMap = new Hashtable<String, EventInterceptor>();
    this.enabledEventDispatching = false;
  }

  private void initializeModel() {
    if (this.model == null) {
      this.model = ModelImpl.getInstance();
      logger.info("Initializing Model");
    }
    else {
      logger.trace("Model already initialized");
    }
  }

  private void initializeView() {
    if (this.view == null) {
      this.view = ViewImpl.getInstance();
      logger.info("Initializing View...");
    }
    else {
      logger.trace("View already initialized");
    }
  }

  private void initializeWorker() {
    if (this.worker == null) {
      this.worker = WorkerImpl.getInstance();
      logger.info("Initializing Worker...");
    }
    else {
      logger.trace("Worker already initialized");
    }
  }

  public final boolean isEnabledEventDispatching() {
    return this.enabledEventDispatching;
  }

  @Override
  public final void notifyObservers(final Notification notification)
    throws Exception {
    if (this.view != null) {
      this.view.notifyObservers(notification);
    }
    else {
      logger.warn("View not initialized yet for notification: " + notification);
    }
  }

  @Override
  public final void registerEventInterceptor(
    final EventInterceptor eventInterceptor) {
    eventInterceptor.setFacade(this);
    this.eventInterceptorMap.put(eventInterceptor.getName(), eventInterceptor);
  }

  /**
   * Put the <notification,class> map in the worker piece and register the
   * command
   */
  // private void registerWorkerCommands(final Map<String, Class<?>> commandMap,
  // final CommandNotification command) {
  //
  // for (final Entry<String, Class<?>> entry : commandMap.entrySet()) {
  //
  // this.controller.registerCommand(entry.getKey(), command);
  // WorkerImpl.getInstance().registerClass(command.getClass(),
  // entry.getKey(), entry.getValue());
  // }
  // }

  // /**
  // * Put the <notification,class> map in the worker piece and register the
  // * command
  // */
  // private void registerWorkerMediator(final Map<String, Class<?>>
  // mediatorMap,
  // final Mediator mediator) {
  // for (final Map.Entry<String, Class<?>> entry : mediatorMap.entrySet()) {
  // WorkerImpl.getInstance().registerClass(mediator.getClass(),
  // entry.getKey(), entry.getValue());
  // }
  // }

  @Override
  public final void registerProxy(final Proxy proxy) {
    proxy.assignFacade(this);
    this.model.registerProxy(proxy);
  }

  @Override
  public final void removeAllProxies() {
    this.model.removeAllProxies();
  }

  @Override
  public final Proxy removeProxy(final String proxyName) {
    Proxy returnedProxy = null;
    if (this.model != null) {
      returnedProxy = this.model.removeProxy(proxyName);
      returnedProxy.assignFacade(null);
    }
    else {
      logger.warn("Model not initialized for proxy: " + proxyName + " removal");
    }
    return returnedProxy;
  }

  @Override
  public final Proxy retrieveProxy(final Class<?> proxyClass) {
    return this.model.retrieveProxy(proxyClass.getSimpleName());
  }

  @Override
  public final Proxy retrieveProxy(final String proxyName) {
    return this.model.retrieveProxy(proxyName);
  }

  @Override
  public final void sendNotification(final String notificationName,
    final Object body, final String type) {
    try {
      assert (notificationName != null) : "Notification name cannot be null";
      this
        .notifyObservers(new SimpleNotification(notificationName, body, type));
      // Must catch Throwable in order to handle all previous uncaught
      // exceptions
      // }
      // catch (final UnexpectedRollbackException e) {
      // logger.warn(e.getMessage(), e.getCause());
    }
    catch (final Throwable throwable) {
      logger.error("Error sending Notification: " + notificationName + "!! "
        + throwable.getMessage(), throwable.getCause());
      this.processException(throwable);
    }
  }

  @Override
  public final void setCommandContainerCollection(
    final Collection<CommandContainer> commandContainerCollection) {
    for (final CommandContainer commandContainer : commandContainerCollection) {
      for (final Map.Entry<String, Command> entry : commandContainer
        .getCommandMap().entrySet()) {
        this.registerCommand(entry.getKey(), entry.getValue());
      }
    }
  }

  @Override
  public final void setEnabledEventDispatching(
    final boolean enabledEventDispatching) {
    this.enabledEventDispatching = enabledEventDispatching;
  }

  @Override
  public final void setEventInterceptorList(
    final List<EventInterceptor> eventInterceptorList) {
    for (final EventInterceptor eventInterceptor : eventInterceptorList) {
      this.registerEventInterceptor(eventInterceptor);
    }
  }

  @Override
  public final void setFacade(final Facade parentFacade) {
    this.parentFacade = parentFacade;
  }

  @Override
  public final void setMediatorContainerCollection(
    final Collection<MediatorContainer> mediatorContainerCollection) {
    for (final MediatorContainer mediatorContainer : mediatorContainerCollection) {
      for (final Mediator mediator : mediatorContainer.getMediatorCollection()) {
        this.registerMediator(mediator);
      }
    }
  }
}
