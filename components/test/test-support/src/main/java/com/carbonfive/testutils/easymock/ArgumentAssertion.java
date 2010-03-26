package com.carbonfive.testutils.easymock;

import org.easymock.IArgumentMatcher;

public class ArgumentAssertion implements IArgumentMatcher {

  @SuppressWarnings("unchecked")
  private final Assertion assertion;

  private Error assertionError;

  @SuppressWarnings("unchecked")
  public ArgumentAssertion(final Assertion assertion) {
    this.assertion = assertion;
  }

  @SuppressWarnings("unchecked")
  public boolean matches(final Object actual) {
    try {
      assertion.check(actual);
      return true;
    }
    catch (final Error e) {
      assertionError = e;
      return false;
    }
    catch (final Exception e) {
      assertionError = new Error(e);
      return false;
    }
  }

  public void appendTo(final StringBuffer buffer) {
    buffer.append("argumentAssertion(exception ").append(assertionError)
      .append(")");
  }
}