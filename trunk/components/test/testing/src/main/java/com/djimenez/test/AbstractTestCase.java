package com.djimenez.test;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.djimenez.util.beans.BeanUtils;

public abstract class AbstractTestCase {

  protected ResourceBundle rb;

  public AbstractTestCase() {

    // Since a ResourceBundle is not required for each class, just
    // do a simple check to see if one exists
    final String className = this.getClass().getName();

    retrieveProperties(className);
  }

  public AbstractTestCase(final String className) {

    retrieveProperties(className);
  }

  /**
   * Utility method to populate a javabean-style object with values from a
   * Properties file
   * 
   * @param obj
   *          the model object to populate
   * @return Object populated object
   * @throws Exception
   *           if BeanUtils fails to copy properly
   */
  public Object populate(final Object obj) {

    return BeanUtils.populate(obj, rb);
  }

  private void retrieveProperties(final String className) {
    try {
      rb = ResourceBundle.getBundle(className);
    }
    catch (final MissingResourceException mre) {
      // log.warn("No resource bundle found for: " + className);
    }
  }

}
