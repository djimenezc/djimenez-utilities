package com.djimenez.test.example.unitils.assertion;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.unitils.reflectionassert.ReflectionComparatorMode;

import com.djimenez.test.model.Address;
import com.djimenez.test.model.UserTest;

public class UnitilsAssertionTest extends TestCase {

  public void testAssertionReflection() {

    final UserTest UserTest1 = new UserTest(1, "John", "Doe");
    final UserTest UserTest2 = new UserTest(1, "John", "Doe");

    assertReflectionEquals(UserTest1, UserTest2);
  }

  public void testAssertionReflectionIgnoringDefaults() {

    final UserTest actualUser =
      new UserTest("John", "Doe", new Address("First street", "12", "Brussels"));

    final UserTest expectedUser =
      new UserTest("John", null, new Address("First street", null, null));
    assertReflectionEquals(expectedUser, actualUser,
      ReflectionComparatorMode.IGNORE_DEFAULTS);
  }

  public void testAssertionReflectionList() {

    final List<Double> myList = new ArrayList<Double>();
    myList.add(1.0);
    myList.add(2.0);
    assertReflectionEquals(Arrays.asList(1, 2), myList);
  }

  /**
   * Not import the ordering
   */
  public void testAssertionReflectionListLenient() {

    final List<Integer> myList = Arrays.asList(3, 2, 1);

    assertReflectionEquals(Arrays.asList(1, 2, 3), myList,
      ReflectionComparatorMode.LENIENT_ORDER);
  }

  public void testAssertionReflectionLong() {

    assertReflectionEquals(1, 1L);
  }
}
