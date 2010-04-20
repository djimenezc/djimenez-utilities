package com.djimenez.test.spring.dao;

import com.djimenez.core.patterns.interfaces.dao.GenericDao;
import com.djimenez.model.user.User;

public interface SpringTestDao extends GenericDao<Integer, User> {

  void calculateUserNumber();

}
