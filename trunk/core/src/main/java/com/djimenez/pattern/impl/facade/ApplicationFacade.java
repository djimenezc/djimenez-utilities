package com.djimenez.pattern.impl.facade;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.djimenez.pattern.core.controller.CommandContainer;
import com.djimenez.pattern.core.controller.ControllerImpl;
import com.djimenez.pattern.core.model.ModelImpl;
import com.djimenez.pattern.core.view.MediatorContainer;
import com.djimenez.pattern.core.view.ViewImpl;
import com.djimenez.pattern.core.worker.WorkerImpl;
import com.djimenez.pattern.impl.observer.SimpleNotification;
import com.djimenez.pattern.interfaces.Command;
import com.djimenez.pattern.interfaces.Event;
import com.djimenez.pattern.interfaces.EventInterceptor;
import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.Model;
import com.djimenez.pattern.interfaces.Notification;
import com.djimenez.pattern.interfaces.Proxy;
import com.djimenez.pattern.interfaces.mvc.Controller;
import com.djimenez.pattern.interfaces.mvc.Mediator;
import com.djimenez.pattern.interfaces.mvc.View;
import com.djimenez.pattern.interfaces.worker.Worker;

/**
 * @author djimenez
 * @version 1.6
 * @since 1.0
 */
public abstract class ApplicationFacade implements Facade {

  protected static final Logger logger =
    Logger.getLogger(ApplicationFacade.class);

  protected Facade parentFacade;
  private Map<String, EventInterceptor> eventInterceptorMap;
  protected Controller controller = null;
  protected View view = null;
  private Model model = null;
  private Worker worker = null;
  private boolean enabledEventDispatching;

  public ApplicationFacade() {
    logger.info("[Facade] Initializing " + this.getClass().getSimpleName()
      + "...");
    this.initializeFacade();
    logger.info("[Facade] Initialized " + this.getClass().getSimpleName());
  }

  private void initializeFacade() {
    this.initializeModel();
    this.initializeController();
    this.initializeView();
    this.initializeWorker();

    this.eventInterceptorMap = new Hashtable<String, EventInterceptor>();
    this.enabledEventDispatching = false;
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

  @Override
  public Controller getController() {
    return controller;
  }

  @Override
  public Model getModel() {
    return model;
  }

  @Override
  public View getView() {
    return view;
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
  public void registerProxy(final Proxy proxy) {
    proxy.assignFacade(this);
    this.model.registerProxy(proxy);
  }

  @Override
  public Proxy removeProxy(final String proxyName) {
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
  public Proxy retrieveProxy(final String proxyName) {
    return this.model.retrieveProxy(proxyName);
  }

  @Override
  public Proxy retrieveProxy(final Class<?> proxyClass) {
    return this.model.retrieveProxy(proxyClass.getSimpleName());
  }

  @Override
  public void sendNotification(final String notificationName,
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
  public void notifyObservers(final Notification notification) throws Throwable {
    if (this.view != null) {
      this.view.notifyObservers(notification);
    }
    else {
      logger.warn("View not initialized yet for notification: " + notification);
    }
  }

  @Override
  public void setCommandContainerCollection(
    final Collection<CommandContainer> commandContainerCollection) {
    for (final CommandContainer commandContainer : commandContainerCollection) {
      for (final Map.Entry<String, Command> entry : commandContainer
        .getCommandMap().entrySet()) {
        this.registerCommand(entry.getKey(), entry.getValue());
      }
    }
  }

  @Override
  public void setMediatorContainerCollection(
    final Collection<MediatorContainer> mediatorContainerCollection) {
    for (final MediatorContainer mediatorContainer : mediatorContainerCollection) {
      for (final Mediator mediator : mediatorContainer.getMediatorCollection()) {
        this.registerMediator(mediator);
      }
    }
  }

  @Override
  public void dispatchEvent(final Event event) {
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
  public void setEventInterceptorList(
    final List<EventInterceptor> eventInterceptorList) {
    for (final EventInterceptor eventInterceptor : eventInterceptorList) {
      this.registerEventInterceptor(eventInterceptor);
    }
  }

  @Override
  public void registerEventInterceptor(final EventInterceptor eventInterceptor) {
    eventInterceptor.setFacade(this);
    this.eventInterceptorMap.put(eventInterceptor.getName(), eventInterceptor);
  }

  @Override
  public EventInterceptor getEventInterceptor(final String eventInterceptorName) {
    return this.eventInterceptorMap.get(eventInterceptorName);
  }

  @Override
  public void setFacade(final Facade parentFacade) {
    this.parentFacade = parentFacade;
  }

  public boolean isEnabledEventDispatching() {
    return this.enabledEventDispatching;
  }

  @Override
  public void setEnabledEventDispatching(final boolean enabledEventDispatching) {
    this.enabledEventDispatching = enabledEventDispatching;
  }

  @Override
  public void removeAllProxies() {
    this.model.removeAllProxies();
  }
}
