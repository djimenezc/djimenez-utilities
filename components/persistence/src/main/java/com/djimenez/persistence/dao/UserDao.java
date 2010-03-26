package com.djimenez.persistence.dao;

import java.util.List;

import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.djimenez.core.patterns.interfaces.dao.GenericDaoExtend;
import com.djimenez.model.user.User;

/**
 * User Data Access Object (GenericDao) interface.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface UserDao extends GenericDaoExtend<User, Long> {

  /**
   * Retrieves the password in DB for a user
   * 
   * @param username
   *          the user's username
   * @return the password in DB, if the user is already persisted
   */
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  String getUserPassword(String username);

  /**
   * Gets a list of users ordered by the uppercase version of their username.
   * 
   * @return List populated list of users
   */
  List<User> getUsers();

  /**
   * Gets users information based on login name.
   * 
   * @param username
   *          the user's username
   * @return userDetails populated userDetails object
   * @throws org.springframework.security.userdetails.UsernameNotFoundException
   *           thrown when user not found in database
   */
  @Transactional
  User loadUserByUsername(String username) throws UsernameNotFoundException;

}
