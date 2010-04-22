package com.djimenez.webservice.helloworld.model;

import java.io.Serializable;

public class Response implements Serializable {

  private static final long serialVersionUID = -4349542390716335469L;

  private String name;

  private String surname;

  public Response() {

  }

  public Response(final String name, final String surname) {

    this.name = name;
    this.surname = surname;
  }

  /**
   * @return the name
   */
  public final String getName() {
    return name;
  }

  /**
   * @return the surname
   */
  public final String getSurname() {
    return surname;
  }

  /**
   * @param name
   *          the name to set
   */
  public final void setName(final String name) {
    this.name = name;
  }

  /**
   * @param surname
   *          the surname to set
   */
  public final void setSurname(final String surname) {
    this.surname = surname;
  }
}
