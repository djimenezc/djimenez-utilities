package com.djimenez.spring.roo.model;

import org.springframework.roo.addon.test.RooIntegrationTest;
import com.djimenez.spring.roo.model.Person;
import org.junit.Test;

@RooIntegrationTest(entity = Person.class)
public class PersonIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
