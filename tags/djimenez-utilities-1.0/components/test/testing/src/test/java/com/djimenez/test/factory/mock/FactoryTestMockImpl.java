package com.djimenez.test.factory.mock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.classextension.EasyMock.createNiceMock;

import org.easymock.classextension.EasyMock;

import com.djimenez.model.user.User;
import com.djimenez.test.example.configuration.ConfigurationServiceTestConfiguration;
import com.djimenez.test.spring.dao.SpringTestDao;

public class FactoryTestMockImpl implements FactoryTestMock {

  /*
   * (non-Javadoc)
   * @see com.djimenez.test.factory.mock.FactoryMockTest#getMockSpringTestDao()
   */
  public SpringTestDao getMockSpringTestDao() {

    final SpringTestDao springTestDao = createNiceMock(SpringTestDao.class);

    expect(springTestDao.findById(1)).andReturn(
      ConfigurationServiceTestConfiguration.getInstance().buildTestUser())
      .anyTimes();

    springTestDao.save((User) EasyMock.anyObject());
    expectLastCall().anyTimes();

    // implement interface
    replay(springTestDao);

    return springTestDao;
  }
}
