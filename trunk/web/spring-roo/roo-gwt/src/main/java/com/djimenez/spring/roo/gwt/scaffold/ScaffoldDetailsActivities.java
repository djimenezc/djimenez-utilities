package com.djimenez.spring.roo.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationRecordPlace;
import com.djimenez.spring.roo.gwt.request.ApplicationRequestFactory;
import com.djimenez.spring.roo.gwt.scaffold.place.BasePlaceFilter;
import com.djimenez.spring.roo.gwt.ui.EmployeeActivitiesMapper;
import com.djimenez.spring.roo.gwt.scaffold.place.EmployeeScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace} in the bottom
 * half of the {@link ScaffoldShell}.
 */
public final class ScaffoldDetailsActivities implements
    ActivityMapper<ApplicationPlace> {

  private final ActivityMapper<EmployeeScaffoldPlace> employeeActivities;
  public ScaffoldDetailsActivities(ApplicationRequestFactory requestFactory,
      PlaceController<ApplicationPlace> placeController) {
    this.employeeActivities = new EmployeeActivitiesMapper(
        requestFactory, placeController); 
  }

  public Activity getActivity(ApplicationPlace place) {
    return place.acceptFilter(new BasePlaceFilter<Activity>(null) {
      public Activity filter(EmployeeScaffoldPlace place) {
        return employeeActivities.getActivity(place);
      }
    });
  }
}
