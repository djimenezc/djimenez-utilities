package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.PizzaOrder;
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

privileged aspect PizzaOrder_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager PizzaOrder.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long PizzaOrder.id;
    
    @Version
    @Column(name = "version")
    private Integer PizzaOrder.version;
    
    public Long PizzaOrder.getId() {
        return this.id;
    }
    
    public void PizzaOrder.setId(Long id) {
        this.id = id;
    }
    
    public Integer PizzaOrder.getVersion() {
        return this.version;
    }
    
    public void PizzaOrder.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void PizzaOrder.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PizzaOrder.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PizzaOrder attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PizzaOrder.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public PizzaOrder PizzaOrder.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PizzaOrder merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager PizzaOrder.entityManager() {
        EntityManager em = new PizzaOrder().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PizzaOrder.countPizzaOrders() {
        return ((Number) entityManager().createQuery("select count(o) from PizzaOrder o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<PizzaOrder> PizzaOrder.findAllPizzaOrders() {
        return entityManager().createQuery("select o from PizzaOrder o").getResultList();
    }
    
    public static PizzaOrder PizzaOrder.findPizzaOrder(Long id) {
        if (id == null) return null;
        return entityManager().find(PizzaOrder.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<PizzaOrder> PizzaOrder.findPizzaOrderEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from PizzaOrder o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
