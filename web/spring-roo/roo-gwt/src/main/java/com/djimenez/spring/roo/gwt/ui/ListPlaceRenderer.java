package com.djimenez.spring.roo.gwt.ui;
import com.google.gwt.app.util.Renderer;
import com.google.gwt.valuestore.shared.Record;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationListPlace;
public class ListPlaceRenderer implements Renderer<ApplicationListPlace> {
    public String render(ApplicationListPlace object) {
        Class<? extends Record> type = object.getType();
        if (type.equals(com.djimenez.spring.roo.gwt.request.EmployeeRecord.class)) {
            return "Employees";
        }
        throw new IllegalArgumentException("Cannot render unknown type " + object);
    }
}
