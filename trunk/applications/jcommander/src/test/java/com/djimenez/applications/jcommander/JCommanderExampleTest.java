package com.djimenez.applications.jcommander;

import static org.junit.Assert.assertEquals;

import com.beust.jcommander.JCommander;

/**
 * Unit test for simple App.
 */
public class JCommanderExampleTest {

  /**
   * Rigourous Test :-)
   */
  @org.junit.Test
  public void test() {

    final JCommanderExample jct = new JCommanderExample();

    final String[] argv = { "-log", "2", "-groups", "unit", "a", "b", "c" };
    new JCommander(jct, argv);

    assertEquals(jct.verbose.intValue(), 2);
  }
}
