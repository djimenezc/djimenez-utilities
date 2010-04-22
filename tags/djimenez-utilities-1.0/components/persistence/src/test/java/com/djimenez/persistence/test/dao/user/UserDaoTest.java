package com.djimenez.persistence.test.dao.user;

import org.apache.commons.configuration.ConfigurationException;

public interface UserDaoTest {

  void testCalculateUserNumber();

  void testExists();

  void testFindByNamedQuery();

  void testGetAll();

  void testGetAllDistinct();

  void testGetUser() throws ConfigurationException;

  void testGetUserPassword();

  void testGetUsers();

  void testLoadUserByUsername();

  void testRemove();

  void testRemoveNonExistent();

  void testSave();

  void testSaveRepetead();
}
