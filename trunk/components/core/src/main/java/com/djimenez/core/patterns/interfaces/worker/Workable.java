package com.djimenez.core.patterns.interfaces.worker;

import java.util.Map;

public interface Workable {

  /**
   * Get a new map with Notification names key and a workerComamnd or
   * workerMediator value class name.
   * 
   * @return Map<Notification.name,WorkerClass>
   */
  Map<String, Class<?>> getWorkerClassMap();

}
