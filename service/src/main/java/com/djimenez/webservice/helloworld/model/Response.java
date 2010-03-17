package com.djimenez.webservice.helloworld.model;

import java.io.Serializable;

public class Response implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -4349542390716335469L;

  String name;

  String surname;

  public Response() {

  }

  public Response(final String name, final String surname) {

    this.name = name;
    this.surname = surname;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the surname
   */
  public String getSurname() {
    return surname;
  }

  /**
   * @param name
   *          the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * @param surname
   *          the surname to set
   */
  public void setSurname(final String surname) {
    this.surname = surname;
  }
}