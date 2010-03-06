package com.djimenez.pattern.impl.command;

import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.worker.WorkerCommand;

/**
 * Abstract class to implements workerCommands in external classes.
 */
public abstract class AbstractWorkerCommand implements WorkerCommand {

  protected final Facade facade;

  protected AbstractWorkerCommand(final Facade facade) {
    this.facade = facade;
  }

}
