package com.djimenez.test.example.configuration;

import java.util.Date;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.test.configuration.retrieve.RetrieveConfiguration;
import com.djimenez.test.example.util.ParserUtilTestExample;

/**
 * Class that retrieve a dummy information
 * 
 * @author djimenez
 */
public final class ConfigurationServiceTestConfiguration {

  private static final String TEST_CASE = "testCase";

  private static final String CONFIGURATION_SERVICE_TEST_XML =
    "configuration/configurationServiceTest.xml";

  private static ConfigurationServiceTestConfiguration instance;

  public static ConfigurationServiceTestConfiguration getInstance() {

    if (instance == null) {

      instance = new ConfigurationServiceTestConfiguration();
    }

    return instance;
  }

  private ConfigurationServiceTestConfiguration() {

  }

  public User buildTestUser() {

    final User userCompare = new User();

    userCompare.setActive(true);
    userCompare.setAddress("C/Castellana 21");
    userCompare.setBornDate(new Date(412642800000L));
    userCompare.setActiveDate(new Date(1254434400000L));
    userCompare.setEmail("djimenezcalvo@gmail.com");
    userCompare.setFirstSurname("jimenez");
    userCompare.setId(1L);
    userCompare.setNacionality("spanish");
    userCompare.setName("david");
    userCompare.setNif("12345");
    userCompare.setPassword("david");
    userCompare.setPostalCode("28529");
    userCompare.setSecondSurname("calvo");
    userCompare.setUserName("djimenez");

    return userCompare;

  }

  /**
   * Method recovery the initial values of node xml for the sale counter
   */
  public User retrieveUserData() throws ConfigurationException {

    final HierarchicalConfiguration node =
      RetrieveConfiguration.getTestCaseHierarchicalConfiguration(
        CONFIGURATION_SERVICE_TEST_XML, TEST_CASE).configurationAt("user");

    return ParserUtilTestExample.getInstance().buildUser(node);

  }
}
