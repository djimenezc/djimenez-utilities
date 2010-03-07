package com.djimenez.util.internationalization;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public class InternationalizationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InternationalizationException(final String arg0) {
    super(arg0);
  }

  public InternationalizationException(final String arg0, final Throwable arg1) {
    super(arg0, arg1);
  }

  public InternationalizationException(final Throwable arg0) {
    super(arg0);
  }

}
