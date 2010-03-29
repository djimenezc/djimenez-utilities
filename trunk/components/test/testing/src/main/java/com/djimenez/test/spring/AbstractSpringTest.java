package com.djimenez.test.spring;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Basic test Context Environment
 * 
 * @author a.vergara.andres
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractSpringTest {

  public static final Logger logger =
    Logger.getLogger(AbstractSpringTest.class);

}
