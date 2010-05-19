package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.Pizza;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Pizza_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Pizza.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Pizza.id;
    
    @Version
    @Column(name = "version")
    private Integer Pizza.version;
    
    public Long Pizza.getId() {
        return this.id;
    }
    
    public void Pizza.setId(Long id) {
        this.id = id;
    }
    
    public Integer Pizza.getVersion() {
        return this.version;
    }
    
    public void Pizza.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Pizza.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Pizza.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Pizza attached = this.entityManager.find(Pizza.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Pizza.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Pizza.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Pizza merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager Pizza.entityManager() {
        EntityManager em = new Pizza().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Pizza.countPizzas() {
        return (Long) entityManager().createQuery("select count(o) from Pizza o").getSingleResult();
    }
    
    public static List<Pizza> Pizza.findAllPizzas() {
        return entityManager().createQuery("select o from Pizza o").getResultList();
    }
    
    public static Pizza Pizza.findPizza(Long id) {
        if (id == null) return null;
        return entityManager().find(Pizza.class, id);
    }
    
    public static List<Pizza> Pizza.findPizzaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Pizza o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}