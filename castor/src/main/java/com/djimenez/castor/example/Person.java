package com.djimenez.castor.example;

import java.util.Date;

/** An simple person class */
public class Person implements java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3736140366405965827L;

  /** The name of the person */
  private String name = null;

  /** The Date of birth */
  private Date dob = null;

  /** Creates a Person with no name */
  public Person() {
    super();
  }

  /** Creates a Person with the given name */
  public Person(final String name) {
    this.name = name;
  }

  /** * @return date of birth of the person */
  public Date getDateOfBirth() {
    return dob;
  }

  /** * @return name of the person */
  public String getName() {
    return name;
  }

  /**
   * * Sets the date of birth of the person * @param name the name of the person
   */
  public void setDateOfBirth(final Date dob) {
    this.dob = dob;
  }

  /**
   * * Sets the name of the person * @param name the name of the person
   */
  public void setName(final String name) {
    this.name = name;
  }
}
