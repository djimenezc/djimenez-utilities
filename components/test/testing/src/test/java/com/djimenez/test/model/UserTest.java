package com.djimenez.test.model;

public class UserTest {

  private int id;

  private String name;

  private String firstSurname;

  private String secondSurname;

  private Address address;

  public UserTest(final int id, final String nombre) {
    this.id = id;
    this.name = nombre;
  }

  public UserTest(final int id, final String nombre, final String apellido) {

    this.id = id;
    this.name = nombre;
    this.firstSurname = apellido;
  }

  /**
   * @param name
   * @param firstSurname
   * @param address
   */
  public UserTest(final String name, final String firstSurname,
    final Address address) {

    this.name = name;
    this.firstSurname = firstSurname;
    this.address = address;
  }

  /**
   * @return the address
   */
  public Address getAddress() {
    return address;
  }

  public String getFirstSurname() {
    return firstSurname;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  /**
   * @return the secondSurname
   */
  public String getSecondSurname() {
    return secondSurname;
  }

  /**
   * @param address
   *          the address to set
   */
  public void setAddress(final Address address) {
    this.address = address;
  }

  public void setFirstSurname(final String apellido) {
    this.firstSurname = apellido;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setName(final String nombre) {
    this.name = nombre;
  }

  /**
   * @param secondSurname
   *          the secondSurname to set
   */
  public void setSecondSurname(final String secondSurname) {
    this.secondSurname = secondSurname;
  }

  @Override
  public String toString() {
    return id + " - " + name;
  }
}