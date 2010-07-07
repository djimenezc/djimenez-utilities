package com.djimenez.spring.roo.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationListPlace;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationRecordPlace;
import com.djimenez.spring.roo.gwt.request.ApplicationRequestFactory;
import com.djimenez.spring.roo.gwt.scaffold.place.ApplicationPlaceFilter;
import com.djimenez.spring.roo.gwt.ui.EmployeeActivitiesMapper;
import com.djimenez.spring.roo.gwt.scaffold.place.EmployeeScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace}.
 */
public final class ScaffoldMobileActivities implements
    ActivityMapper<ApplicationPlace> {

  private final ActivityMapper<ApplicationListPlace> listActivitiesBuilder;
  private final ActivityMapper<EmployeeScaffoldPlace> employeeActivitiesBuilder;

  /**
   * @param requestFactory
   * @param placeController
   */
  public ScaffoldMobileActivities(
      ActivityMapper<ApplicationListPlace> listActivitiesBuilder,
      ApplicationRequestFactory requestFactory,
      PlaceController<ApplicationPlace> placeController) {
    this.listActivitiesBuilder = listActivitiesBuilder;
    this.employeeActivitiesBuilder = new EmployeeActivitiesMapper(
        requestFactory, placeController); 
  }

   public Activity getActivity(ApplicationPlace place) {
    return place.acceptFilter(new ApplicationPlaceFilter<Activity>() {
      public Activity filter(EmployeeScaffoldPlace place) {
        return employeeActivitiesBuilder.getActivity(place);
      }
      public Activity filter(ApplicationListPlace place) {
        return listActivitiesBuilder.getActivity(place);
      }
    });
  }
}