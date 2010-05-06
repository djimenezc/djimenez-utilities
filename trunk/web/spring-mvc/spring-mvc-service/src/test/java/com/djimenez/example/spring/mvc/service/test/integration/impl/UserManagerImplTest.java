package com.djimenez.example.spring.mvc.service.test.integration.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.persistence.dao.role.RoleDao;
import com.djimenez.example.spring.mvc.persistence.dao.user.UserDao;
import com.djimenez.example.spring.mvc.service.role.impl.RoleManagerImpl;
import com.djimenez.example.spring.mvc.service.user.UserExistsException;
import com.djimenez.example.spring.mvc.service.user.impl.UserManagerImpl;

public class UserManagerImplTest extends BaseManagerMockTestCase {

  // ~ Instance fields ========================================================
  private final UserManagerImpl userManager = new UserManagerImpl();
  private RoleManagerImpl roleManager;
  private UserDao userDao;
  private RoleDao roleDao;

  // ~ Methods ================================================================
  @Before
  public void setUp() throws Exception {
    userDao = context.mock(UserDao.class);
    userManager.setUserDao(userDao);
    roleDao = context.mock(RoleDao.class);
    roleManager = new RoleManagerImpl(roleDao);
  }

  @Test
  public void testAddAndRemoveUser() throws Exception {
    User user = new User();

    // call populate method in super class to populate test data
    // from a properties file matching this class name
    user = (User) populate(user);

    // set expected behavior on role dao
    context.checking(new Expectations() {

      {
        one(roleDao).getRoleByName(with(equal("ROLE_USER")));
        will(returnValue(new Role("ROLE_USER")));
      }
    });

    final Role role = roleManager.getRole(ConstantsRole.USER_ROLE);
    user.addRole(role);

    // set expected behavior on user dao
    final User user1 = user;
    context.checking(new Expectations() {

      {
        one(userDao).saveUser(with(same(user1)));
        will(returnValue(user1));
      }
    });

    user = userManager.saveUser(user);
    assertTrue(user.getUsername().equals("john"));
    assertTrue(user.getRoles().size() == 1);

    context.checking(new Expectations() {

      {
        one(userDao).remove(with(equal(5L)));
      }
    });

    userManager.removeUser("5");

    context.checking(new Expectations() {

      {
        one(userDao).get(with(equal(5L)));
        will(returnValue(null));
      }
    });

    user = userManager.getUser("5");
    assertNull(user);
  }

  @Test
  public void testGetUser() throws Exception {
    final User testData = new User("1");
    testData.getRoles().add(new Role("user"));

    // set expected behavior on dao
    context.checking(new Expectations() {

      {
        one(userDao).get(with(equal(1L)));
        will(returnValue(testData));
      }
    });

    final User user = userManager.getUser("1");
    assertTrue(user != null);
    assert user != null;
    assertTrue(user.getRoles().size() == 1);
  }

  @Test
  public void testSaveUser() throws Exception {
    final User testData = new User("1");
    testData.getRoles().add(new Role("user"));

    // set expected behavior on dao
    context.checking(new Expectations() {

      {
        one(userDao).get(with(equal(1L)));
        will(returnValue(testData));
      }
    });

    final User user = userManager.getUser("1");
    user.setPhoneNumber("303-555-1212");

    context.checking(new Expectations() {

      {
        one(userDao).saveUser(with(same(user)));
        will(returnValue(user));
      }
    });

    final User returned = userManager.saveUser(user);
    assertTrue(returned.getPhoneNumber().equals("303-555-1212"));
    assertTrue(returned.getRoles().size() == 1);
  }

  @Test
  public void testUserExistsException() {
    // set expectations
    final User user = new User("admin");
    user.setEmail("matt@raibledesigns.com");

    final Exception ex = new DataIntegrityViolationException("");

    context.checking(new Expectations() {

      {
        one(userDao).saveUser(with(same(user)));
        will(throwException(ex));
      }
    });

    // run test
    try {
      userManager.saveUser(user);
      fail("Expected UserExistsException not thrown");
    }
    catch (final UserExistsException e) {
      log.debug("expected exception: " + e.getMessage());
      assertNotNull(e);
    }
  }
}
