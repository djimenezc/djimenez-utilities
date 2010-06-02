package com.djimenez.spring.roo.gwt.request;

import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.server.domain.Employee;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.requestfactory.shared.ServerOperation;
import com.google.gwt.requestfactory.shared.RecordRequest;
import com.google.gwt.valuestore.shared.PropertyReference;
import com.google.gwt.requestfactory.shared.RequestFactory.RequestObject;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public interface EmployeeRequest {

    @ServerOperation("FIND_ALL_EMPLOYEES")
    abstract RecordListRequest<com.djimenez.spring.roo.gwt.request.EmployeeRecord> findAllEmployees();

    @ServerOperation("FIND_EMPLOYEE")
    abstract RecordRequest<com.djimenez.spring.roo.gwt.request.EmployeeRecord> findEmployee(PropertyReference<String> id);

    @ServerOperation("COUNT_EMPLOYEES")
    abstract RequestObject<java.lang.Long> countEmployees();

    @ServerOperation("FIND_EMPLOYEE_ENTRIES")
    abstract RecordListRequest<com.djimenez.spring.roo.gwt.request.EmployeeRecord> findEmployeeEntries(int firstResult, int maxResults);
}
