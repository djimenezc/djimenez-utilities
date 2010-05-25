package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.Topping;
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

privileged aspect Topping_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Topping.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Topping.id;
    
    @Version
    @Column(name = "version")
    private Integer Topping.version;
    
    public Long Topping.getId() {
        return this.id;
    }
    
    public void Topping.setId(Long id) {
        this.id = id;
    }
    
    public Integer Topping.getVersion() {
        return this.version;
    }
    
    public void Topping.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Topping.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Topping.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Topping attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Topping.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Topping Topping.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Topping merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Topping.entityManager() {
        EntityManager em = new Topping().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Topping.countToppings() {
        return ((Number) entityManager().createQuery("select count(o) from Topping o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Topping> Topping.findAllToppings() {
        return entityManager().createQuery("select o from Topping o").getResultList();
    }
    
    public static Topping Topping.findTopping(Long id) {
        if (id == null) return null;
        return entityManager().find(Topping.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Topping> Topping.findToppingEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Topping o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
