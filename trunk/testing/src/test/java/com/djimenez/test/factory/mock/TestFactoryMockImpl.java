package com.djimenez.test.factory.mock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.classextension.EasyMock.createMock;

import com.djimenez.test.example.configuration.ConfigurationServiceTestConfiguration;
import com.djimenez.test.spring.dao.SpringTestDao;

public class TestFactoryMockImpl implements TestFactoryMock {

  /*
   * (non-Javadoc)
   * @see com.djimenez.test.factory.mock.FactoryMockTest#getMockSpringTestDao()
   */
  public SpringTestDao getMockSpringTestDao() {

    final SpringTestDao springTestDao = createMock(SpringTestDao.class);

    expect(springTestDao.findById(1)).andReturn(
      ConfigurationServiceTestConfiguration.getInstance().buildTestUser())
      .anyTimes();

    // implement interface
    replay(springTestDao);

    return springTestDao;
  }
}
