package com.djimenez.example.spring.mvc.service.test.integration;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;

import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.service.user.UserExistsException;
import com.djimenez.example.spring.mvc.service.user.UserManager;

public class UserExistsExceptionTest extends BaseManagerIntegrationTestCase {

  @Autowired
  private UserManager manager;

  private final Log log = LogFactory.getLog(UserExistsExceptionTest.class);

  @Test
  @ExpectedException(UserExistsException.class)
  public final void testAddExistingUser() throws Exception {

    log.debug("entered 'testAddExistingUser' method");
    assertNotNull(manager);

    final User user = manager.getUser("-1");

    // create new object with null id - Hibernate doesn't like setId(null)
    final User user2 = new User();
    BeanUtils.copyProperties(user, user2);
    user2.setId(null);
    user2.setVersion(null);
    user2.setRoles(null);

    // try saving as new user, this should fail UserExistsException b/c of
    // unique keys
    manager.saveUser(user2);
  }
}
