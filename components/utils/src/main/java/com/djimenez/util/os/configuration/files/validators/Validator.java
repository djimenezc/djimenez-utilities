package com.djimenez.util.os.configuration.files.validators;

/**
 * Template for data validation
 * 
 * @author Rodrigo Villamil Perez
 */
public interface Validator<Type> {

  /**
   * Defatult error message generated when validation returns false.
   */
  String getErrorMesg();

  /**
   * Validate the format of parameter 'value.'
   */
  boolean validate(final Type value);
}
