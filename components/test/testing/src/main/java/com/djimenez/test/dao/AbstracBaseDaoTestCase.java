package com.djimenez.test.dao;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.djimenez.util.beans.BeanUtils;

/**
 * Base class for running DAO tests.
 * 
 * @author mraible
 */
public abstract class AbstracBaseDaoTestCase extends
  AbstractTransactionalJUnit4SpringContextTests implements IBaseDaoTestCase {

  protected ResourceBundle rb;

  protected final Log log = LogFactory.getLog(getClass());

  @Autowired
  private SessionFactory sessionFactory;

  /**
   * Create a HibernateTemplate from the SessionFactory and call flush() and
   * clear() on it. Designed to be used after "save" methods in tests:
   * http://issues.appfuse.org/browse/APF-178.
   */
  public void flush() {

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
  public Object populate(final Object obj) {

    return BeanUtils.populate(obj, rb);
  }

}
