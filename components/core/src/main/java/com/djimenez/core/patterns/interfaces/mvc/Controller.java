package com.djimenez.core.patterns.interfaces.mvc;

import com.djimenez.core.patterns.interfaces.EventListener;
import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.core.patterns.interfaces.command.CommandNotification;

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

  void executeCommand(Notification notification) throws Throwable;

  void registerCommand(String notificationName, CommandNotification command);

  void removeAllCommands();

  Command removeCommand(String notificationName);

}
