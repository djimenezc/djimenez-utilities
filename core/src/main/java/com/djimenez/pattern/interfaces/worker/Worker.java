package com.djimenez.pattern.interfaces.worker;

import com.djimenez.pattern.core.keys.KeyType;
import com.djimenez.pattern.interfaces.Command;
import com.djimenez.pattern.interfaces.Notification;
import com.djimenez.pattern.interfaces.mvc.Mediator;

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
