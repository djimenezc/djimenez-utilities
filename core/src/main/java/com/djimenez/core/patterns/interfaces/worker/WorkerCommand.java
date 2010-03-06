package com.djimenez.core.patterns.interfaces.worker;

import com.djimenez.core.patterns.interfaces.Notification;

/**
 * Interface to implements commands in Service-To-Worker pattern.
 */
public interface WorkerCommand {

  /**
   * @param notification
   */
  void execute(Notification notification);
}
