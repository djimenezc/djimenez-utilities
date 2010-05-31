package com.djimenez.roo.gwt.gwt.ui;

import com.google.gwt.app.place.AbstractActivity;
import com.google.gwt.app.place.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.SyncResult;
import com.google.gwt.valuestore.shared.DeltaValueStore;
import com.google.gwt.valuestore.shared.Value;
import com.google.gwt.valuestore.ui.RecordDetailsView;
import com.djimenez.roo.gwt.gwt.request.PersonRecord;
import com.djimenez.roo.gwt.gwt.request.ApplicationRequestFactory;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationListPlace;
import com.djimenez.roo.gwt.gwt.scaffold.place.PersonScaffoldPlace;
import com.djimenez.roo.gwt.gwt.scaffold.generated.PersonDetailsView;
import com.djimenez.roo.gwt.gwt.scaffold.place.ApplicationRecordPlace.Operation;

import java.util.Set;

/**
 * An {@link com.google.gwt.app.place.Activity Activity} that requests and
 * displays detailed information on a given Person.
 */
public class PersonDetailsActivity extends AbstractActivity implements
    RecordDetailsView.Delegate {
  private static RecordDetailsView<PersonRecord> defaultView;

  private static RecordDetailsView<PersonRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new PersonDetailsView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;
  private final RecordDetailsView<PersonRecord> view;
  private String id;
  private Display display;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public PersonDetailsActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(id, requests, placeController, getDefaultView());
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public PersonDetailsActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController,
      RecordDetailsView<PersonRecord> view) {
    this.placeController = placeController;
    this.id = id;
    this.requests = requests;
    view.setDelegate(this);
    this.view = view;
  }

  public void deleteClicked() {
    if (!view.confirm("Really delete this record? You cannot undo this change.")) {
      return;
    }
    
    DeltaValueStore deltas = requests.getValueStore().spawnDeltaView();
    deltas.delete(view.getValue());
    requests.syncRequest(deltas).to(new Receiver<Set<SyncResult>>() {

      public void onSuccess(Set<SyncResult> response) {
        if (display == null) {
          // This activity is dead
          return;
        }
        
        display.showActivityWidget(null);
      }
    }).fire();
  }

  public void editClicked() {
    placeController.goTo(new PersonScaffoldPlace(view.getValue(),
        Operation.EDIT));
  }

  public void onCancel() {
    onStop();
  }

  public void onStop() {
    display = null;
  }

  public void start(final Display display) {
    this.display = display;
    Receiver<PersonRecord> callback = new Receiver<PersonRecord>() {
      public void onSuccess(PersonRecord record) {
        view.setValue(record);
        display.showActivityWidget(view);
      }
    };

    requests.personRequest().findPerson(Value.of(id)).to(callback).fire();
  }
}
