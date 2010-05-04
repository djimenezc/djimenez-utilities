package com.djimenez.example.spring.mvc.service.test.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.model.LabelValue;
import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.LookupDao;
import com.djimenez.example.spring.mvc.service.role.impl.LookupRoleManagerImpl;

public class LookupManagerImplTest extends BaseManagerMockTestCase {

  private final LookupRoleManagerImpl mgr = new LookupRoleManagerImpl();
  private LookupDao lookupDao;

  @Before
  public void setUp() throws Exception {
    lookupDao = context.mock(LookupDao.class);
    mgr.setDao(lookupDao);
  }

  @Test
  public void testGetAllRoles() {
    log.debug("entered 'testGetAllRoles' method");

    // set expected behavior on dao
    final Role role = new Role(ConstantsRole.ADMIN_ROLE);
    final List<Role> testData = new ArrayList<Role>();
    testData.add(role);

    context.checking(new Expectations() {

      {
        one(lookupDao).getRoles();
        will(returnValue(testData));
      }
    });

    final List<LabelValue> roles = mgr.getAllRoles();
    assertTrue(roles.size() > 0);
  }
}
