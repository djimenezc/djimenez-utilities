package com.djimenez.test.spring.service;

import com.djimenez.model.user.User;
import com.djimenez.test.spring.dao.SpringTestDao;

public class SpringTestServiceImpl implements SpringTestService {

  private SpringTestDao springTestDao;

  @Override
  public int addUser(final User user) {

    springTestDao.save(user);

    return 1;
  }

  @Override
  public int getUserNumber() {

    springTestDao.calculateUserNumber();

    return 0;
  }

  @Override
  public User retrieveUser(final int id) {

    return springTestDao.findById(id);
  }

  /**
   * @param springTestDao
   *          the springTestDao to set
   */
  public void setSpringTestDao(final SpringTestDao springTestDao) {
    this.springTestDao = springTestDao;
  }

}
