package com.djimenez.test.example.acceptance.splittingnames;

import org.concordion.integration.junit3.ConcordionTestCase;

public class SplittingNamesTest extends ConcordionTestCase {

  public Result split(final String fullName) {

    final String[] words = fullName.split(" ");

    final Result result = new Result(words[0], words[1]);

    return result;
  }

}
