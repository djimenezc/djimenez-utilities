package com.springsource.roo.pizzashop.domain;

import com.springsource.roo.pizzashop.domain.PizzaOrderDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PizzaOrderIntegrationTest_Roo_IntegrationTest {
    
    declare @type: PizzaOrderIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: PizzaOrderIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private PizzaOrderDataOnDemand PizzaOrderIntegrationTest.dod;
    
    @Test
    public void PizzaOrderIntegrationTest.testCountPizzaOrders() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        long count = com.springsource.roo.pizzashop.domain.PizzaOrder.countPizzaOrders();
        org.junit.Assert.assertTrue("Counter for 'PizzaOrder' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void PizzaOrderIntegrationTest.testFindPizzaOrder() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        java.lang.Long id = dod.getRandomPizzaOrder().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to provide an identifier", id);
        com.springsource.roo.pizzashop.domain.PizzaOrder obj = com.springsource.roo.pizzashop.domain.PizzaOrder.findPizzaOrder(id);
        org.junit.Assert.assertNotNull("Find method for 'PizzaOrder' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'PizzaOrder' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void PizzaOrderIntegrationTest.testFindAllPizzaOrders() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        long count = com.springsource.roo.pizzashop.domain.PizzaOrder.countPizzaOrders();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'PizzaOrder', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.springsource.roo.pizzashop.domain.PizzaOrder> result = com.springsource.roo.pizzashop.domain.PizzaOrder.findAllPizzaOrders();
        org.junit.Assert.assertNotNull("Find all method for 'PizzaOrder' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'PizzaOrder' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void PizzaOrderIntegrationTest.testFindPizzaOrderEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        long count = com.springsource.roo.pizzashop.domain.PizzaOrder.countPizzaOrders();
        if (count > 20) count = 20;
        java.util.List<com.springsource.roo.pizzashop.domain.PizzaOrder> result = com.springsource.roo.pizzashop.domain.PizzaOrder.findPizzaOrderEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'PizzaOrder' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'PizzaOrder' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void PizzaOrderIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        java.lang.Long id = dod.getRandomPizzaOrder().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to provide an identifier", id);
        com.springsource.roo.pizzashop.domain.PizzaOrder obj = com.springsource.roo.pizzashop.domain.PizzaOrder.findPizzaOrder(id);
        org.junit.Assert.assertNotNull("Find method for 'PizzaOrder' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyPizzaOrder(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'PizzaOrder' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void PizzaOrderIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        java.lang.Long id = dod.getRandomPizzaOrder().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to provide an identifier", id);
        com.springsource.roo.pizzashop.domain.PizzaOrder obj = com.springsource.roo.pizzashop.domain.PizzaOrder.findPizzaOrder(id);
        org.junit.Assert.assertNotNull("Find method for 'PizzaOrder' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyPizzaOrder(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'PizzaOrder' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void PizzaOrderIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        com.springsource.roo.pizzashop.domain.PizzaOrder obj = dod.getNewTransientPizzaOrder(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'PizzaOrder' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'PizzaOrder' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void PizzaOrderIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to initialize correctly", dod.getRandomPizzaOrder());
        java.lang.Long id = dod.getRandomPizzaOrder().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'PizzaOrder' failed to provide an identifier", id);
        com.springsource.roo.pizzashop.domain.PizzaOrder obj = com.springsource.roo.pizzashop.domain.PizzaOrder.findPizzaOrder(id);
        org.junit.Assert.assertNotNull("Find method for 'PizzaOrder' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'PizzaOrder' with identifier '" + id + "'", com.springsource.roo.pizzashop.domain.PizzaOrder.findPizzaOrder(id));
    }
    
}
