package com.djimenez.service.user;

import com.djimenez.model.user.User;

/**
 * @author djimenez
 */
public interface UserService {

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
