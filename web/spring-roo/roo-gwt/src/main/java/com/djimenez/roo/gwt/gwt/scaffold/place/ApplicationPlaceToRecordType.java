package com.djimenez.roo.gwt.gwt.scaffold.place;

import com.google.gwt.valuestore.shared.Record;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlaceFilter;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationListPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.PersonScaffoldPlace;
import com.djimenez.roo.gwt.gwt.request.PersonRecord;

/**
 * Filters an {@link ApplicationPlace} to the corresponding record
 * type.
 */
public final class ApplicationPlaceToRecordType implements
    ApplicationPlaceFilter<Class<? extends Record>> {

  public Class<? extends Record> filter(PersonScaffoldPlace place) {
    return PersonRecord.class;
  }

  public Class<? extends Record> filter(ApplicationListPlace place) {
    return place.getType();
  }
}