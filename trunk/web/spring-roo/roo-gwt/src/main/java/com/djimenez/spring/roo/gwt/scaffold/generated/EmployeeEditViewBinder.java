package com.djimenez.spring.roo.gwt.scaffold.generated;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.djimenez.spring.roo.gwt.scaffold.generated.EmployeeEditView;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.server.domain.Employee;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public interface EmployeeEditViewBinder extends UiBinder<HTMLPanel, EmployeeEditView> {
}
