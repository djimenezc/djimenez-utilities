package com.djimenez.core.patterns.impl.command;

import org.apache.log4j.Logger;

/**
 * A single command abstract class.
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public abstract class AbstractSimpleCommand extends AbstractCommand {

  protected static final Logger logger =
    Logger.getLogger(AbstractSimpleCommand.class);

  protected AbstractSimpleCommand() {
    if (logger.isDebugEnabled()) {
      logger.debug("Command " + this.getClass().getSimpleName()
        + " initialized");
    }
  }
}
