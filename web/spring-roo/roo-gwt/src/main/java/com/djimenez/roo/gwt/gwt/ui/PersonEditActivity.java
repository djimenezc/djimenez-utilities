package com.djimenez.roo.gwt.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.valuestore.shared.Value;
import com.google.gwt.valuestore.ui.AbstractRecordEditActivity;
import com.google.gwt.valuestore.ui.RecordEditView;
import com.djimenez.roo.gwt.gwt.request.PersonRecord;
import com.djimenez.roo.gwt.gwt.request.ApplicationRequestFactory;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationListPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.PersonScaffoldPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace;
import com.djimenez.roo.gwt.gwt.scaffold.generated.PersonEditView;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace.Operation;


/**
 * An activity that requests all info on an Person, allows the user to edit
 * it, and persists the results.
 */
public class PersonEditActivity extends
    AbstractRecordEditActivity<PersonRecord> {
  private static RecordEditView<PersonRecord> defaultView;

  private static RecordEditView<PersonRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new PersonEditView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public PersonEditActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(id, getDefaultView(), requests, placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public PersonEditActivity(String id, RecordEditView<PersonRecord> view,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    super(view, id, requests);
    this.requests = requests;
    this.placeController = placeController;
  }


  protected void exit() {
    placeController.goTo(new PersonScaffoldPlace(getId(), Operation.DETAILS));
  }

  protected void fireFindRequest(Value<String> id,
      Receiver<PersonRecord> callback) {
    requests.personRequest().findPerson(id).to(callback).fire();
  }

  protected String getRecordToken() {
    return PersonRecord.TOKEN;
  }
}
