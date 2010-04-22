package com.djimenez.test.model;

public class Address {

  private String street;
  private String number;
  private String city;

  /**
   * @param street
   * @param number
   * @param city
   */
  public Address(final String street, final String number, final String city) {
    this.street = street;
    this.number = number;
    this.city = city;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * @param city
   *          the city to set
   */
  public void setCity(final String city) {
    this.city = city;
  }

  /**
   * @param number
   *          the number to set
   */
  public void setNumber(final String number) {
    this.number = number;
  }

  /**
   * @param street
   *          the street to set
   */
  public void setStreet(final String street) {
    this.street = street;
  }

}
