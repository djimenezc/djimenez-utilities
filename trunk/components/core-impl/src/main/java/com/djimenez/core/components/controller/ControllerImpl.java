package com.djimenez.core.components.controller;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.djimenez.core.components.view.ViewImpl;
import com.djimenez.core.components.worker.WorkerImpl;
import com.djimenez.core.exception.ControllerException;
import com.djimenez.core.exception.DuplicateNotificationException;
import com.djimenez.core.patterns.impl.observer.ObserverImpl;
import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.Function;
import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.core.patterns.interfaces.command.CommandNotification;
import com.djimenez.core.patterns.interfaces.mvc.Controller;
import com.djimenez.core.patterns.interfaces.mvc.View;
import com.djimenez.core.patterns.interfaces.worker.Workable;
import com.djimenez.core.patterns.interfaces.worker.Worker;

/**
 * The Controller container is implemented as a Singleton that maintains a
 * mapping between Notification names and Command implementations. The
 * Controller maintains named mappings to an implemented Command.
 * 
 * @author djimenez
 * @version 1.2
 * @see es.com.djimenez.pattern.interfaces.mvc.interfaces.Controller
 */
public final class ControllerImpl implements Controller, ControllerImplMBean {

  private static Logger logger = Logger.getLogger(ControllerImpl.class);
  private static Controller instance;

  public static Controller getInstance() {
    if (instance == null) {
      instance = new ControllerImpl();
    }
    return instance;
  }

  private final Map<String, CommandNotification> commandMap;
  private View view;
  private Worker worker;

  private CommandNotification currentCommand;

  private ControllerImpl() {

    this.commandMap = new Hashtable<String, CommandNotification>();
    this.initializeController();
  }

  @Override
  public void executeCommand(final Notification notification) throws Exception {

    this.view.setCommandRunning(true);

    final String notificationName = notification.getName();

    this.currentCommand = this.commandMap.get(notificationName);

    final long before = System.currentTimeMillis();

    try {
      this.currentCommand.execute(notification);
    }
    catch (final Exception e) {
      // Check workable to set command running to view
      if (!(this.currentCommand instanceof Workable)) {
        this.view.setCommandRunning(false);
        throw e;
      }
    }
    final long totalTime = System.currentTimeMillis() - before;
    logger.info("Execution for " + notificationName + " lasted " + totalTime
      + "ms");
    // Check workable to set command running to view
    if (!(this.currentCommand instanceof Workable)) {
      this.view.setCommandRunning(false);
    }
  }

  @Override
  public Map<String, String> getCommandMap() {
    final Map<String, String> map = new HashMap<String, String>();

    final Set<Entry<String, CommandNotification>> set =
      this.commandMap.entrySet();

    for (final Entry<String, CommandNotification> entry : set) {
      map.put(entry.getKey(), entry.getValue().getClass().getSimpleName());
    }
    return map;
  }

  private void initializeController() {
    this.view = ViewImpl.getInstance();
    this.worker = WorkerImpl.getInstance();
  }

  @Override
  public void onEvent(final Event event) {
    if (this.currentCommand != null) {
      this.currentCommand.handleEvent(event);
    }
  }

  @Override
  public void registerCommand(final String notificationName,
    final CommandNotification command) {

    if ((notificationName == null) || (command == null)) {
      throw new ControllerException("Trying to register null Command");
    }

    if (logger.isDebugEnabled()) {
      if (this.commandMap.containsKey(notificationName)) {
        throw new DuplicateNotificationException("Notification "
          + notificationName
          + " already exists. Try to register with another name");
      }
    }
    this.commandMap.put(notificationName, command);

    if (logger.isDebugEnabled()) {
      logger.debug("Registered notification " + notificationName
        + " -> Command: " + command.getClass().getCanonicalName());
    }

    assert (this.view != null) : "View cannot be null";
    this.view.registerObserver(notificationName, new ObserverImpl(
      new Function() {

        @Override
        public void onNotification(final Notification notification)
          throws Exception {

          ControllerImpl.this.executeCommand(notification);

          if (command instanceof Workable) {
            ControllerImpl.this.worker.doExecute(notification, command);
            // Set commandRunning to false. Finished command execute.
            ControllerImpl.this.view.setCommandRunning(false);
          }

        }
      }, this));
  }

  @Override
  public void removeAllCommands() {
    this.commandMap.clear();
  }

  @Override
  public Command removeCommand(final String notificationName) {
    return this.commandMap.remove(notificationName);
  }

  @Override
  public String toString() {
    return "ControllerImpl{" + "commandMap=" + this.commandMap + ", view="
      + this.view + ", currentCommand=" + this.currentCommand + '}';
  }
}
