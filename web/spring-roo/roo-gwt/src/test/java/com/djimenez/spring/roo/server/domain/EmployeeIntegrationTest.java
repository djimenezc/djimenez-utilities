package com.djimenez.spring.roo.server.domain;

import org.springframework.roo.addon.test.RooIntegrationTest;
import com.djimenez.spring.roo.server.domain.Employee;
import org.junit.Test;

@RooIntegrationTest(entity = Employee.class)
public class EmployeeIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
