package com.djimenez.roo.gwt.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationListPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace;
import com.djimenez.roo.gwt.gwt.request.ApplicationRequestFactory;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlaceFilter;
import com.djimenez.roo.gwt.gwt.ui.PersonActivitiesMapper;
import com.djimenez.roo.gwt.gwt.scaffold.place.PersonScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace}.
 */
public final class ScaffoldMobileActivities implements
    ActivityMapper<ApplicationPlace> {

  private final ActivityMapper<ApplicationListPlace> listActivitiesBuilder;
  private final ActivityMapper<PersonScaffoldPlace> personActivitiesBuilder;

  /**
   * @param requestFactory
   * @param placeController
   */
  public ScaffoldMobileActivities(
      ActivityMapper<ApplicationListPlace> listActivitiesBuilder,
      ApplicationRequestFactory requestFactory,
      PlaceController<ApplicationPlace> placeController) {
    this.listActivitiesBuilder = listActivitiesBuilder;
    this.personActivitiesBuilder = new PersonActivitiesMapper(
        requestFactory, placeController); 
  }

   public Activity getActivity(ApplicationPlace place) {
    return place.acceptFilter(new ApplicationPlaceFilter<Activity>() {
      public Activity filter(PersonScaffoldPlace place) {
        return personActivitiesBuilder.getActivity(place);
      }
      public Activity filter(ApplicationListPlace place) {
        return listActivitiesBuilder.getActivity(place);
      }
    });
  }
}
