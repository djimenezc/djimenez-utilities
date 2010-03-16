package com.djimenez.test.example.util;

import org.apache.commons.configuration.HierarchicalConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.testing.configuration.parser.ParserConfigurations;

public class ParserUtilTestExample {

  private static ParserConfigurations parserConfigurations =
    ParserConfigurations.getInstance();

  private static ParserUtilTestExample instance;

  public static ParserUtilTestExample getInstance() {

    if (instance == null) {

      instance = new ParserUtilTestExample();
    }

    return instance;
  }

  private ParserUtilTestExample() {

  }

  /**
   * Method recovery and setter the values of HierarchicalConfiguration
   */
  public User buildUser(final HierarchicalConfiguration node) {

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

}
