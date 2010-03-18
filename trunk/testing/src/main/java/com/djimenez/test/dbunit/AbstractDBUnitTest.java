package com.djimenez.test.dbunit;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.carbonfive.testutils.spring.dbunit.AbstractTransactionalDataSetTestCase;

/**
 * Abstract class to implements tests with DBUnit. Easy to use DBUnit rollBack
 * and execute database operations.
 * 
 * @author djimenez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:dataBase-tx-config.xml" })
@Transactional
public abstract class AbstractDBUnitTest extends
  AbstractTransactionalDataSetTestCase {

  // Logger
  protected static final Logger logger =
    Logger.getLogger(AbstractDBUnitTest.class);

}
