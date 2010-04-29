package com.djimenez.example.spring.mvc.persistence.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.persistence.dao.LookupDao;

/**
 * Hibernate implementation of LookupDao.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Repository
public class LookupDaoHibernate implements LookupDao {

  private final Log log = LogFactory.getLog(LookupDaoHibernate.class);
  private final HibernateTemplate hibernateTemplate;

  @Autowired
  public LookupDaoHibernate(final SessionFactory sessionFactory) {
    this.hibernateTemplate = new HibernateTemplate(sessionFactory);
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public final List<Role> getRoles() {
    log.debug("Retrieving all role names...");

    return hibernateTemplate.find("from Role order by name");
  }
}
