package com.djimenez.roo.gwt.gwt.request;

import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.model.Person;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.requestfactory.shared.ServerOperation;
import com.google.gwt.requestfactory.shared.RecordRequest;
import com.google.gwt.valuestore.shared.PropertyReference;
import com.google.gwt.requestfactory.shared.RequestFactory.RequestObject;

@RooGwtMirroredFrom(Person.class)
@ServerType(type = Person.class)
public interface PersonRequest {

    @ServerOperation("FIND_ALL_PEOPLE")
    abstract RecordListRequest<com.djimenez.roo.gwt.gwt.request.PersonRecord> findAllPeople();

    @ServerOperation("FIND_PERSON")
    abstract RecordRequest<com.djimenez.roo.gwt.gwt.request.PersonRecord> findPerson(PropertyReference<String> id);

    @ServerOperation("COUNT_PEOPLE")
    abstract RequestObject<java.lang.Long> countPeople();

    @ServerOperation("FIND_PERSON_ENTRIES")
    abstract RecordListRequest<com.djimenez.roo.gwt.gwt.request.PersonRecord> findPersonEntries(int firstResult, int maxResults);
}
