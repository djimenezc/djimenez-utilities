package com.djimenez.roo.gwt.gwt.request;

import com.google.gwt.requestfactory.shared.RequestFactory.RequestDefinition;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.model.Person;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Person.class)
@ServerType(type = Person.class)
public enum PersonRequestServerSideOperations implements RequestDefinition {

    FIND_ALL_PEOPLE, FIND_PERSON, COUNT_PEOPLE, FIND_PERSON_ENTRIES;

    public String getDomainClassName() {
        return "com.djimenez.spring.roo.model.Person";
    }

    public String getDomainMethodName() {
        switch(this) {
            case FIND_ALL_PEOPLE:
                return "findAllPeople";
            case FIND_PERSON:
                return "findPerson";
            case COUNT_PEOPLE:
                return "countPeople";
            case FIND_PERSON_ENTRIES:
                return "findPersonEntries";
            default:
                throw new IllegalStateException();
        }
    }

    public boolean isReturnTypeList() {
        switch(this) {
            case FIND_ALL_PEOPLE:
                return true;
            case FIND_PERSON:
                return false;
            case COUNT_PEOPLE:
                return false;
            case FIND_PERSON_ENTRIES:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?> getReturnType() {
        switch(this) {
            case FIND_ALL_PEOPLE:
                return com.djimenez.roo.gwt.gwt.request.PersonRecord.class;
            case FIND_PERSON:
                return com.djimenez.roo.gwt.gwt.request.PersonRecord.class;
            case COUNT_PEOPLE:
                return java.lang.Long.class;
            case FIND_PERSON_ENTRIES:
                return com.djimenez.roo.gwt.gwt.request.PersonRecord.class;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?>[] getParameterTypes() {
        switch(this) {
            case FIND_ALL_PEOPLE:
                return null;
            case FIND_PERSON:
                return new Class[] { java.lang.Long.class };
            case COUNT_PEOPLE:
                return null;
            case FIND_PERSON_ENTRIES:
                return new Class[] { int.class, int.class };
            default:
                throw new IllegalStateException();
        }
    }
}
