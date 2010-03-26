package com.djimenez.util.os.services;

/**
 * Service management exception.
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class ServiceManagementException extends Exception {

  private static final long serialVersionUID = -2946737594130469541L;

  public ServiceManagementException() {
    super();
  }

  public ServiceManagementException(final String arg) {
    super(arg);
  }

  public ServiceManagementException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ServiceManagementException(final Throwable cause) {
    super(cause);
  }
}
