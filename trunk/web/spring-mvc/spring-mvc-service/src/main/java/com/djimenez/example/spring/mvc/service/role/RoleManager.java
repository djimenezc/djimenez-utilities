package com.djimenez.example.spring.mvc.service.role;

import java.util.List;

import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.service.GenericManager;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface RoleManager extends GenericManager<Role, Long> {

  /**
   * {@inheritDoc}
   */
  Role getRole(String rolename);

  /**
   * {@inheritDoc}
   */
  List<Role> getRoles(Role role);

  /**
   * {@inheritDoc}
   */
  void removeRole(String rolename);

  /**
   * {@inheritDoc}
   */
  Role saveRole(Role role);
}
