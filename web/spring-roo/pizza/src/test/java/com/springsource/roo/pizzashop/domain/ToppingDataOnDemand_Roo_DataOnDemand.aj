package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.Topping;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ToppingDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ToppingDataOnDemand: @Component;
    
    private Random ToppingDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Topping> ToppingDataOnDemand.data;
    
    public Topping ToppingDataOnDemand.getNewTransientTopping(int index) {
        com.springsource.roo.pizzashop.domain.Topping obj = new com.springsource.roo.pizzashop.domain.Topping();
        obj.setName("name_" + index);
        return obj;
    }
    
    public Topping ToppingDataOnDemand.getSpecificTopping(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Topping obj = data.get(index);
        return Topping.findTopping(obj.getId());
    }
    
    public Topping ToppingDataOnDemand.getRandomTopping() {
        init();
        Topping obj = data.get(rnd.nextInt(data.size()));
        return Topping.findTopping(obj.getId());
    }
    
    public boolean ToppingDataOnDemand.modifyTopping(Topping obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void ToppingDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.springsource.roo.pizzashop.domain.Topping.findToppingEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Topping' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.springsource.roo.pizzashop.domain.Topping>();
        for (int i = 0; i < 10; i++) {
            com.springsource.roo.pizzashop.domain.Topping obj = getNewTransientTopping(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
