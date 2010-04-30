package com.djimenez.example.spring.mvc.persistence.dao.role;

import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.GenericDao;

/**
 * Role Data Access Object (DAO) interface.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RoleDao extends GenericDao<Role, Long> {

  /**
   * Gets role information based on rolename
   * 
   * @param rolename
   *          the rolename
   * @return populated role object
   */
  Role getRoleByName(String rolename);

  /**
   * Removes a role from the database by name
   * 
   * @param rolename
   *          the role's rolename
   */
  void removeRole(String rolename);
}
