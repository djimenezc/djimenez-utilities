package com.djimenez.spring.roo.model;

import com.djimenez.spring.roo.model.Person;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PersonDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PersonDataOnDemand: @Component;
    
    private Random PersonDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Person> PersonDataOnDemand.data;
    
    public Person PersonDataOnDemand.getNewTransientPerson(int index) {
        com.djimenez.spring.roo.model.Person obj = new com.djimenez.spring.roo.model.Person();
        obj.setName("name_" + index);
        return obj;
    }
    
    public Person PersonDataOnDemand.getSpecificPerson(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Person obj = data.get(index);
        return Person.findPerson(obj.getId());
    }
    
    public Person PersonDataOnDemand.getRandomPerson() {
        init();
        Person obj = data.get(rnd.nextInt(data.size()));
        return Person.findPerson(obj.getId());
    }
    
    public boolean PersonDataOnDemand.modifyPerson(Person obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void PersonDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.djimenez.spring.roo.model.Person.findPersonEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Person' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.djimenez.spring.roo.model.Person>();
        for (int i = 0; i < 10; i++) {
            com.djimenez.spring.roo.model.Person obj = getNewTransientPerson(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
