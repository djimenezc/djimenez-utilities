package com.djimenez.test.example.acceptance.hellopepe;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class HelloPepeTest {

  public String greetingFor(final String firstName) {

    return "¡Hola " + firstName + "!";
  }

}
