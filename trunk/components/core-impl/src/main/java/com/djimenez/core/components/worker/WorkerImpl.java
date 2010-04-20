package com.djimenez.core.components.worker;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.djimenez.core.components.view.ViewImpl;
import com.djimenez.core.components.worker.helper.ReflectionWorkerHelper;
import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.core.patterns.interfaces.mvc.Mediator;
import com.djimenez.core.patterns.interfaces.worker.Worker;
import com.djimenez.core.patterns.interfaces.worker.WorkerCommand;
import com.djimenez.core.patterns.interfaces.worker.WorkerMediator;
import com.djimenez.model.keys.KeyType;

public class WorkerImpl implements Worker {

  // Singleton instance
  private static WorkerImpl instance = null;
  // Current WorkerMediator
  private WorkerMediator currentWorkerMediator;
  // Map<ClassName, Map< Notification name , WorkerCommand > >
  private final Map<String, Map<String, WorkerCommand>> commandMap;
  // Map<ClassName, Map< Notification name , WorkerMediator > >
  private final Map<String, Map<String, WorkerMediator>> mediatorMap;
  // Map<ClassName, Map< Notification name , WorkerClass name > >
  private final Map<String, Map<String, String>> classMap;
  // Logger
  private static Logger logger = Logger.getLogger(WorkerImpl.class);

  /**
   * @return WorkerImpl singleton instance
   */
  public static WorkerImpl getInstance() {
    if (instance == null) {
      instance = new WorkerImpl();
    }
    return instance;
  }

  /**
   * Initialize all maps
   */
  public WorkerImpl() {
    this.commandMap = new Hashtable<String, Map<String, WorkerCommand>>();
    this.mediatorMap = new HashMap<String, Map<String, WorkerMediator>>();
    this.classMap = new HashMap<String, Map<String, String>>();
  }

  /**
   * Get WorkerCommand innerClass or outerClass of command and call execute
   * method
   */
  @Override
  public final void doExecute(final Notification notification,
    final Command command) {
    // String getClassName
    final String className = command.getClass().getName();
    // Check if exist inner object in mapObject
    if (this.commandMap.get(className).get(notification.getName()) == null) {
      // If not exist create new instance by class name and put
      // in mapObject
      final String workerClassName =
        this.classMap.get(className).get(notification.getName());
      // Find innnerClass
      WorkerCommand workerObject =
        ReflectionWorkerHelper.getWorkerCommandByClassName(workerClassName,
          command);
      if (workerObject == null) {
        // Find class in ClassLoader
        workerObject =
          ReflectionWorkerHelper.getAbstractWorkerCommandByClassName(
            workerClassName, command);
      }
      // Set services if exist
      BeanUtils.copyProperties(command, workerObject);
      // Put WorkerCommand object in commandMap
      this.commandMap.get(className).put(notification.getName(), workerObject);
    }
    // Get object and call to execute method
    this.commandMap.get(className).get(notification.getName()).execute(
      notification);
  }

  /**
   * Get WorkerMediator innerClass or outerClass of mediator and call
   * onNotification method. Set current WorkerMediator for doOnSubmit method
   */
  @Override
  public final void doOnNotification(final Notification notification,
    final Mediator mediator) {
    // Get className
    final String className = mediator.getClass().getName();
    // Check if exist inner object in
    if (this.mediatorMap.get(className).get(notification.getName()) == null) {
      // If not exist create new instance by class name and put
      // in mapObject
      final String workerClassName =
        this.classMap.get(className).get(notification.getName());
      // Find innerClass
      WorkerMediator workerObject =
        ReflectionWorkerHelper.getWorkerMediatorByClassName(workerClassName,
          mediator);
      if (workerObject == null) {
        // Find class in ClassLoader
        workerObject =
          ReflectionWorkerHelper.getAbstractWorkerMediatorByClassName(
            workerClassName, mediator);
      }
      // Put WorkerMediator object in mediatorMap
      this.mediatorMap.get(className).put(notification.getName(), workerObject);
    }
    // Set interested submitKeys by the current WorkerMediator object
    ReflectionWorkerHelper.setSubmitKeysInterested(this.mediatorMap.get(
      className).get(notification.getName()), mediator);

    // Get object and call to onNotification method
    this.currentWorkerMediator =
      this.mediatorMap.get(className).get(notification.getName());
    this.currentWorkerMediator.onNotification(notification);

  }

  /**
   * Invoke onSubmit method of current WorkerMediator
   */
  @Override
  public final void doOnSubmit(final KeyType submitKey,
    final String operatorLine, final Mediator mediator) {

    final String currentMediatorClassName =
      ViewImpl.getInstance().getCurrentMediator().getClass().getName();
    // If currentMediator is className type
    if (mediator.getClass().getName().equals(currentMediatorClassName)) {
      // Invoke onSubmit method by submitKey
      ReflectionWorkerHelper.invokeSubmitMethod(this.currentWorkerMediator,
        submitKey, operatorLine);
    }
    else {
      if (logger.isDebugEnabled()) {
        logger.debug("Executing " + mediator.getClass().getName()
          + " in  Worker mode misuse. \n" + "SubmitKey in another mediator: "
          + currentMediatorClassName);
      }
    }
  }

  /**
   * Add a new Class value with notificationName key
   */
  @Override
  public final void registerClass(final Class<?> outerClass,
    final String notificationName, final Class<?> workerClass) {

    final Map<String, String> stepCommandOrMediator =
      this.classMap.get(outerClass.getName());

    if (stepCommandOrMediator == null) {
      this.classMap.put(outerClass.getName(), new Hashtable<String, String>());
    }

    this.classMap.get(outerClass.getName()).put(notificationName,
      workerClass.getName());
    this.commandMap.put(outerClass.getName(),
      new Hashtable<String, WorkerCommand>());
    this.mediatorMap.put(outerClass.getName(),
      new Hashtable<String, WorkerMediator>());
  }

}