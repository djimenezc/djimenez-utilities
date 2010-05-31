package com.djimenez.roo.gwt.gwt.request;

import com.google.gwt.valuestore.shared.Record;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.model.Person;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.valuestore.shared.Property;

@RooGwtMirroredFrom(Person.class)
@ServerType(type = Person.class)
public interface PersonRecord extends Record {

    public String TOKEN = "PersonRecord";

    Property<java.lang.String> name = new com.google.gwt.valuestore.shared.Property<java.lang.String>("name", "Name", java.lang.String.class);

    abstract String getName();
}
