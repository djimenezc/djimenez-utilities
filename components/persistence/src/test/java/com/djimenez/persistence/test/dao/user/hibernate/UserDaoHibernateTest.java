package com.djimenez.persistence.test.dao.user.hibernate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;

import com.djimenez.persistence.dao.UserDao;
import com.djimenez.persistence.test.dao.user.UserDaoTest;
import com.djimenez.test.dao.BaseDaoTestCase;

@ContextConfiguration(locations = { "classpath:/context/persistence/applicationContext-hibernate-dao.xml" })
public class UserDaoHibernateTest extends BaseDaoTestCase implements
  UserDaoTest {

  @Autowired
  private UserDao userDao;

  @Test
  @Override
  public void testCalculateUserNumber() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testExists() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testFindByNamedQuery() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testGet() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testGetAll() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testGetAllDistinct() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testGetUserPassword() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testGetUsers() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testLoadUserByUsername() throws UsernameNotFoundException {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testRemove() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testRemoveNonExistent() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testSave() {
    // TODO Auto-generated method stub

  }

  @Test
  @Override
  public void testSaveRepetead() {
    // TODO Auto-generated method stub

  }

}
