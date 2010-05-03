package com.djimenez.example.spring.mvc.service.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.role.RoleDao;
import com.djimenez.example.spring.mvc.service.GenericManagerImpl;
import com.djimenez.example.spring.mvc.service.role.RoleManager;

/**
 * Implementation of RoleManager interface.
 * 
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("roleManager")
public class RoleManagerImpl extends GenericManagerImpl<Role, Long> implements
  RoleManager {

  private final RoleDao roleDao;

  @Autowired
  public RoleManagerImpl(final RoleDao roleDao) {
    super(roleDao);
    this.roleDao = roleDao;
  }

  /**
   * {@inheritDoc}
   */
  public final Role getRole(final String rolename) {
    return roleDao.getRoleByName(rolename);
  }

  /**
   * {@inheritDoc}
   */
  public final List<Role> getRoles(final Role role) {
    return getDao().getAll();
  }

  /**
   * {@inheritDoc}
   */
  public final void removeRole(final String rolename) {
    roleDao.removeRole(rolename);
  }

  /**
   * {@inheritDoc}
   */
  public Role saveRole(final Role role) {
    return getDao().save(role);
  }
}