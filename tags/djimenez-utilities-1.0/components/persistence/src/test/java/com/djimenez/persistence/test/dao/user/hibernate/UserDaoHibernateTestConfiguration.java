package com.djimenez.persistence.test.dao.user.hibernate;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.test.configuration.retrieve.RetrieveConfiguration;
import com.djimenez.test.util.ParserUtilTestExample;

public final class UserDaoHibernateTestConfiguration {

  private static final String CONFIGURATION_USER_TEST_XML =
    "configuration/user/configurationUserDaoTest.xml";

  private static UserDaoHibernateTestConfiguration instance;

  public static UserDaoHibernateTestConfiguration getInstance() {

    if (instance == null) {

      instance = new UserDaoHibernateTestConfiguration();
    }

    return instance;
  }

  private UserDaoHibernateTestConfiguration() {

  }

  public User getUserTestGet() throws ConfigurationException {

    final HierarchicalConfiguration node =
      RetrieveConfiguration.getTestCaseHierarchicalConfiguration(
        CONFIGURATION_USER_TEST_XML, "getDefaultUser").configurationAt("user");

    return ParserUtilTestExample.getInstance().buildUser(node);
  }

}
