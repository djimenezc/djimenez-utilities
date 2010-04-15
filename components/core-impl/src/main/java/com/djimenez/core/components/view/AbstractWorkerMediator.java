package com.djimenez.core.components.view;

import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.worker.WorkerMediator;

/**
 * Abstract class to implements workerMediators in external classes.
 */
public abstract class AbstractWorkerMediator implements WorkerMediator {

  private Facade facade;

  /**
   * @param facade
   */
  protected AbstractWorkerMediator(final Facade facade) {
    this.setFacade(facade);
  }

  /**
   * @return the facade
   */
  public final Facade getFacade() {
    return facade;
  }

  /**
   * @param facade
   *          the facade to set
   */
  public final void setFacade(final Facade facade) {
    this.facade = facade;
  }
}
