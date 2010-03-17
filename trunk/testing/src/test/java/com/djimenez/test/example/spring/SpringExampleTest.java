package com.djimenez.test.example.spring;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djimenez.model.user.User;
import com.djimenez.test.spring.service.SpringTestService;
import com.djimenez.testing.spring.AbstractSpringTest;

public class SpringExampleTest extends AbstractSpringTest {

  @Autowired
  private SpringTestService springTestService;

  @Override
  protected String[] getConfigLocations() {
    return new String[] { "/spring/test-springExample-applicationContext.xml" };
  }

  @Test
  public void testSpringExample() throws ConfigurationException {

    final User user =
      SpringExampleTestConfiguration.getInstance().retrieveSpringTestData();

    springTestService.addUser(user);

  }

}
