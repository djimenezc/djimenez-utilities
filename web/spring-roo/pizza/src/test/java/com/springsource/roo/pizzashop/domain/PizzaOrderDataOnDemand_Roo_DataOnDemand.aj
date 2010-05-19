package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.PizzaOrder;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PizzaOrderDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PizzaOrderDataOnDemand: @Component;
    
    private Random PizzaOrderDataOnDemand.rnd = new SecureRandom();
    
    private List<PizzaOrder> PizzaOrderDataOnDemand.data;
    
    public PizzaOrder PizzaOrderDataOnDemand.getNewTransientPizzaOrder(int index) {
        com.springsource.roo.pizzashop.domain.PizzaOrder obj = new com.springsource.roo.pizzashop.domain.PizzaOrder();
        obj.setName("name_" + index);
        obj.setTotal(new Integer(index).floatValue());
        return obj;
    }
    
    public PizzaOrder PizzaOrderDataOnDemand.getSpecificPizzaOrder(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        PizzaOrder obj = data.get(index);
        return PizzaOrder.findPizzaOrder(obj.getId());
    }
    
    public PizzaOrder PizzaOrderDataOnDemand.getRandomPizzaOrder() {
        init();
        PizzaOrder obj = data.get(rnd.nextInt(data.size()));
        return PizzaOrder.findPizzaOrder(obj.getId());
    }
    
    public boolean PizzaOrderDataOnDemand.modifyPizzaOrder(PizzaOrder obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void PizzaOrderDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.springsource.roo.pizzashop.domain.PizzaOrder.findPizzaOrderEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'PizzaOrder' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.springsource.roo.pizzashop.domain.PizzaOrder>();
        for (int i = 0; i < 10; i++) {
            com.springsource.roo.pizzashop.domain.PizzaOrder obj = getNewTransientPizzaOrder(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
