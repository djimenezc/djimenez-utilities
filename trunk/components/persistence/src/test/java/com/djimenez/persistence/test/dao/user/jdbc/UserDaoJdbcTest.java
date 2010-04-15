package com.djimenez.persistence.test.dao.user.jdbc;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.djimenez.test.dao.BaseDaoTestCase;

@ContextConfiguration(locations = {
  "classpath:/context/persistence/jdbc/applicationContext-jdbc-dao.xml",
  "classpath:/context/persistence/database/database-config.xml",
  "classpath:/context/persistence/properties/applicationContext-properties-dao-test.xml" })
public class UserDaoJdbcTest extends BaseDaoTestCase {

  // TODO implement UserDaoJdbcTest
  // @Autowired
  // private UserDao userDao;

  @Test
  public void testCalculateUserNumber() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testExists() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testFindByNamedQuery() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testGet() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testGetAll() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testGetAllDistinct() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testGetUserPassword() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testGetUsers() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testLoadUserByUsername() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testRemove() {
    // TODO Auto-generated method stub

  }

  @Test
  public void testRemoveNonExistent() {
    // TODO Auto-generated method stub

  }

  @Test
  public void testSave() {
    // TODO Auto-generated method stub
  }

  @Test
  public void testSaveRepetead() {
    // TODO Auto-generated method stub
  }
}
