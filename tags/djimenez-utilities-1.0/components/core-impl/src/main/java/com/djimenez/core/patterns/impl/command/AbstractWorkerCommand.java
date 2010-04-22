package com.djimenez.core.patterns.impl.command;

import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.worker.WorkerCommand;

/**
 * Abstract class to implements workerCommands in external classes.
 */
public abstract class AbstractWorkerCommand implements WorkerCommand {

  private final Facade facade;

  protected AbstractWorkerCommand(final Facade facade) {
    this.facade = facade;
  }

  /**
   * @return the facade
   */
  public final Facade getFacade() {
    return facade;
  }

}
