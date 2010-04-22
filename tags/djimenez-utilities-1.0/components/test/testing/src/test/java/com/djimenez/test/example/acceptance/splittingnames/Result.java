package com.djimenez.test.example.acceptance.splittingnames;

public class Result {

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
