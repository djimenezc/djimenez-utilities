package com.djimenez.tuenti;

import org.junit.Test;

import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.test.spring.AbstractSpringTest;

public class LoginCommandTest extends AbstractSpringTest {

  private Command loginCommand;

  @Override
  protected String[] getConfigLocations() {
    setAutowireMode(AUTOWIRE_BY_NAME);
    return new String[] { "classpath:spring/test-applicationContext.xml" };
  }

  @Test
  public void testExecute() {

    loginCommand.execute();

  }

  /**
   * @param loginCommand
   *          the loginCommand to set
   */
  public void setLoginCommand(final Command loginCommand) {
    this.loginCommand = loginCommand;
  }

}
