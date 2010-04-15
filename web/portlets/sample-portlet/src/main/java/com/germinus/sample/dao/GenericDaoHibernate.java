package com.germinus.sample.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *      &lt;bean id="fooDao" class="org.appfuse.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="org.appfuse.model.Foo"/&gt;
 *          &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 * 
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 */
public class GenericDaoHibernate<T, PK extends Serializable> extends
  HibernateDaoSupport implements GenericDao<T, PK> {

  private final Log log = LogFactory.getLog(getClass());

  private final Class<T> persistentClass;

  public GenericDaoHibernate(final Class<T> persistentClass) {
    this.persistentClass = persistentClass;
  }

  public final boolean exists(final PK id) {

    final T entity = super.getHibernateTemplate().get(this.persistentClass, id);

    if (entity == null) {
      return false;
    }

    return true;
  }

  public final T get(final PK id) {

    final T entity = super.getHibernateTemplate().get(this.persistentClass, id);

    if (entity == null) {
      log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id
        + "' not found...");
      throw new ObjectRetrievalFailureException(this.persistentClass, id);
    }

    return entity;
  }

  public final List<T> getAll() {
    return super.getHibernateTemplate().loadAll(this.persistentClass);
  }

  public final void remove(final PK id) {

    super.getHibernateTemplate().delete(this.get(id));
  }

  public final T save(final T object) {

    return super.getHibernateTemplate().merge(object);
  }
}