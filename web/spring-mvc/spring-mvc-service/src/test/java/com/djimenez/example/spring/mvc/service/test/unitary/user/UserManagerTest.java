package com.djimenez.example.spring.mvc.service.test.unitary.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.service.role.RoleManager;
import com.djimenez.example.spring.mvc.service.test.unitary.BaseManagerTestCase;
import com.djimenez.example.spring.mvc.service.user.UserManager;

public class UserManagerTest extends BaseManagerTestCase {

  private final Log log = LogFactory.getLog(UserManagerTest.class);

  @Autowired
  private UserManager mgr;

  @Autowired
  private RoleManager roleManager;
  private User user;

  @Test
  public void testAddUser() throws Exception {

    user = new User();

    // call populate method in super class to populate test data
    // from a properties file matching this class name
    user = (User) populate(user);

    user.addRole(roleManager.getRole(ConstantsRole.USER_ROLE));

    user = mgr.saveUser(user);
    assertEquals("john", user.getUsername());
    assertEquals(1, user.getRoles().size());
  }

  @Test
  public void testGetUser() throws Exception {

    user = mgr.getUserByUsername("user");
    assertNotNull(user);

    log.debug(user);
    assertEquals(1, user.getRoles().size());
  }

}
