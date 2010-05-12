package com.djimenez.example.spring.mvc.service.test.integration;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.djimenez.util.appfuse.ConvertUtil;

@ContextConfiguration(locations = {
  "classpath:context/applicationContext-test-resources.xml",
  "classpath:context/applicationContext-dao.xml",
  "classpath:context/applicationContext-persistence.xml",
  "classpath:context/applicationContext-service.xml",
  "classpath*:/**/applicationContext.xml" })
/**
 * Test classes can extend this manager based on a spring context.
 * This test class can be moved to the test tree.
 *
 * @author mraible
 */
public abstract class BaseManagerIntegrationTestCase extends
  AbstractTransactionalJUnit4SpringContextTests {

  /**
   * A simple logger
   */
  // private static final Log LOG =
  // LogFactory.getLog(BaseManagerIntegrationTestCase.class);
  /**
   * The resourceBundle
   */
  private ResourceBundle rb;

  /**
   * Default constructor will set the ResourceBundle if needed.
   */
  public BaseManagerIntegrationTestCase() {
    // Since a ResourceBundle is not required for each class, just
    // do a simple check to see if one exists
    final String className = this.getClass().getName();

    try {
      rb = ResourceBundle.getBundle(className);
    }
    catch (final MissingResourceException mre) {
      // log.warn("No resource bundle found for: " + className);
    }
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
