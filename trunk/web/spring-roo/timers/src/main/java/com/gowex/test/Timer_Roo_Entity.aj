package com.gowex.test;

import com.gowex.test.Timer;
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

privileged aspect Timer_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Timer.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Timer.id;
    
    @Version
    @Column(name = "version")
    private Integer Timer.version;
    
    public Long Timer.getId() {
        return this.id;
    }
    
    public void Timer.setId(Long id) {
        this.id = id;
    }
    
    public Integer Timer.getVersion() {
        return this.version;
    }
    
    public void Timer.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Timer.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Timer.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Timer attached = this.entityManager.find(Timer.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Timer.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Timer.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Timer merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager Timer.entityManager() {
        EntityManager em = new Timer().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Timer.countTimers() {
        return (Long) entityManager().createQuery("select count(o) from Timer o").getSingleResult();
    }
    
    public static List<Timer> Timer.findAllTimers() {
        return entityManager().createQuery("select o from Timer o").getResultList();
    }
    
    public static Timer Timer.findTimer(Long id) {
        if (id == null) return null;
        return entityManager().find(Timer.class, id);
    }
    
    public static List<Timer> Timer.findTimerEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Timer o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
