package com.djimenez.example.spring.mvc.persistence.dao.test;

import org.springframework.test.context.ContextConfiguration;

import com.djimenez.test.dao.AbstracBaseDaoTransactionalTestCase;

/**
 * Base class for running DAO tests.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@ContextConfiguration(locations = {
  "classpath:context/applicationContext-test-resources.xml",
  "classpath:context/applicationContext-persistence.xml",
  "classpath:context/applicationContext-dao.xml" })
public abstract class BaseDaoTestCase extends
  AbstracBaseDaoTransactionalTestCase {

  /**
   * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from
   * Commons Logging
   */
  // private static final Log LOG = LogFactory.getLog(BaseDaoTestCase.class);

}
