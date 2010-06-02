package com.djimenez.spring.roo.gwt.scaffold.place;

import com.google.gwt.valuestore.shared.Record;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationPlaceFilter;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationListPlace;
import com.djimenez.spring.roo.gwt.scaffold.place.EmployeeScaffoldPlace;
import com.djimenez.spring.roo.gwt.request.EmployeeRecord;

/**
 * Filters an {@link ApplicationPlace} to the corresponding record
 * type.
 */
public final class ApplicationPlaceToRecordType implements
    ApplicationPlaceFilter<Class<? extends Record>> {

  public Class<? extends Record> filter(EmployeeScaffoldPlace place) {
    return EmployeeRecord.class;
  }

  public Class<? extends Record> filter(ApplicationListPlace place) {
    return place.getType();
  }
}