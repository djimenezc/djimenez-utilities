package com.djimenez.roo.gwt.gwt.ui;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.djimenez.roo.gwt.gwt.request.PersonRecord;
import com.djimenez.roo.gwt.gwt.scaffold.place.PersonScaffoldPlace;
import com.djimenez.roo.gwt.gwt.ui.PersonDetailsActivity;
import com.djimenez.roo.gwt.gwt.ui.PersonEditActivity;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.roo.gwt.gwt.request.ApplicationRequestFactory;

/**
 * Maps {@link ${entity.detailsPlace} instances to the {@link Activity} to run.
 */
public class PersonActivitiesMapper implements
    ActivityMapper<PersonScaffoldPlace> {
  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  public PersonActivitiesMapper(ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this.requests = requests;
    this.placeController = placeController;
  }

  public Activity getActivity(PersonScaffoldPlace place) {
    switch (place.getOperation()) {
      case DETAILS:
        return new PersonDetailsActivity(place.getId(), requests, placeController);

      case EDIT:
        return new PersonEditActivity(place.getId(), requests,
            placeController);
    }

    throw new IllegalArgumentException("Unknown operation "
        + place.getOperation());
  }
}
