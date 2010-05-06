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
  private UserDao userDao;
  private RoleDao roleDao;

  private LookupDao lookupDao;

  public FactoryMock() {

    configureMockRoleDao();
    configureUserDao();
  }

  /**
   * 
   */
  private void configureMockRoleDao() {

    roleDao = context.mock(RoleDao.class);
    lookupDao = context.mock(LookupDao.class);

    context.checking(new Expectations() {

      {
        final Role role = new Role("user");

        allowing(roleDao).getRoleByName(with(any(String.class)));
        will(returnValue(role));

        ignoring(lookupDao);
      }
    });
  }

  /**
   * 
   */
  private void configureUserDao() {

    userDao = context.mock(UserDao.class);

    context.checking(new Expectations() {

      {
        final String name = "david";

        final User user = new User(name);

        user.setId(Long.valueOf(-1L));

        allowing(userDao).get(with(any(Long.class)));
        will(returnValue(user));

        final User userSaved = new User();

        BeanUtils.populate(userSaved, ResourceBundle
          .getBundle(FactoryMock.class.getName()));

        userSaved.addRole(new Role("user"));

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
  public LookupDao getLookupDao() {
    return lookupDao;
  }

  /**
   * @return the roleDaoHibernate
   */
  public RoleDao getRoleDao() {
    return roleDao;
  }

  public PlatformTransactionManager getTransactionManager() {

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
  public UserDao getUserDao() {
    return userDao;
  }

}
