package com.djimenez.example.spring.mvc.persistence.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.role.RoleDao;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Role objects.
 * 
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 */
@Repository
public class RoleDaoHibernate extends GenericDaoHibernate<Role, Long> implements
  RoleDao {

  /**
   * Constructor to create a Generics-based version using Role as the entity
   */
  public RoleDaoHibernate() {
    super(Role.class);
  }

  /**
   * {@inheritDoc}
   */
  public final Role getRoleByName(final String rolename) {

    @SuppressWarnings("unchecked")
    final List<Role> roles =
      getHibernateTemplate().find("from Role where name=?", rolename);

    if (roles.isEmpty()) {
      return null;
    }
    else {
      return roles.get(0);
    }
  }

  /**
   * {@inheritDoc}
   */
  public final void removeRole(final String rolename) {
    final Object role = getRoleByName(rolename);
    getHibernateTemplate().delete(role);
  }
}
