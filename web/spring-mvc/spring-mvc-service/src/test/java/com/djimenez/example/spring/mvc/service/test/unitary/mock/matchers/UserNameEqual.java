package com.djimenez.example.spring.mvc.service.test.unitary.mock.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.djimenez.example.spring.mvc.model.User;

public class UserNameEqual extends TypeSafeMatcher<User> {

  private final String name;

  public UserNameEqual(final String name) {
    this.name = name;
  }

  public final void describeTo(final Description description) {
    describeTo(description.appendText("a name equals to ").appendValue(name));
  }

  @Override
  public final boolean matchesSafely(final User user) {

    return user.getUsername().equals(name);
    // return false;
  }

}
