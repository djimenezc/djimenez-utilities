package com.djimenez.core.patterns.interfaces.worker;

import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.core.patterns.interfaces.mvc.Mediator;
import com.djimenez.model.keys.KeyType;

/**
 * Worker interface
 */
public interface Worker {

  /**
   * @param notification
   * @param commnad
   */
  void doExecute(Notification notification, Command commnad);

  /**
   * @param notification
   * @param mediator
   */
  void doOnNotification(Notification notification, Mediator mediator);

  /**
   * @param submitKey
   * @param operatorLine
   * @param mediator
   */
  void doOnSubmit(KeyType submitKey, String operatorLine, Mediator mediator);

  /**
   * @param className
   * @param notificationName
   * @param stepClassName
   */
  void registerClass(final Class<?> className, String notificationName,
    final Class<?> stepClassName);

}
