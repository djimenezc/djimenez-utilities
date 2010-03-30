package com.djimenez.persistence.dao.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.security.userdetails.UsernameNotFoundException;

import com.djimenez.model.user.User;
import com.djimenez.persistence.core.jdbc.AbstractPersistenceTemplate;
import com.djimenez.persistence.dao.UserDao;

public class UserDaoJdbcImpl extends AbstractPersistenceTemplate implements
  UserDao {

  @Override
  public int calculateUserNumber() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean exists(final Long id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<User> findByNamedQuery(final String queryName,
    final Map<String, Object> queryParams) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public User get(final Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<User> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<User> getAllDistinct() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getUserPassword(final String username) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<User> getUsers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public User loadUserByUsername(final String username)
    throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void remove(final Long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public User save(final User user) {

    final String sql = "insert into items (description, name) values (?, ?)";

    this.update(sql, user.getName());

    return user;
  }

}
