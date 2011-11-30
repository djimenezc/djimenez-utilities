package com.djimenez.example.spring.mvc.persistence.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.persistence.dao.GenericDao;
import com.djimenez.example.spring.mvc.persistence.dao.hibernate.GenericDaoHibernate;

public class GenericDaoTest extends BaseDaoTestCase {

  private GenericDao<User, Long> genericDao;

  @Autowired
  private SessionFactory sessionFactory;

  @Test
  public final void getUser() {

    final User user = genericDao.get(-1L);
    assertNotNull(user);
    assertEquals("user", user.getUsername());
  }

  @Before
  public final void setUp() {

    genericDao =
      new GenericDaoHibernate<User, Long>(User.class, sessionFactory);
  }
}