package com.djimenez.spring.roo.gwt.ui;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.djimenez.spring.roo.gwt.request.EmployeeRecord;
import com.djimenez.spring.roo.gwt.scaffold.place.EmployeeScaffoldPlace;
import com.djimenez.spring.roo.gwt.ui.EmployeeDetailsActivity;
import com.djimenez.spring.roo.gwt.ui.EmployeeEditActivity;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.spring.roo.gwt.request.ApplicationRequestFactory;

/**
 * Maps {@link ${entity.detailsPlace} instances to the {@link Activity} to run.
 */
public class EmployeeActivitiesMapper implements
    ActivityMapper<EmployeeScaffoldPlace> {
  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  public EmployeeActivitiesMapper(ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this.requests = requests;
    this.placeController = placeController;
  }

  public Activity getActivity(EmployeeScaffoldPlace place) {
    switch (place.getOperation()) {
      case DETAILS:
        return new EmployeeDetailsActivity(place.getId(), requests, placeController);

      case EDIT:
        return new EmployeeEditActivity(place.getId(), requests,
            placeController);
    }

    throw new IllegalArgumentException("Unknown operation "
        + place.getOperation());
  }
}
