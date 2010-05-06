package com.djimenez.persistence.test.dao.user.hibernate;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.djimenez.model.user.User;
import com.djimenez.persistence.dao.user.UserDao;
import com.djimenez.persistence.test.dao.user.UserDaoTest;
import com.djimenez.test.dao.AbstracBaseDaoTransactionalTestCase;

@ContextConfiguration(locations = {
  "classpath:/context/persistence/hibernate/applicationContext-hibernate-dao.xml",
  "classpath:/context/persistence/database/database-config.xml",
  "classpath:/context/persistence/properties/applicationContext-properties-dao-test.xml" })
public class UserDaoHibernateTest extends AbstracBaseDaoTransactionalTestCase
  implements UserDaoTest {

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
  public final void testGetUser() throws ConfigurationException {

    final User actualUser = userDao.get(Long.valueOf(1L));

    final User expectedUser =
      UserDaoHibernateTestConfiguration.getInstance().getUserTestGet();

    org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals(
      expectedUser, actualUser);
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
  public void testLoadUserByUsername() {
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
