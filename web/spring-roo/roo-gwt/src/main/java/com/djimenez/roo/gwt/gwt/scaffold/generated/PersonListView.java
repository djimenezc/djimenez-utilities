package com.djimenez.roo.gwt.gwt.scaffold.generated;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.valuestore.ui.AbstractRecordListView;
import com.google.gwt.valuestore.ui.PropertyColumn;
import com.google.gwt.app.util.DateTimeFormatRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.app.util.Renderer;
import com.djimenez.roo.gwt.gwt.request.PersonRecord;

import java.util.ArrayList;
import java.util.List;


/**
 * {@link AbstractRecordListView} specialized to {@link PersonKey}} values.
 */
public class PersonListView extends AbstractRecordListView<PersonRecord> {
  interface Binder extends UiBinder<HTMLPanel, PersonListView> {
  }

  private static final Binder BINDER = GWT.create(Binder.class);

  @UiField CellTable<PersonRecord> table;
  @UiField Button newButton;
  
  public PersonListView() {
    init(BINDER.createAndBindUi(this), table, newButton, getColumns());
  }

  protected List<PropertyColumn<PersonRecord, ?>> getColumns() {
    // TODO These should be <g:col> elements in a <g:table> in the ui.xml file

    List<PropertyColumn<PersonRecord, ?>> columns = new ArrayList<PropertyColumn<PersonRecord, ?>>();
    columns.add(new PropertyColumn<PersonRecord, java.lang.String>(PersonRecord.name, new Renderer<java.lang.String>() {
      public String render(java.lang.String obj) {
        return String.valueOf(obj);
      }    
}));  
    return columns;
  }
}
