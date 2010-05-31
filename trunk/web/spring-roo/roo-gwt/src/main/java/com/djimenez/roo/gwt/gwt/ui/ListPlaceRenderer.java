package com.djimenez.roo.gwt.gwt.ui;
import com.google.gwt.app.util.Renderer;
import com.google.gwt.valuestore.shared.Record;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationListPlace;
public class ListPlaceRenderer implements Renderer<ApplicationListPlace> {
    public String render(ApplicationListPlace object) {
        Class<? extends Record> type = object.getType();
        if (type.equals(com.djimenez.roo.gwt.gwt.request.PersonRecord.class)) {
            return "Persons";
        }
        throw new IllegalArgumentException("Cannot render unknown type " + object);
    }
}
