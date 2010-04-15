package com.djimenez.test.example.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.djimenez.model.user.User;
import com.djimenez.test.AbstractTestCase;

/**
 * Test that use a Configuration test class to retrieve a dummy information
 * 
 * @author djimenez
 */

public class ConfigurationServiceTest extends AbstractTestCase {

  @BeforeClass
  public static void setUpGeneral() throws ConfigurationException {

  }

  @AfterClass
  public static void tearDownGeneral() {

  }

  @Test
  public void testRetrieveObjectConfiguration() throws Exception {

    final User userCompare =
      ConfigurationServiceTestConfiguration.getInstance().buildTestUser();

    org.junit.Assert.assertEquals(
      "User retrievement from the xml has been incorrected", userCompare,
      ConfigurationServiceTestConfiguration.getInstance().retrieveUserData());

  }
}
