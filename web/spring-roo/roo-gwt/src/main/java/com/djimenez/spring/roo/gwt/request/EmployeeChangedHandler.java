package com.djimenez.spring.roo.gwt.request;

import com.google.gwt.event.shared.EventHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.server.domain.Employee;
import com.google.gwt.requestfactory.shared.ServerType;
import com.djimenez.spring.roo.gwt.request.EmployeeRecordChanged;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public interface EmployeeChangedHandler extends EventHandler {

    abstract void onEmployeeChanged(EmployeeRecordChanged event);
}
