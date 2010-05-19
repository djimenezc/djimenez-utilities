package com.gowex.test;

import com.gowex.test.TimerDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TimerIntegrationTest_Roo_IntegrationTest {
    
    declare @type: TimerIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: TimerIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private TimerDataOnDemand TimerIntegrationTest.dod;
    
    @Test
    public void TimerIntegrationTest.testCountTimers() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        long count = com.gowex.test.Timer.countTimers();
        org.junit.Assert.assertTrue("Counter for 'Timer' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void TimerIntegrationTest.testFindTimer() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        java.lang.Long id = dod.getRandomTimer().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to provide an identifier", id);
        com.gowex.test.Timer obj = com.gowex.test.Timer.findTimer(id);
        org.junit.Assert.assertNotNull("Find method for 'Timer' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Timer' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void TimerIntegrationTest.testFindAllTimers() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        long count = com.gowex.test.Timer.countTimers();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Timer', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.gowex.test.Timer> result = com.gowex.test.Timer.findAllTimers();
        org.junit.Assert.assertNotNull("Find all method for 'Timer' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Timer' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void TimerIntegrationTest.testFindTimerEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        long count = com.gowex.test.Timer.countTimers();
        if (count > 20) count = 20;
        java.util.List<com.gowex.test.Timer> result = com.gowex.test.Timer.findTimerEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'Timer' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Timer' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void TimerIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        java.lang.Long id = dod.getRandomTimer().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to provide an identifier", id);
        com.gowex.test.Timer obj = com.gowex.test.Timer.findTimer(id);
        org.junit.Assert.assertNotNull("Find method for 'Timer' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTimer(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Timer' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void TimerIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        java.lang.Long id = dod.getRandomTimer().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to provide an identifier", id);
        com.gowex.test.Timer obj = com.gowex.test.Timer.findTimer(id);
        org.junit.Assert.assertNotNull("Find method for 'Timer' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTimer(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Timer' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void TimerIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        com.gowex.test.Timer obj = dod.getNewTransientTimer(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Timer' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Timer' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void TimerIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to initialize correctly", dod.getRandomTimer());
        java.lang.Long id = dod.getRandomTimer().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Timer' failed to provide an identifier", id);
        com.gowex.test.Timer obj = com.gowex.test.Timer.findTimer(id);
        org.junit.Assert.assertNotNull("Find method for 'Timer' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        org.junit.Assert.assertNull("Failed to remove 'Timer' with identifier '" + id + "'", com.gowex.test.Timer.findTimer(id));
    }
    
}
