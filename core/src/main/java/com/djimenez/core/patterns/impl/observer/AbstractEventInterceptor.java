package com.djimenez.core.patterns.impl.observer;

import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.EventInterceptor;
import com.djimenez.core.patterns.interfaces.Facade;

public abstract class AbstractEventInterceptor implements EventInterceptor {

  protected String name;
  protected Facade facade;

  @Override
  public void dispatchInterceptedEvent(final Event event) {
    this.facade.dispatchEvent(event);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setFacade(final Facade facade) {
    this.facade = facade;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
