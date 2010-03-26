package com.djimenez.test.model;

public class Persona {

  private int id;

  private String nombre;

  private String apellido;

  public Persona(final int id, final String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Persona(final int id, final String nombre, final String apellido) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public String getApellido() {
    return apellido;
  }

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setApellido(final String apellido) {
    this.apellido = apellido;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return id + " - " + nombre;
  }
}