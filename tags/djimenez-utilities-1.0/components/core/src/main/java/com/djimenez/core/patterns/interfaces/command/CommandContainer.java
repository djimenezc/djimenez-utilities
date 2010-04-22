package com.djimenez.core.patterns.interfaces.command;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * The Command container.
 * 
 * @author djimenez
 */
public class CommandContainer {

  private static final Logger LOG = Logger.getLogger(CommandContainer.class);

  private Map<String, Command> commandMap;

  public final Map<String, Command> getCommandMap() {
    return this.commandMap;
  }

  public final void setCommandMap(final Map<String, Command> commandMap) {

    this.commandMap = commandMap;

    if (LOG.isTraceEnabled()) {

      int pos = 0;

      for (final Map.Entry<String, Command> entry : commandMap.entrySet()) {
        pos++;
        LOG.trace(pos + ". " + entry.getKey() + " - " + entry.getValue());
      }
    }
  }

  @Override
  public final String toString() {
    return "CommandContainer [" + "commandMap " + this.commandMap + "]";
  }

}
