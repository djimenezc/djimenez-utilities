package com.djimenez.test.spring;

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
@ContextConfiguration(locations = { "classpath:/context/database/database-test-config.xml" })
@Transactional
public abstract class AbstractTransactionalSpringTest {

  protected AbstractTransactionalSpringTest() {

    super();
  }
}
