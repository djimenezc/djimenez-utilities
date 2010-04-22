package com.djimenez.tuenti;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.djimenez.core.patterns.interfaces.command.Command;
import com.djimenez.test.spring.AbstractSpringTestCase;

@ContextConfiguration(locations = { "classpath:/spring/test-applicationContext.xml" })
public class LoginCommandTest extends AbstractSpringTestCase {

  @Autowired
  private Command loginCommand;

  @Test
  public final void testExecute() {

    loginCommand.execute();

  }

}
