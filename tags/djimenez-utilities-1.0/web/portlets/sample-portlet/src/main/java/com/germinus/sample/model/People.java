/*
 * Copyright 2005 Joe Walker Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.germinus.sample.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.directwebremoting.util.Logger;

/**
 * A container for a set of people
 * 
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class People {

  /**
   * The next ID, to get around serialization issues
   */
  private static int nextId = 1;

  /**
   * Get the next unique ID in a thread safe way
   * 
   * @return a unique id
   */
  private static synchronized int getNextId() {
    return nextId++;
  }

  /**
   * the current list of people
   */
  private final Set<Person> people = new HashSet<Person>();

  private final Random random = new Random();

  private static final String[] FIRSTNAMES =
    { "Fred", "Jim", "Shiela", "Jack", "Betty", "Jacob", "Martha", "Kelly",
      "Luke", "Matt", "Gemma", "Joe", "Ben", "Jessie", "Leanne", "Becky", };
  private static final String[] SURNAMES =
    { "Sutcliffe", "MacDonald", "Duckworth", "Smith", "Wisner", "Iversen",
      "Nield", "Turton", "Trelfer", "Wilson", "Johnson", "Cowan", "Daniels", };

  private static final String[] ROADS1 =
    { "Green", "Red", "Yellow", "Brown", "Blue", "Black", "White", };

  private static final String[] ROADS2 =
    { "Close", "Drive", "Street", "Avenue", "Crescent", "Road", "Place", };

  private static final String[] TOWNS =
    { "Birmingham", "Kettering", "Paris", "San Francisco", "New York",
      "San Mateo", "Barcelona", };

  /**
   * The log stream
   */
  private final Logger log = Logger.getLogger(People.class);

  /**
   * Pre-populate with random people
   */
  public People() {

    log.debug("Generating a new set of random people");

    final int j = 5;
    for (int i = 0; i < j; i++) {
      people.add(getRandomPerson());
    }
  }

  /**
   * List the current people so we know what is going on
   */
  protected final void debug() {
    for (final Object element : people) {
      final Person person = (Person) element;
      log.debug(person.toString());
    }
  }

  /**
   * Delete a person from the set of people
   * 
   * @param person
   *          The person to delete
   */
  public final void deletePerson(final Person person) {
    log.debug("Removing person: " + person);
    people.remove(person);
    debug();
  }

  /**
   * Accessor for the current list of people
   * 
   * @return the current list of people
   */
  public final Set<Person> getAllPeople() {

    return people;
  }

  /**
   * Create a random person
   * 
   * @return a random person
   */
  private Person getRandomPerson() {
    final Person person = new Person();
    person.setId(getNextId());

    final String firstname = FIRSTNAMES[random.nextInt(FIRSTNAMES.length)];
    final String surname = SURNAMES[random.nextInt(SURNAMES.length)];
    person.setName(firstname + " " + surname);

    final int n = 99;
    final int i = 1;
    final String housenum = (random.nextInt(n) + i) + " ";
    final String road1 = ROADS1[random.nextInt(ROADS1.length)];
    final String road2 = ROADS2[random.nextInt(ROADS2.length)];
    final String town = TOWNS[random.nextInt(TOWNS.length)];
    final String address = housenum + road1 + " " + road2 + ", " + town;
    person.setAddress(address);

    final int j = 10;
    final int k = 90;
    final int l = 1000;
    final float salary = Math.round(j + k * random.nextFloat()) * l;
    person.setSalary(salary);

    return person;
  }

  /**
   * Insert a person into the set of people
   * 
   * @param person
   *          The person to add or update
   */
  public final void setPerson(final Person person) {
    log.debug("Adding person: " + person);
    if (person.getId() == -1) {
      person.setId(getNextId());
    }

    people.remove(person);
    people.add(person);
  }
}
