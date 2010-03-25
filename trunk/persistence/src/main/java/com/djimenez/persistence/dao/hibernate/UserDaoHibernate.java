package com.djimenez.persistence.dao.hibernate;

import java.util.List;

import javax.persistence.Table;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.djimenez.model.user.User;
import com.djimenez.persistence.core.orm.hibernate.GenericDaoHibernate;
import com.djimenez.persistence.dao.UserDao;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve User objects.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler</a> Extended to
 *         implement Acegi UserDetailsService interface by David Carter
 *         david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan
 *         Noll</a> to work with the new BaseDaoHibernate implementation that
 *         uses generics.
 */
@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements
  UserDao {

  /**
   * Constructor that sets the entity to User.class.
   */
  public UserDaoHibernate() {
    super(User.class);
  }

  /**
   * {@inheritDoc}
   */
  public String getUserPassword(final String username) {
    final SimpleJdbcTemplate jdbcTemplate =
      new SimpleJdbcTemplate(SessionFactoryUtils
        .getDataSource(getSessionFactory()));
    final Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
    return jdbcTemplate.queryForObject("select password from " + table.name()
      + " where username=?", String.class, username);

  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<User> getUsers() {
    return getHibernateTemplate()
      .find("from User u order by upper(u.username)");
  }

  /**
   * {@inheritDoc}
   */
  public User loadUserByUsername(final String username)
    throws UsernameNotFoundException {

    @SuppressWarnings("unchecked")
    final List<User> users =
      getHibernateTemplate().find("from User where username=?", username);

    if ((users == null) || users.isEmpty()) {
      throw new UsernameNotFoundException("user '" + username
        + "' not found...");
    }
    else {
      return users.get(0);
    }
  }

  /**
   * Overridden simply to call the saveUser method. This is happenening because
   * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
   * 
   * @param user
   *          the user to save
   * @return the modified user (with a primary key set if they're new)
   */
  @Override
  public User save(final User user) {
    return this.saveUser(user);
  }

  /**
   * {@inheritDoc}
   */
  public User saveUser(final User user) {
    if (log.isDebugEnabled()) {
      log.debug("user's id: " + user.getId());
    }
    getHibernateTemplate().saveOrUpdate(user);
    // necessary to throw a DataIntegrityViolation and catch it in UserManager
    getHibernateTemplate().flush();
    return user;
  }

}
