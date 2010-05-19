package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.Pizza;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PizzaDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PizzaDataOnDemand: @Component;
    
    private Random PizzaDataOnDemand.rnd = new SecureRandom();
    
    private List<Pizza> PizzaDataOnDemand.data;
    
    public Pizza PizzaDataOnDemand.getNewTransientPizza(int index) {
        com.springsource.roo.pizzashop.domain.Pizza obj = new com.springsource.roo.pizzashop.domain.Pizza();
        obj.setName("name_" + index);
        obj.setPrice(new Integer(index).floatValue());
        return obj;
    }
    
    public Pizza PizzaDataOnDemand.getSpecificPizza(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Pizza obj = data.get(index);
        return Pizza.findPizza(obj.getId());
    }
    
    public Pizza PizzaDataOnDemand.getRandomPizza() {
        init();
        Pizza obj = data.get(rnd.nextInt(data.size()));
        return Pizza.findPizza(obj.getId());
    }
    
    public boolean PizzaDataOnDemand.modifyPizza(Pizza obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void PizzaDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.springsource.roo.pizzashop.domain.Pizza.findPizzaEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Pizza' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.springsource.roo.pizzashop.domain.Pizza>();
        for (int i = 0; i < 10; i++) {
            com.springsource.roo.pizzashop.domain.Pizza obj = getNewTransientPizza(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
