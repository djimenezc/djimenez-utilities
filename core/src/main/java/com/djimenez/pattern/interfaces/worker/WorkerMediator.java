package com.djimenez.pattern.interfaces.worker;

import com.djimenez.pattern.interfaces.Notification;

/**
 * Interface to implements mediators in Service-To-Worker pattern.
 */
public interface WorkerMediator {

  /**
   * @param notification
   */
  void onNotification(Notification notification);
}
