package com.djimenez.test.factory.mock;

import com.djimenez.test.spring.dao.SpringTestDao;

public interface FactoryTestMock {

  public abstract SpringTestDao getMockSpringTestDao();

}