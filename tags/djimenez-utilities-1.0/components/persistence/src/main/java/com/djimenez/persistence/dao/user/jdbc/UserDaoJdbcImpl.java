package com.djimenez.persistence.dao.user.jdbc;

import java.util.List;
import java.util.Map;

import com.djimenez.model.user.User;
import com.djimenez.persistence.core.jdbc.AbstractPersistenceTemplate;
import com.djimenez.persistence.dao.user.UserDao;

public class UserDaoJdbcImpl extends AbstractPersistenceTemplate implements
  UserDao {

  @Override
  public final int calculateUserNumber() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public final boolean exists(final Long id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public final List<User> findByNamedQuery(final String queryName,
    final Map<String, Object> queryParams) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public final User get(final Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public final List<User> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public final List<User> getAllDistinct() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public final String getUserPassword(final String username) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public final List<User> getUsers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public final User loadUserByUsername(final String username) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void remove(final Long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public final User save(final User user) {

    final String sql = "insert into items (description, name) values (?, ?)";

    this.update(sql, user.getName());

    return user;
  }

}