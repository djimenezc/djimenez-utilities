package com.djimenez.test.example.spring;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;

import com.djimenez.model.user.User;
import com.djimenez.test.spring.service.SpringTestService;
import com.djimenez.testing.spring.AbstractSpringTest;

public class SpringExampleTest extends AbstractSpringTest {

  private SpringTestService springTestService;

  @Override
  protected String[] getConfigLocations() {
    return new String[] { "/spring/test-springExample-applicationContext.xml" };
  }

  /**
   * @param springTestService
   *          the springTestService to set
   */
  public void setSpringTestService(final SpringTestService springTestService) {
    this.springTestService = springTestService;
  }

  @Test
  public void testSpringExample() throws ConfigurationException {

    final User user =
      SpringExampleTestConfiguration.getInstance().retrieveSpringTestData();

    springTestService.addUser(user);

  }

}
