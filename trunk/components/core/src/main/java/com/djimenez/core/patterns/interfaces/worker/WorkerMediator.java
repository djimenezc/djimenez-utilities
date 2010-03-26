package com.djimenez.core.patterns.interfaces.worker;

import com.djimenez.core.patterns.interfaces.Notification;

/**
 * Interface to implements mediators in Service-To-Worker pattern.
 */
public interface WorkerMediator {

  /**
   * @param notification
   */
  void onNotification(Notification notification);
}
