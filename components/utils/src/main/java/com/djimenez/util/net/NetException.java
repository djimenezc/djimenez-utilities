package com.djimenez.util.net;

/**
 * Net exception.
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class NetException extends Exception {

  private static final long serialVersionUID = -2946737594130469541L;

  public NetException() {
    super();
  }

  public NetException(final String arg) {
    super(arg);
  }

  public NetException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public NetException(final Throwable cause) {
    super(cause);
  }
}
