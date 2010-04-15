package com.germinus.sample.dao;

import junit.framework.Test;
import junit.framework.TestSuite;

public final class AllTests {

  public static Test suite() {

    final TestSuite suite = new TestSuite("Test for com.germinus.sample.dao");

    // $JUnit-BEGIN$
    suite.addTestSuite(TestBookViewController.class);
    // $JUnit-END$

    return suite;

  }

  private AllTests() {

  }
}
