package com.djimenez.test.spring.service;

import com.djimenez.model.user.User;

/**
 * @author djimenez
 */
public interface SpringTestService {

  /**
   * @param user
   * @return
   */
  public int addUser(User user);

  /**
   * @return
   */
  public int getUserNumber();

  /**
   * @param id
   * @return
   */
  public User retrieveUser(int id);

}
