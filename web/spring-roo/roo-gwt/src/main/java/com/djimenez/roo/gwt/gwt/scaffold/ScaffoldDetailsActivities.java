package com.djimenez.roo.gwt.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace;
import com.djimenez.roo.gwt.gwt.request.ApplicationRequestFactory;
import com.djimenez.roo.gwt.gwt.scaffold.place.BasePlaceFilter;
import com.djimenez.roo.gwt.gwt.ui.PersonActivitiesMapper;
import com.djimenez.roo.gwt.gwt.scaffold.place.PersonScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace} in the bottom
 * half of the {@link ScaffoldShell}.
 */
public final class ScaffoldDetailsActivities implements
    ActivityMapper<ApplicationPlace> {

  private final ActivityMapper<PersonScaffoldPlace> personActivities;
  public ScaffoldDetailsActivities(ApplicationRequestFactory requestFactory,
      PlaceController<ApplicationPlace> placeController) {
    this.personActivities = new PersonActivitiesMapper(
        requestFactory, placeController); 
  }

  public Activity getActivity(ApplicationPlace place) {
    return place.acceptFilter(new BasePlaceFilter<Activity>(null) {
      public Activity filter(PersonScaffoldPlace place) {
        return personActivities.getActivity(place);
      }
    });
  }
}
