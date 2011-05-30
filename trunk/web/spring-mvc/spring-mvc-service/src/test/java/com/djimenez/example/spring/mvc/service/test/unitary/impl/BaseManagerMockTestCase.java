package com.djimenez.example.spring.mvc.service.test.unitary.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.runner.RunWith;

import com.djimenez.util.appfuse.ConvertUtil;

/**
 * A mock class for testing using JMock. This test class can be moved to the
 * test tree.
 * 
 * @author mraible
 */
@RunWith(JMock.class)
public abstract class BaseManagerMockTestCase {

  /**
   * A logger
   */
  private static final Log LOG =
    LogFactory.getLog(BaseManagerMockTestCase.class);

  /**
   * @return the log
   */
  protected static Log getLog() {
    return LOG;
  }

  /**
   * The resourceBundle
   */
  private ResourceBundle rb;

  /**
   * The junit 4 context
   */
  private final Mockery context = new JUnit4Mockery();

  /**
   * Default constructor will set the ResourceBundle if needed.
   */
  public BaseManagerMockTestCase() {
    // Since a ResourceBundle is not required for each class, just
    // do a simple check to see if one exists
    final String className = this.getClass().getName();

    try {
      rb = ResourceBundle.getBundle(className);
    }
    catch (final MissingResourceException mre) {
      // log.debug("No resource bundle found for: " + className);
    }
  }

  /**
   * @return the context
   */
  public final Mockery getContext() {
    return context;
  }

  /**
   * @return the rb
   */
  public final ResourceBundle getRb() {
    return rb;
  }

  /**
   * Utility method to populate a javabean-style object with values from a
   * Properties file
   * 
   * @param obj
   *          the model object to populate
   * @return Object populated object
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   * @throws Exception
   *           if BeanUtils fails to copy properly
   */
  protected final Object populate(final Object obj)
    throws IllegalAccessException, InvocationTargetException {
    // loop through all the beans methods and set its properties from
    // its .properties file
    final Map<?, ?> map = ConvertUtil.convertBundleToMap(getRb());

    BeanUtils.copyProperties(obj, map);

    return obj;
  }

}