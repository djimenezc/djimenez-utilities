package com.djimenez.roo.gwt.gwt.scaffold.generated;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.djimenez.roo.gwt.gwt.scaffold.generated.PersonListView;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.djimenez.spring.roo.model.Person;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Person.class)
@ServerType(type = Person.class)
public interface PersonListViewBinder extends UiBinder<HTMLPanel, PersonListView> {
}
