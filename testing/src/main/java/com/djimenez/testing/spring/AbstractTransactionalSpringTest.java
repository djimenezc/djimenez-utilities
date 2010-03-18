package com.djimenez.testing.spring;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Basic test Context Environment
 * 
 * @author a.vergara.andres
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/database/dataBase-jdbc-config-test.xml" })
@Transactional
public abstract class AbstractTransactionalSpringTest {

  protected static final Logger logger =
    Logger.getLogger(AbstractTransactionalSpringTest.class);

}
