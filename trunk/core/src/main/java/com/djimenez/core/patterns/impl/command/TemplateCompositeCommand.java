package com.djimenez.core.patterns.impl.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.djimenez.core.patterns.interfaces.CommandNotification;
import com.djimenez.core.patterns.interfaces.Notification;

/**
 * A Command Compotite template.
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public class TemplateCompositeCommand extends AbstractCommand {

  protected static final Logger logger =
    Logger.getLogger(TemplateCompositeCommand.class);

  private List<CommandNotification> subCommands = null;

  public TemplateCompositeCommand() {
    this.subCommands = new ArrayList<CommandNotification>();
  }

  public void addSubCommand(final CommandNotification command) {
    this.subCommands.add(command);
  }

  public void addSubCommands(final List<CommandNotification> newSubCommands) {
    this.subCommands.addAll(newSubCommands);
  }

  @Override
  public void execute() {

    for (final CommandNotification command : this.subCommands) {
      command.execute();
    }
  }

  @Override
  public void execute(final Notification notification) throws Throwable {

    for (final CommandNotification command : this.subCommands) {
      command.execute(notification);
    }
  }

  public void setSubCommands(final List<CommandNotification> subCommands) {
    this.subCommands = subCommands;
    if (logger.isDebugEnabled()) {
      for (final CommandNotification command : subCommands) {
        logger.debug("Added command: " + command.getClass().getSimpleName());
      }
    }
  }
}
