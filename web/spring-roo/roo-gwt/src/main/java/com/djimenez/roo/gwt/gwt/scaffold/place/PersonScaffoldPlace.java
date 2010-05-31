package com.djimenez.roo.gwt.gwt.scaffold.place;

import com.djimenez.roo.gwt.gwt.request.PersonRecord;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlaceFilter;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlaceProcessor;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace;

/**
 * A place in the scaffold app for working with an PersonRecord.
 */
public class PersonScaffoldPlace extends ApplicationRecordPlace {

  public PersonScaffoldPlace(PersonRecord record, Operation operation) {
    super(record.getId(), operation);
  }

  public PersonScaffoldPlace(String id, Operation operation) {
    super(id, operation);
  }

  @Override
  public void accept(ApplicationPlaceProcessor visitor) {
    visitor.process(this);
  }

  @Override
  public <T> T acceptFilter(ApplicationPlaceFilter<T> filter) {
    return filter.filter(this);
  }
}
