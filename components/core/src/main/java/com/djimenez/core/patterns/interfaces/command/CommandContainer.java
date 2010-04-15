package com.djimenez.core.patterns.interfaces.command;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * The Command container.
 * 
 * @author djimenez
 */
public class CommandContainer {

  private static Logger logger = Logger.getLogger(CommandContainer.class);

  private Map<String, Command> commandMap;

  public CommandContainer() {
    // do nothing yet
  }

  public final Map<String, Command> getCommandMap() {
    return this.commandMap;
  }

  public final void setCommandMap(final Map<String, Command> commandMap) {
    this.commandMap = commandMap;
    if (logger.isTraceEnabled()) {
      int i = 0;
      for (final Map.Entry<String, Command> entry : commandMap.entrySet()) {
        i++;
        logger.trace(i + ". " + entry.getKey() + " - " + entry.getValue());
      }
    }
  }

  @Override
  public final String toString() {
    return "CommandContainer [" + "commandMap " + this.commandMap + "]";
  }

}
