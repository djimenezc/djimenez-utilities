package com.djimenez.example.spring.mvc.persistence.dao.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.LookupDao;
import com.djimenez.example.spring.mvc.persistence.dao.hibernate.GenericDaoHibernate;

/**
 * This class tests the current LookupDao implementation class
 * 
 * @author mraible
 */
public class LookupDaoTest extends BaseDaoTestCase {

  private static final Log LOG = LogFactory.getLog(GenericDaoHibernate.class);

  @Autowired
  private LookupDao lookupDao;

  @Test
  public final void testGetRoles() {

    final List<Role> roles = lookupDao.getRoles();

    LOG.debug(roles);
    assertTrue(roles.size() > 0);
  }
}
