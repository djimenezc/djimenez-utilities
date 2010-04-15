package com.djimenez.test.dbunit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.carbonfive.testutils.spring.dbunit.AbstractTransactionalDataSetTestCase;

/**
 * Abstract class to implements tests with DBUnit. Easy to use DBUnit rollBack
 * and execute database operations.
 * 
 * @author djimenez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/context/database/database-test-config.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public abstract class AbstractDBUnitTestCase extends
  AbstractTransactionalDataSetTestCase {

  protected AbstractDBUnitTestCase() {

    super();
  }
}
