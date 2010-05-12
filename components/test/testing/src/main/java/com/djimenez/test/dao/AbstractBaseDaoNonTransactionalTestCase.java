package com.djimenez.test.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.djimenez.test.AbstractTestCase;

/**
 * Base class for running DAO tests.
 * 
 * @author djimenez
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractBaseDaoNonTransactionalTestCase extends
  AbstractTestCase {

  /**
   * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from
   * Commons Logging
   */
  // private static final Log LOG =
  // LogFactory.getLog(AbstractBaseDaoNonTransactionalTestCase.class);
}
