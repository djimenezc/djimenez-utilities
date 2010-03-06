package com.djimenez.pattern.impl.mediator;

import org.apache.log4j.Logger;

import com.djimenez.pattern.impl.observer.AbstractNotifier;
import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.mvc.Mediator;

public abstract class AbstractMediator extends AbstractNotifier implements
  Mediator {

  private Facade facade;

  protected static final Logger logger =
    Logger.getLogger(AbstractMediator.class);

  private String mediatorName = null;
  private Object viewComponent = null;

  protected AbstractMediator(final Object viewComponent) {
    this();
    this.viewComponent = viewComponent;
    if (logger.isDebugEnabled()) {
      logger.debug("Initialized viewComponent " + this.viewComponent + " @ "
        + this.mediatorName);
    }
  }

  protected AbstractMediator() {

    this.mediatorName = this.getClass().getName();
    if (logger.isDebugEnabled()) {
      logger.debug("Initialized Mediator " + this.mediatorName);
    }
  }

  /**
   * @param mediatorName
   * @param viewComponent
   *          Try to use autogenerated mediator naming
   */
  protected AbstractMediator(final String mediatorName,
    final Object viewComponent) {

    this.mediatorName = mediatorName;
    this.viewComponent = viewComponent;
    if (logger.isDebugEnabled()) {
      logger.debug("Initialized Mediator " + mediatorName + " for View "
        + viewComponent);
    }
  }

  /**
   * @param mediatorName
   *          Try to use autogenerated mediator naming
   */
  protected AbstractMediator(final String mediatorName) {
    this(mediatorName, null);
  }

  @Override
  public void assignFacade(final Facade activefacade) {

    this.facade = activefacade;
  }

  @Override
  public final String getMediatorName() {
    return this.mediatorName;
  }

  @Override
  public void setViewComponent(final Object viewComponent) {
    this.viewComponent = viewComponent;
  }

  @Override
  public Object getViewComponent() {
    return this.viewComponent;
  }

}
