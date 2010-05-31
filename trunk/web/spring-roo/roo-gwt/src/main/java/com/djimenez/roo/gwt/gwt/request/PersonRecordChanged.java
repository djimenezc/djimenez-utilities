package com.djimenez.roo.gwt.gwt.request;

import com.google.gwt.valuestore.shared.RecordChangedEvent;
import com.djimenez.roo.gwt.gwt.request.PersonRecord;
import com.djimenez.roo.gwt.gwt.request.PersonChangedHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.model.Person;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.requestfactory.shared.RequestFactory.WriteOperation;

@RooGwtMirroredFrom(Person.class)
@ServerType(type = Person.class)
public class PersonRecordChanged extends RecordChangedEvent<PersonRecord, PersonChangedHandler> {

    public static final Type<com.djimenez.roo.gwt.gwt.request.PersonChangedHandler> TYPE = new com.google.gwt.event.shared.GwtEvent.Type<com.djimenez.roo.gwt.gwt.request.PersonChangedHandler>();

    public PersonRecordChanged(PersonRecord record, WriteOperation writeOperation) {
        super(record, writeOperation);
    }

    public Type<com.djimenez.roo.gwt.gwt.request.PersonChangedHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(PersonChangedHandler handler) {
        handler.onPersonChanged(this);
    }
}
