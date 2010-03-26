package com.djimenez.test.example.spring.transactional;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.test.example.spring.SpringExampleTestConfiguration;
import com.djimenez.test.spring.AbstractTransactionalSpringTest;
import com.djimenez.test.spring.service.SpringTestService;

@ContextConfiguration(locations = { "classpath:spring/test-transactional-applicationContext.xml" })
public class TransactionalExampleTest extends AbstractTransactionalSpringTest {

  @Autowired
  private SpringTestService springTestService;

  @Test
  public void testTransactionalExample() throws ConfigurationException {

    final User user =
      SpringExampleTestConfiguration.getInstance().retrieveSpringTestData();

    springTestService.addUser(user);

  }
}
