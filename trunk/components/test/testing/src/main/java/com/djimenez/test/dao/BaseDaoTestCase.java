package com.djimenez.test.dao;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for running DAO tests.
 * 
 * @author mraible
 */
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public abstract class BaseDaoTestCase extends
  AbstractTransactionalJUnit4SpringContextTests {

  protected final Log log = LogFactory.getLog(getClass());
  protected ResourceBundle rb;

  @Autowired
  public SessionFactory sessionFactory;

  public BaseDaoTestCase() {
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
   * Create a HibernateTemplate from the SessionFactory and call flush() and
   * clear() on it. Designed to be used after "save" methods in tests:
   * http://issues.appfuse.org/browse/APF-178.
   */
  protected void flush() {

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
    // loop through all the beans methods and set its properties from
    // its .properties file
    final Map<String, String> map = new HashMap<String, String>();

    for (final Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
      final String key = keys.nextElement();
      map.put(key, rb.getString(key));
    }

    BeanUtils.copyProperties(map, obj);

    return obj;
  }

}
