package com.djimenez.example.spring.mvc.service.test.unitary.mock.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class StringStartsWithMatcher extends TypeSafeMatcher<String> {

  private final String prefix;

  public StringStartsWithMatcher(final String prefix) {
    this.prefix = prefix;
  }

  @Override
  public void describeTo(final Description description) {

    describeTo(description.appendText("a string starting with ").appendValue(
      prefix));
  }

  @Override
  public boolean matchesSafely(final String s) {
    return s.startsWith(prefix);
  }
}
