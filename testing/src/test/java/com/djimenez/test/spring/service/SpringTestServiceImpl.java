package com.djimenez.test.spring.service;

import com.djimenez.model.user.User;
import com.djimenez.test.spring.dao.SpringTestDao;

public class SpringTestServiceImpl implements SpringTestService {

  private SpringTestDao springTestDao;

  @Override
  public int addUser(final User user) {
    // TODO Auto-generated method stub
    return 0;
  }

  /**
   * @return the springTestDao
   */
  public SpringTestDao getSpringTestDao() {
    return springTestDao;
  }

  @Override
  public int getUserNumber() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public User retrieveUser(final int id) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @param springTestDao
   *          the springTestDao to set
   */
  public void setSpringTestDao(final SpringTestDao springTestDao) {
    this.springTestDao = springTestDao;
  }

}
