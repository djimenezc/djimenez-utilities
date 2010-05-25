package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.Base;
import java.lang.Integer;
import java.lang.Long;
import java.lang.SuppressWarnings;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Base_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Base.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Base.id;
    
    @Version
    @Column(name = "version")
    private Integer Base.version;
    
    public Long Base.getId() {
        return this.id;
    }
    
    public void Base.setId(Long id) {
        this.id = id;
    }
    
    public Integer Base.getVersion() {
        return this.version;
    }
    
    public void Base.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Base.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Base.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Base attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Base.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Base Base.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Base merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Base.entityManager() {
        EntityManager em = new Base().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Base.countBases() {
        return ((Number) entityManager().createQuery("select count(o) from Base o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Base> Base.findAllBases() {
        return entityManager().createQuery("select o from Base o").getResultList();
    }
    
    public static Base Base.findBase(Long id) {
        if (id == null) return null;
        return entityManager().find(Base.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Base> Base.findBaseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Base o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
