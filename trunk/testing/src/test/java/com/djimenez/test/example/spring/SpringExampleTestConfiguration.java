package com.djimenez.test.example.spring;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.test.example.util.ParserUtilTestExample;
import com.djimenez.testing.configuration.retrieve.RetrieveConfiguration;

/**
 * Class that retrieve a dummy information
 * 
 * @author djimenez
 */
public final class SpringExampleTestConfiguration {

  private static final String TEST_NAME = "springTest";

  private static final String CONFIGURATION_TEST_XML =
    "configuration/springTest.xml";

  private static SpringExampleTestConfiguration instance;

  public static SpringExampleTestConfiguration getInstance() {

    if (instance == null) {

      instance = new SpringExampleTestConfiguration();
    }

    return instance;
  }

  private SpringExampleTestConfiguration() {

  }

  /**
   * Method recovery the initial values of node xml for the sale counter
   */
  public User retrieveSpringTestData() throws ConfigurationException {

    final HierarchicalConfiguration node =
      RetrieveConfiguration.getTestCaseHierarchicalConfiguration(
        CONFIGURATION_TEST_XML, TEST_NAME);

    return ParserUtilTestExample.getInstance().buildUser(node);

  }
}
