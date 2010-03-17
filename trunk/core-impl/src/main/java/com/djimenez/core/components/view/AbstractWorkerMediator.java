package com.djimenez.core.components.view;

import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.worker.WorkerMediator;

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
