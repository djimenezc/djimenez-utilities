package com.djimenez.test.example.acceptance.helloworld;

import org.concordion.integration.junit3.ConcordionTestCase;

public class HelloWorldTest extends ConcordionTestCase {

  public String getGreeting() {
    return "Hello World!";
  }

}
