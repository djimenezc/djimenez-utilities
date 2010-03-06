package com.djimenez.pattern.impl.observer;

import com.djimenez.pattern.interfaces.Event;
import com.djimenez.pattern.interfaces.EventInterceptor;
import com.djimenez.pattern.interfaces.Facade;

public abstract class AbstractEventInterceptor implements EventInterceptor {

  protected String name;
  protected Facade facade;

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public void setFacade(final Facade facade) {
    this.facade = facade;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void dispatchInterceptedEvent(final Event event) {
    this.facade.dispatchEvent(event);
  }
}
