package com.djimenez.core.patterns.impl.observer;

import com.djimenez.core.patterns.interfaces.Event;
import com.djimenez.core.patterns.interfaces.EventInterceptor;
import com.djimenez.core.patterns.interfaces.Facade;

public abstract class AbstractEventInterceptor implements EventInterceptor {

  private String name;
  private Facade facade;

  @Override
  public final void dispatchInterceptedEvent(final Event event) {
    this.facade.dispatchEvent(event);
  }

  @Override
  public final String getName() {
    return this.name;
  }

  @Override
  public final void setFacade(final Facade facade) {
    this.facade = facade;
  }

  public final void setName(final String name) {
    this.name = name;
  }
}
