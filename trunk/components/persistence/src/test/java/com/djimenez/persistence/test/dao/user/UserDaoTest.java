package com.djimenez.persistence.test.dao.user;

import org.junit.Test;
import org.springframework.security.userdetails.UsernameNotFoundException;

public interface UserDaoTest {

  public void testCalculateUserNumber();

  public void testExists();

  public void testFindByNamedQuery();

  public void testGet();

  public void testGetAll();

  public void testGetAllDistinct();

  public void testGetUserPassword();

  public void testGetUsers();

  public void testLoadUserByUsername() throws UsernameNotFoundException;

  public void testRemove();

  public void testRemoveNonExistent();

  public void testSave();

  public void testSaveRepetead();
}
