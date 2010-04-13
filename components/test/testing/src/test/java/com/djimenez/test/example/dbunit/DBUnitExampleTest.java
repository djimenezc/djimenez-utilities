package com.djimenez.test.example.dbunit;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.carbonfive.testutils.spring.dbunit.DataSet;
import com.djimenez.model.user.User;
import com.djimenez.test.dbunit.AbstractDBUnitTest;
import com.djimenez.test.example.spring.SpringExampleTestConfiguration;
import com.djimenez.test.spring.service.SpringTestService;

@ContextConfiguration(locations = { "classpath:context/test-persistence-dbunit-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class DBUnitExampleTest extends AbstractDBUnitTest {

  @BeforeClass
  public static void generalTearDown() {

  }

  @Autowired
  private SpringTestService springTestService;

  @Test
  @DataSet(setupOperation = "CLEAN_INSERT", value = "classpath:/dbunit/dbunit.xml")
  public void testTransactionalExample() throws ConfigurationException {

    final User user =
      SpringExampleTestConfiguration.getInstance().retrieveSpringTestData();

    springTestService.addUser(user);

  }

}