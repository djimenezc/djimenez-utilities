package com.djimenez.roo.gwt.gwt.request;

import com.google.gwt.event.shared.EventHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.model.Person;
import com.google.gwt.requestfactory.shared.ServerType;
import com.djimenez.roo.gwt.gwt.request.PersonRecordChanged;

@RooGwtMirroredFrom(Person.class)
@ServerType(type = Person.class)
public interface PersonChangedHandler extends EventHandler {

    abstract void onPersonChanged(PersonRecordChanged event);
}
