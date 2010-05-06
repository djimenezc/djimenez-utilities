package com.djimenez.example.spring.mvc.service.user.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.persistence.dao.user.UserDao;
import com.djimenez.example.spring.mvc.service.GenericManagerImpl;
import com.djimenez.example.spring.mvc.service.user.UserExistsException;
import com.djimenez.example.spring.mvc.service.user.UserManager;
import com.djimenez.example.spring.mvc.service.web.user.UserService;

/**
 * Implementation of UserManager interface.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("userManager")
@WebService(serviceName = "UserService", endpointInterface = "com.gowex.service.UserService")
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements
  UserManager, UserService {

  private static final Log LOG = LogFactory.getLog(UserManagerImpl.class);

  private PasswordEncoder passwordEncoder;
  private UserDao userDao;

  /**
   * {@inheritDoc}
   */
  public final User getUser(final String userId) {

    return userDao.get(Long.valueOf(userId));
  }

  /**
   * {@inheritDoc}
   * 
   * @param username
   *          the login name of the human
   * @return User the populated user object
   * @throws UsernameNotFoundException
   *           thrown when username not found
   */
  public final User getUserByUsername(final String username)
    throws UsernameNotFoundException {

    return (User) userDao.loadUserByUsername(username);
  }

  /**
   * {@inheritDoc}
   */
  public final List<User> getUsers() {
    return userDao.getAllDistinct();
  }

  /**
   * {@inheritDoc}
   */
  public final void removeUser(final String userId) {
    LOG.debug("removing user: " + userId);
    userDao.remove(new Long(userId));
  }

  /**
   * {@inheritDoc}
   */
  public User saveUser(final User user) throws UserExistsException {

    if (user.getVersion() == null) {
      // if new user, lowercase userId
      user.setUsername(user.getUsername().toLowerCase());
    }

    // Get and prepare password management-related artifacts
    boolean passwordChanged = false;
    if (passwordEncoder != null) {
      // Check whether we have to encrypt (or re-encrypt) the password
      if (user.getVersion() == null) {
        // New user, always encrypt
        passwordChanged = true;
      }
      else {
        // Existing user, check password in DB
        final String currentPassword =
          userDao.getUserPassword(user.getUsername());
        if (currentPassword == null) {
          passwordChanged = true;
        }
        else {
          if (!currentPassword.equals(user.getPassword())) {
            passwordChanged = true;
          }
        }
      }

      // If password was changed (or new user), encrypt it
      if (passwordChanged) {
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(),
          null));
      }
    }
    else {
      LOG.warn("PasswordEncoder not set, skipping password encryption...");
    }

    try {
      return userDao.saveUser(user);
    }
    catch (final DataIntegrityViolationException e) {
      // e.printStackTrace();
      LOG.warn(e.getMessage());
      throw new UserExistsException("User '" + user.getUsername()
        + "' already exists!");
    }
    catch (final JpaSystemException e) { // needed for JPA
      // e.printStackTrace();
      LOG.warn(e.getMessage());
      throw new UserExistsException("User '" + user.getUsername()
        + "' already exists!");
    }

  }

  @Autowired
  public final void setPasswordEncoder(final PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Autowired
  public final void setUserDao(final UserDao userDao) {
    this.setDao(userDao);
    this.userDao = userDao;
  }
}
