package com.djimenez.example.spring.mvc.persistence.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.ExpectedException;

import com.djimenez.example.spring.mvc.model.Address;
import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.persistence.dao.user.UserDao;

public class UserDaoNonTransactionalTest extends
  BaseDaoNonTransactionalTestCase {

  @Autowired
  private UserDao dao;

  @Test
  @ExpectedException(DataIntegrityViolationException.class)
  public final void testUpdateUser() throws Exception {

    User user = dao.get(-1L);

    final Address address = user.getAddress();
    address.setAddress("new address");

    dao.saveUser(user);
    // flush();

    user = dao.get(-1L);
    assertEquals(address, user.getAddress());
    assertEquals("new address", user.getAddress().getAddress());

    // verify that violation occurs when adding new user with same username
    user.setId(null);

    // should throw DataIntegrityViolationException
    dao.saveUser(user);

  }
}
