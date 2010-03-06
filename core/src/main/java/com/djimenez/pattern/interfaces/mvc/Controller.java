package com.djimenez.pattern.interfaces.mvc;

import com.djimenez.pattern.interfaces.Command;
import com.djimenez.pattern.interfaces.CommandNotification;
import com.djimenez.pattern.interfaces.EventListener;
import com.djimenez.pattern.interfaces.Notification;

/**
 * When it is initialized (typically by an Facade implementation), the
 * Controller creates and registers with the View an appropriate Observer
 * instance for each Notification to Command mapping, the commandMap method,
 * such that when any of the registered Notifications are broadcast, the
 * Controller's <i>executeCommand</i> method is called with the Notification.
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Controller extends EventListener {

  void registerCommand(String notificationName, CommandNotification command);

  void executeCommand(Notification notification) throws Throwable;

  Command removeCommand(String notificationName);

  void removeAllCommands();

}
