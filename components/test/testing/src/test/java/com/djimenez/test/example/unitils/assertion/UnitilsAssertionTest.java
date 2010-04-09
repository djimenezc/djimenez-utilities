package com.djimenez.test.example.unitils.assertion;

import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import com.djimenez.test.model.Address;
import com.djimenez.test.model.UserTestBean;

public class UnitilsAssertionTest extends TestCase {

  @BeforeClass
  public static void setUpClass() {

  }

  public void testAssertionReflection() {

    final UserTestBean userTest1 = new UserTestBean(1, "John", "Doe");
    final UserTestBean userTest2 = new UserTestBean(1, "John", "Doe");

    assertReflectionEquals(userTest1, userTest2);
  }

  public void testAssertionReflectionIgnoringDefaults() {

    final UserTestBean actualUser =
      new UserTestBean("John", "Doe", new Address("First street", "12", "Brussels"));

    final UserTestBean expectedUser =
      new UserTestBean("John", null, new Address("First street", null, null));

    assertReflectionEquals(expectedUser, actualUser,
      ReflectionComparatorMode.IGNORE_DEFAULTS);
  }

  public void testAssertionReflectionLenient() {

    final List<Integer> myList = Arrays.asList(3, 2, 1);
    ReflectionAssert.assertLenientEquals(Arrays.asList(1, 2, 3), myList);
  }

  public void testAssertionReflectionLenientDate() {

    final Date actualDate = new Date(44444);
    final Date expectedDate = new Date();
    assertReflectionEquals(expectedDate, actualDate,
      ReflectionComparatorMode.LENIENT_DATES);
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

  public void testAssertionReflectionProperty1() {

    final UserTestBean userTest1 = new UserTestBean(1, "John", "Doe");

    assertPropertyLenientEquals("id", 1, userTest1);
  }

  public void testAssertionReflectionProperty2() {

    final UserTestBean userTest2 =
      new UserTestBean("John", "Doe", new Address("First street", "12", "Brussels"));

    assertPropertyLenientEquals("address.street", "First street", userTest2);
  }

  public void testAssertionReflectionPropertyCollections1() {

    final List<UserTestBean> users = new ArrayList<UserTestBean>();

    users.add(new UserTestBean(1, ""));
    users.add(new UserTestBean(2, ""));
    users.add(new UserTestBean(3, ""));

    assertPropertyLenientEquals("id", Arrays.asList(1, 2, 3), users);

  }

  public void testAssertionReflectionPropertyCollections2() {

    final List<UserTestBean> users = new ArrayList<UserTestBean>();

    users.add(new UserTestBean("david", "jimenez", new Address("First street",
      "12", "Brussels")));
    users.add(new UserTestBean("david", "jimenez", new Address("Second street",
      "12", "Brussels")));
    users.add(new UserTestBean("david", "jimenez", new Address("Third street",
      "12", "Brussels")));
    
    assertPropertyLenientEquals("address.street", Arrays.asList("First street",
      "Second street", "Third street"), users);
  }
}
