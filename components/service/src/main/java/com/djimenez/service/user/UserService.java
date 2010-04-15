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
  int addUser(User user);

  /**
   * @return
   */
  int getUserNumber();

  /**
   * @param id
   * @return
   */
  User retrieveUser(int id);

}
