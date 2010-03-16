package com.djimenez.test.example.spring.injection;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.test.spring.service.SpringTestService;
import com.djimenez.testing.spring.AbstractSpringTest;

@ContextConfiguration(locations = { "classpath:spring/test-springExample.xml" })
public class SpringExampleTest extends AbstractSpringTest {

  @Autowired
  private SpringTestService springTestService;

  @Test
  void testSpringExample() throws ConfigurationException {

    final User user =
      SpringExampleTestConfiguration.getInstance().retrieveSpringTestData();

    springTestService.addUser(user);

  }

}
