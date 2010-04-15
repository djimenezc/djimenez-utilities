package com.djimenez.service.user;

import com.djimenez.model.user.User;
import com.djimenez.persistence.dao.user.UserDao;

public class UserServiceImpl implements UserService {

  private UserDao userDao;

  @Override
  public final int addUser(final User user) {

    userDao.save(user);

    return 1;
  }

  @Override
  public final int getUserNumber() {

    return userDao.calculateUserNumber();

  }

  @Override
  public final User retrieveUser(final int id) {

    return userDao.get(Long.valueOf(id));
  }

  /**
   * @param userDao
   *          the springTestDao to set
   */
  public final void setUserDao(final UserDao userDao) {

    this.userDao = userDao;
  }

}
