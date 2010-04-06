package com.djimenez.test.example.unitils.assertion;

import junit.framework.TestCase;

import org.unitils.reflectionassert.ReflectionAssert;

import com.djimenez.test.model.UserTest;

public class UnitilsAssertionTest extends TestCase {

  public void testAssertionReflectionTest() {

    final UserTest UserTest1 = new UserTest(1, "John", "Doe");
    final UserTest UserTest2 = new UserTest(1, "John", "Doe");

    ReflectionAssert.assertReflectionEquals(UserTest1, UserTest2);

  }
}
