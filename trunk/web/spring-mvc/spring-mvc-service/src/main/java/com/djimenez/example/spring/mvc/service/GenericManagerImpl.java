package com.djimenez.example.spring.mvc.service;

import java.io.Serializable;
import java.util.List;

import com.djimenez.example.spring.mvc.persistence.dao.GenericDao;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *     &lt;bean id="userManager" class="com.gowex.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.gowex.dao.hibernate.GenericDaoHibernate"&gt;
 *                 &lt;constructor-arg value="com.gowex.model.User"/&gt;
 *                 &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 * <p>
 * If you're using iBATIS instead of Hibernate, use:
 * 
 * <pre>
 *     &lt;bean id="userManager" class="com.gowex.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.gowex.dao.ibatis.GenericDaoiBatis"&gt;
 *                 &lt;constructor-arg value="com.gowex.model.User"/&gt;
 *                 &lt;property name="dataSource" ref="dataSource"/&gt;
 *                 &lt;property name="sqlMapClient" ref="sqlMapClient"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @param <T>
 *          a type variable
 * @param <PK>
 *          the primary key for that type
 */
public class GenericManagerImpl<T, PK extends Serializable> implements
  GenericManager<T, PK> {

  /**
   * GenericDao instance, set by constructor of child classes
   */
  private GenericDao<T, PK> dao;

  public GenericManagerImpl() {
  }

  public GenericManagerImpl(final GenericDao<T, PK> genericDao) {
    this.setDao(genericDao);
  }

  /**
   * {@inheritDoc}
   */
  public final boolean exists(final PK id) {
    return getDao().exists(id);
  }

  /**
   * {@inheritDoc}
   */
  public final T get(final PK id) {
    return getDao().get(id);
  }

  /**
   * {@inheritDoc}
   */
  public final List<T> getAll() {
    return getDao().getAll();
  }

  /**
   * @return the dao
   */
  protected GenericDao<T, PK> getDao() {
    return dao;
  }

  /**
   * {@inheritDoc}
   */
  public final void remove(final PK id) {
    getDao().remove(id);
  }

  /**
   * {@inheritDoc}
   */
  public final T save(final T object) {
    return getDao().save(object);
  }

  /**
   * @param dao
   *          the dao to set
   */
  protected void setDao(final GenericDao<T, PK> dao) {
    this.dao = dao;
  }

}
