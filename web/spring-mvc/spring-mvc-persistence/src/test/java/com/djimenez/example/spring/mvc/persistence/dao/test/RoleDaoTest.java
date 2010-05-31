package com.djimenez.example.spring.mvc.persistence.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.role.RoleDao;

public class RoleDaoTest extends BaseDaoTestCase {

  private static final String TESTROLE = "testrole";
  @Autowired
  private RoleDao dao;

  @Test
  public final void testAddAndRemoveRole() throws Exception {
    Role role = new Role(TESTROLE);
    role.setDescription("new role descr");
    dao.save(role);
    flush();

    role = dao.getRoleByName(TESTROLE);
    assertNotNull(role.getDescription());

    dao.removeRole(TESTROLE);
    flush();

    role = dao.getRoleByName(TESTROLE);
    assertNull(role);
  }

  @Test
  public final void testFindByNamedQuery() {
    final HashMap<String, Object> queryParams = new HashMap<String, Object>();
    queryParams.put("name", ConstantsRole.USER_ROLE);
    final List<Role> roles =
      dao.findByNamedQuery("findRoleByName", queryParams);
    assertNotNull(roles);
    assertTrue(roles.size() > 0);
  }

  @Test
  public final void testGetRole() throws Exception {
    final Role role = dao.getRoleByName(ConstantsRole.USER_ROLE);
    assertNotNull(role);
  }

  @Test
  public final void testGetRoleInvalid() throws Exception {
    final Role role = dao.getRoleByName("badrolename");
    assertNull(role);
  }

  @Test
  public final void testUpdateRole() throws Exception {
    Role role = dao.getRoleByName("ROLE_USER");
    role.setDescription("test descr");
    dao.save(role);
    flush();

    role = dao.getRoleByName("ROLE_USER");
    assertEquals("test descr", role.getDescription());
  }
}