package com.djimenez.example.spring.mvc.service.test.unitary.mock;

import java.util.ResourceBundle;

import javax.transaction.UserTransaction;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.model.User;
import com.djimenez.example.spring.mvc.persistence.dao.LookupDao;
import com.djimenez.example.spring.mvc.persistence.dao.role.RoleDao;
import com.djimenez.example.spring.mvc.persistence.dao.user.UserDao;
import com.djimenez.example.spring.mvc.service.test.unitary.mock.matchers.UserNameEqual;
import com.djimenez.util.beans.BeanUtils;

public class FactoryMock {

  @Factory
  public static Matcher<User> aUserNameEqual(final String name) {
    return new UserNameEqual(name);
  }

  private final Mockery context = new Mockery();
  private final UserDao userDao;
  private RoleDao roleDao;

  private LookupDao lookupDao;

  public FactoryMock() {

    final String name = "user";
    configureMockRoleDao(name);

    userDao = context.mock(UserDao.class);

    final User user = configureUserDaoGet(name);
    configureUserDaoSave(user, name);
  }

  /**
   * @param name
   */
  private void configureMockRoleDao(final String name) {

    roleDao = context.mock(RoleDao.class);
    lookupDao = context.mock(LookupDao.class);

    context.checking(new Expectations() {

      {
        final Role role = new Role(name);

        allowing(roleDao).getRoleByName(with(any(String.class)));
        will(returnValue(role));

        ignoring(lookupDao);
      }
    });
  }

  /**
   * 
   */
  private User configureUserDaoGet(final String name) {

    final User user = new User(name);

    context.checking(new Expectations() {

      {

        user.addRole(new Role(name));
        user.setId(Long.valueOf(-1L));

        allowing(userDao).loadUserByUsername(name);
        will(returnValue(user));

        allowing(userDao).get(with(any(Long.class)));
        will(returnValue(user));
      }
    });

    return user;
  }

  /**
   * 
   */
  private void configureUserDaoSave(final User user, final String name) {

    context.checking(new Expectations() {

      {
        final User userSaved = new User();

        BeanUtils.populate(userSaved, ResourceBundle
          .getBundle(FactoryMock.class.getName()));

        userSaved.addRole(new Role(name));

        allowing(userDao).saveUser(with(aUserNameEqual(name)));
        will(throwException(new DataIntegrityViolationException("User '"
          + user.getUsername() + "' already exists!")));

        allowing(userDao).saveUser(with(any(User.class)));
        will(returnValue(userSaved));

        ignoring(userDao);
      }
    });
  }

  /**
   * @return the lookupRoleManager
   */
  public final LookupDao getLookupDao() {
    return lookupDao;
  }

  /**
   * @return the roleDaoHibernate
   */
  public final RoleDao getRoleDao() {
    return roleDao;
  }

  public final PlatformTransactionManager getTransactionManager() {

    final UserTransaction userTransaction = context.mock(UserTransaction.class);

    context.checking(new Expectations() {

      {
        ignoring(userTransaction);
      }
    });

    // final TransactionTemplate tt =
    // getTransactionTemplateForJta(
    // JtaTransactionManager.DEFAULT_USER_TRANSACTION_NAME, userTransaction);

    final JtaTransactionManager transactionManager =
      new JtaTransactionManager(userTransaction);

    return transactionManager;
  }

  // private TransactionTemplate getTransactionTemplateForJta(final String
  // utName,
  // final UserTransaction ut) {
  //
  // final JndiTemplate jndiTemplate = new JndiTemplate() {
  //
  // @Override
  // protected Context createInitialContext() throws NamingException {
  //
  // final Context mockContext = new SimpleNamingContext();
  // mockContext.bind(utName, ut);
  // return mockContext;
  // }
  // };
  //
  // final JtaTransactionManager tm = new JtaTransactionManager();
  // tm.setJndiTemplate(jndiTemplate);
  // tm.setUserTransactionName(utName);
  //
  // return new TransactionTemplate(tm);
  // }

  /**
   * @return the userDao
   */
  public final UserDao getUserDao() {
    return userDao;
  }

}
