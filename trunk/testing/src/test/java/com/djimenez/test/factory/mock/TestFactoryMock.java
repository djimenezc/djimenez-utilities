package com.djimenez.test.factory.mock;

import com.djimenez.test.spring.dao.SpringTestDao;

public interface TestFactoryMock {

  public abstract SpringTestDao getMockSpringTestDao();

}