package com.djimenez.test.example.acceptance.splittingnames;

import org.concordion.integration.junit3.ConcordionTestCase;

public class SplittingNamesTest extends ConcordionTestCase {

  public Result split(final String fullName) {

    final String[] words = fullName.split(" ");

    final Result result = new Result(words[0], words[1]);

    return result;
  }

  class Result {

    private final String firstName;
    private final String lastName;

    public Result(final String firstName, final String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }
  }

}
