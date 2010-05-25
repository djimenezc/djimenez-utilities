package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.Base;
import javax.persistence.EntityManager;
import javax.persistence.Query;

privileged aspect Pizza_Roo_Finder {
    
    public static Query Pizza.findPizzasByBase(Base base) {
        if (base == null) throw new IllegalArgumentException("The base argument is required");
        EntityManager em = Pizza.entityManager();
        Query q = em.createQuery("SELECT Pizza FROM Pizza AS pizza WHERE pizza.base = :base");
        q.setParameter("base", base);
        return q;
    }
    
}
