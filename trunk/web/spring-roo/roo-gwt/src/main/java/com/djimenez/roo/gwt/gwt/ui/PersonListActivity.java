package com.djimenez.roo.gwt.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.valuestore.ui.AbstractRecordListActivity;
import com.google.gwt.valuestore.ui.RecordListView;
import com.google.gwt.view.client.Range;

import com.djimenez.roo.gwt.gwt.request.PersonRecord;
import com.djimenez.roo.gwt.gwt.request.ApplicationRequestFactory;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.PersonScaffoldPlace;
import com.djimenez.roo.gwt.gwt.scaffold.generated.PersonListView;
import com.djimenez.roo.gwt.gwt.request.PersonRecordChanged;
import com.djimenez.roo.gwt.gwt.request.PersonChangedHandler;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace.Operation;

/**
 * Activity that requests and displays all {PersonRecord}
 * records.
 */
public class PersonListActivity extends
    AbstractRecordListActivity<PersonRecord> {

  private static RecordListView<PersonRecord> defaultView;

  private static RecordListView<PersonRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new PersonListView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;
  private final HandlerManager eventBus;
  private HandlerRegistration registration;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public PersonListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(eventBus, requests, getDefaultView(), placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public PersonListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests, RecordListView<PersonRecord> view,
      PlaceController<ApplicationPlace> placeController) {
    super(view);
    this.eventBus = eventBus;
    this.requests = requests;
    this.placeController = placeController;
  }

  public void createClicked() {
    placeController.goTo(new PersonScaffoldPlace("", Operation.EDIT));
  }

  public void onStop() {
    registration.removeHandler();
  }

  public void showDetails(PersonRecord record) {
    placeController.goTo(new PersonScaffoldPlace(record, Operation.DETAILS));
  }

  public void start(Display display) {
    this.registration = eventBus.addHandler(PersonRecordChanged.TYPE,
        new PersonChangedHandler() {
          public void onPersonChanged(PersonRecordChanged event) {
            update(event.getWriteOperation(), event.getRecord());
          }
        });
    super.start(display);
  }

  protected RecordListRequest<PersonRecord> createRangeRequest(Range range) {
    return requests.personRequest().findPersonEntries(range.getStart(),
        range.getLength());
  }

  protected void fireCountRequest(Receiver<Long> callback) {
    requests.personRequest().countPeople().to(callback).fire();
  }
}
