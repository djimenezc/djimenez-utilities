package com.gowex.sms.sent.example.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.gowex.patterns.command.Command;

@ContextConfiguration(locations = { "classpath:/spring/test-applicationContext.xml" })
public class LoginCommandTest {

  @Autowired
  private Command loginCommand;

  @Test
  public final void testExecute() {

    loginCommand.execute();

  }

}
