package com.djimenez.example.spring.mvc.persistence.dao.test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Base class for running DAO tests.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@ContextConfiguration(locations = {
  "classpath:context/applicationContext-test-resources.xml",
  "classpath:context/applicationContext-dao.xml",
  // "classpath*:/applicationContext.xml",
  "classpath:**/applicationContext*.xml" })
public abstract class BaseDaoTestCase extends
  AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  private SessionFactory sessionFactory;

  /**
   * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from
   * Commons Logging
   */
  protected final Log log = LogFactory.getLog(getClass());
  /**
   * ResourceBundle loaded from
   * src/test/resources/${package.name}/ClassName.properties (if exists)
   */
  protected ResourceBundle rb;

  /**
   * Default constructor - populates "rb" variable if properties file exists for
   * the class in src/test/resources.
   */
  public BaseDaoTestCase() {
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
   * Create a HibernateTemplate from the SessionFactory and call flush() and
   * clear() on it. Designed to be used after "save" methods in tests:
   * http://issues.appfuse.org/browse/APF-178.
   * 
   * @throws org.springframework.beans.BeansException
   *           when can't find 'sessionFactory' bean
   */
  protected void flush() throws BeansException {
    final HibernateTemplate hibernateTemplate =
      new HibernateTemplate(sessionFactory);
    hibernateTemplate.flush();
    hibernateTemplate.clear();
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
  protected Object populate(final Object obj) throws Exception {
    // loop through all the beans methods and set its properties from its
    // .properties file
    final Map<String, String> map = new HashMap<String, String>();

    for (final Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
      final String key = keys.nextElement();
      map.put(key, rb.getString(key));
    }

    BeanUtils.copyProperties(obj, map);

    return obj;
  }
}