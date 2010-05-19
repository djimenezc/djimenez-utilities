package com.gowex.test;

import com.gowex.test.Timer;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TimerDataOnDemand_Roo_DataOnDemand {
    
    declare @type: TimerDataOnDemand: @Component;
    
    private Random TimerDataOnDemand.rnd = new SecureRandom();
    
    private List<Timer> TimerDataOnDemand.data;
    
    public Timer TimerDataOnDemand.getNewTransientTimer(int index) {
        com.gowex.test.Timer obj = new com.gowex.test.Timer();
        obj.setMessage("message_" + index);
        return obj;
    }
    
    public Timer TimerDataOnDemand.getSpecificTimer(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Timer obj = data.get(index);
        return Timer.findTimer(obj.getId());
    }
    
    public Timer TimerDataOnDemand.getRandomTimer() {
        init();
        Timer obj = data.get(rnd.nextInt(data.size()));
        return Timer.findTimer(obj.getId());
    }
    
    public boolean TimerDataOnDemand.modifyTimer(Timer obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void TimerDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.gowex.test.Timer.findTimerEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Timer' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.gowex.test.Timer>();
        for (int i = 0; i < 10; i++) {
            com.gowex.test.Timer obj = getNewTransientTimer(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
