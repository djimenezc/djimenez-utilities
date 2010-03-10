package com.djimenez.test.example.configuration;

import java.util.Date;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.testing.configuration.parser.ParserConfigurations;
import com.djimenez.testing.configuration.retrieve.RetrieveConfiguration;

/**
 * Class that retrieve a dummy information
 * 
 * @author djimenez
 */
public final class ConfigurationServiceTestConfiguration {

  private static final String TEST_CASE = "testCase";

  private static final String CONFIGURATION_SERVICE_TEST_XML =
    "configuration/configurationServiceTest.xml";

  private static ParserConfigurations parserConfigurations =
    ParserConfigurations.getInstance();

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

    userCompare.isActive(true);
    userCompare.setAddress("C/Castellana 21");
    userCompare.setBornDate(new Date(412642800000L));
    userCompare.setActiveDate(new Date(1254434400000L));
    userCompare.setEmail("djimenezcalvo@gmail.com");
    userCompare.setFirstSurname("jimenez");
    userCompare.setId(1);
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
   * Method recovery and setter the values of HierarchicalConfiguration
   */
  private User buildUser(final HierarchicalConfiguration node) {

    final User user = new User();

    user.isActive(parserConfigurations.getBoolean(node, "active"));
    user.setAddress(parserConfigurations.getString(node, "address"));
    user.setBornDate(parserConfigurations.getDate(node, "bornDate"));
    user.setActiveDate(parserConfigurations.getDate(node, "activeDate"));
    user.setEmail(parserConfigurations.getString(node, "email"));
    user.setFirstSurname(parserConfigurations.getString(node, "firstSurname"));
    user.setId(parserConfigurations.getInteger(node, "id"));
    user.setNacionality(parserConfigurations.getString(node, "nacionality"));
    user.setName(parserConfigurations.getString(node, "name"));
    user.setNif(parserConfigurations.getString(node, "nif"));
    user.setPassword(parserConfigurations.getString(node, "password"));
    user.setPostalCode(parserConfigurations.getString(node, "postalCode"));
    user
      .setSecondSurname(parserConfigurations.getString(node, "secondSurname"));
    user.setUserName(parserConfigurations.getString(node, "userName"));

    return user;
  }

  /**
   * Method recovery the initial values of node xml for the sale counter
   */
  public User retrieveUserData() throws ConfigurationException {

    final HierarchicalConfiguration node =
      RetrieveConfiguration.getTestCaseHierarchicalConfiguration(
        CONFIGURATION_SERVICE_TEST_XML, TEST_CASE).configurationAt("user");

    return buildUser(node);

  }
}
