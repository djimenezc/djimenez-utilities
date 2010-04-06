package com.djimenez.persistence.test.dao.user;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.security.userdetails.UsernameNotFoundException;

public interface UserDaoTest {

  public void testCalculateUserNumber();

  public void testExists();

  public void testFindByNamedQuery();

  public void testGetAll();

  public void testGetAllDistinct();

  void testGetUser() throws ConfigurationException;

  public void testGetUserPassword();

  public void testGetUsers();

  public void testLoadUserByUsername() throws UsernameNotFoundException;

  public void testRemove();

  public void testRemoveNonExistent();

  public void testSave();

  public void testSaveRepetead();
}
