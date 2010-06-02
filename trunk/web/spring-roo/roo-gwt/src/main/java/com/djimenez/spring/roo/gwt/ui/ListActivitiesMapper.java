package com.djimenez.spring.roo.gwt.ui;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.valuestore.ui.AbstractRecordListActivity;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationListPlace;
import com.djimenez.spring.roo.gwt.request.ApplicationRequestFactory;
import com.djimenez.spring.roo.gwt.ui.EmployeeListActivity;
import com.djimenez.spring.roo.gwt.request.EmployeeRecord;

/**
 * The class that knows what {@link com.google.gwt.app.place.Activity} to run
 * when the user goes to a particular {@link ListScaffoldPlace}.
 */
public class ListActivitiesMapper implements ActivityMapper<ApplicationListPlace> {
  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;
  private HandlerManager eventBus;

  public ListActivitiesMapper(HandlerManager eventBus,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this.eventBus = eventBus;
    this.requests = requests;
    this.placeController = placeController;
  }

  public AbstractRecordListActivity<?> getActivity(ApplicationListPlace place) {
    if (place.getType().equals(EmployeeRecord.class)) {
      return new EmployeeListActivity(eventBus, requests, placeController);
    }
    throw new RuntimeException("Unable to locate a activity for " + place);
  }
}
