package com.djimenez.example.spring.mvc.service.role.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djimenez.example.spring.mvc.model.LabelValue;
import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.LookupDao;
import com.djimenez.example.spring.mvc.service.role.LookupRoleManager;

/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("lookupManager")
public class LookupRoleManagerImpl implements LookupRoleManager {

  @Autowired
  private LookupDao dao;

  /**
   * {@inheritDoc}
   */
  public final List<LabelValue> getAllRoles() {
    final List<Role> roles = getDao().getRoles();
    final List<LabelValue> list = new ArrayList<LabelValue>();

    for (final Role role1 : roles) {
      list.add(new LabelValue(role1.getName(), role1.getName()));
    }

    return list;
  }

  /**
   * @return the dao
   */
  public final LookupDao getDao() {
    return dao;
  }

  /**
   * @param dao
   *          the dao to set
   */
  public final void setDao(final LookupDao dao) {
    this.dao = dao;
  }
}
