package com.djimenez.persistence.core.orm.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.djimenez.core.patterns.interfaces.dao.GenericDaoExtend;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *      &lt;bean id="fooDao" class="com.gowex.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="com.gowex.model.Foo"/&gt;
 *          &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 * 
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @param <T>
 *          a type variable
 * @param <PK>
 *          the primary key for that type
 */
public class GenericDaoHibernate<T, PK extends Serializable> implements
  GenericDaoExtend<T, PK> {

  /**
   * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from
   * Commons Logging
   */
  protected final Log log = LogFactory.getLog(getClass());
  private final Class<T> persistentClass;
  private HibernateTemplate hibernateTemplate;
  private SessionFactory sessionFactory;

  /**
   * Constructor that takes in a class to see which type of entity to persist.
   * Use this constructor when subclassing.
   * 
   * @param persistentClass
   *          the class type you'd like to persist
   */
  public GenericDaoHibernate(final Class<T> persistentClass) {
    this.persistentClass = persistentClass;
  }

  /**
   * Constructor that takes in a class and sessionFactory for easy creation of
   * DAO.
   * 
   * @param persistentClass
   *          the class type you'd like to persist
   * @param sessionFactory
   *          the pre-configured Hibernate SessionFactory
   */
  public GenericDaoHibernate(final Class<T> persistentClass,
    final SessionFactory sessionFactory) {
    this.persistentClass = persistentClass;
    this.sessionFactory = sessionFactory;
    this.hibernateTemplate = new HibernateTemplate(sessionFactory);
  }

  /**
   * {@inheritDoc}
   */
  public boolean exists(final PK id) {
    final T entity = hibernateTemplate.get(this.persistentClass, id);
    return entity != null;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<T> findByNamedQuery(final String queryName,
    final Map<String, Object> queryParams) {

    final String[] params = new String[queryParams.size()];
    final Object[] values = new Object[queryParams.size()];

    int index = 0;

    final Iterator<Entry<String, Object>> itr =
      queryParams.entrySet().iterator();

    while (itr.hasNext()) {

      final Entry<String, Object> entry = itr.next();

      params[index] = entry.getKey();
      values[index++] = entry.getValue();
    }

    return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, params,
      values);
  }

  /**
   * {@inheritDoc}
   */
  public T get(final PK id) {
    final T entity = hibernateTemplate.get(this.persistentClass, id);

    if (entity == null) {
      log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id
        + "' not found...");
      throw new ObjectRetrievalFailureException(this.persistentClass, id);
    }

    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> getAll() {
    return hibernateTemplate.loadAll(this.persistentClass);
  }

  /**
   * {@inheritDoc}
   */
  public List<T> getAllDistinct() {

    final Collection<T> result = new LinkedHashSet<T>(getAll());

    return new ArrayList<T>(result);
  }

  public HibernateTemplate getHibernateTemplate() {
    return this.hibernateTemplate;
  }

  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  /**
   * {@inheritDoc}
   */
  public void remove(final PK id) {
    hibernateTemplate.delete(this.get(id));
  }

  /**
   * {@inheritDoc}
   */
  public T save(final T object) {
    return hibernateTemplate.merge(object);
  }

  @Autowired
  @Required
  public void setSessionFactory(final SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
    this.hibernateTemplate = new HibernateTemplate(sessionFactory);
  }
}
