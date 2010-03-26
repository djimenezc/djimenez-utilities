package com.djimenez.test.spring;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * Basic test Context Environment
 * 
 * @author a.vergara.andres
 */
public abstract class AbstractSpringTest extends
  AbstractDependencyInjectionSpringContextTests {

  public static final Logger logger =
    Logger.getLogger(AbstractSpringTest.class);

}
