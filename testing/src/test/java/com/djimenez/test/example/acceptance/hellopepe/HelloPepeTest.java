package com.djimenez.test.example.acceptance.hellopepe;

import org.concordion.integration.junit3.ConcordionTestCase;

public class HelloPepeTest extends ConcordionTestCase {

  public String greetingFor(final String firstName) {

    return "¡Hola " + firstName + "!";
  }

}
