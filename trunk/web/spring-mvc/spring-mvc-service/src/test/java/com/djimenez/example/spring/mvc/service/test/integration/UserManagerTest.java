package com.djimenez.example.spring.mvc.service.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.service.role.RoleManager;
import com.djimenez.example.spring.mvc.service.user.UserManager;

public class UserManagerTest extends BaseManagerIntegrationTestCase {

  private static final Log LOG = LogFactory.getLog(UserManagerTest.class);

  @Autowired
  private UserManager mgr;

  @Autowired
  private RoleManager roleManager;
  private User user;

  @Test
  public final void testAddAndRemoveUser() throws Exception {

    user = new User();

    // call populate method in super class to populate test data
    // from a properties file matching this class name
    user = (User) populate(user);

    user.addRole(roleManager.getRole(ConstantsRole.USER_ROLE));

    user = mgr.saveUser(user);
    assertEquals("john", user.getUsername());
    assertEquals(1, user.getRoles().size());

    LOG.debug("removing user...");

    mgr.removeUser(user.getId().toString());

    try {
      user = mgr.getUserByUsername("john");
      fail("Expected 'Exception' not thrown");
    }
    catch (final Exception e) {
      LOG.debug(e);
      assertNotNull(e);
    }
  }

  @Test
  public final void testGetUser() throws Exception {
    user = mgr.getUserByUsername("user");
    assertNotNull(user);

    LOG.debug(user);
    assertEquals(1, user.getRoles().size());
  }

  @Test
  public final void testSaveUser() throws Exception {
    user = mgr.getUserByUsername("user");
    user.setPhoneNumber("303-555-1212");

    LOG.debug("saving user with updated phone number: " + user);

    user = mgr.saveUser(user);
    assertEquals("303-555-1212", user.getPhoneNumber());
    assertEquals(1, user.getRoles().size());
  }
}
