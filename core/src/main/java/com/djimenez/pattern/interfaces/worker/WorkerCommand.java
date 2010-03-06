package com.djimenez.pattern.interfaces.worker;

import com.djimenez.pattern.interfaces.Notification;

/**
 * Interface to implements commands in Service-To-Worker pattern.
 */
public interface WorkerCommand {

  /**
   * @param notification
   */
  void execute(Notification notification);
}
