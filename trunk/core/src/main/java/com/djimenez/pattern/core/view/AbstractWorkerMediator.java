package com.djimenez.pattern.core.view;

import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.worker.WorkerMediator;

/**
 * Abstract class to implements workerMediators in external classes.
 */
public abstract class AbstractWorkerMediator implements WorkerMediator {

  protected Facade facade;

  /**
   * @param facade
   */
  protected AbstractWorkerMediator(final Facade facade) {
    this.facade = facade;
  }
}
