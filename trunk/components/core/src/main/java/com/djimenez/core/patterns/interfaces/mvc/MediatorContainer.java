package com.djimenez.core.patterns.interfaces.mvc;

import java.util.Collection;

import org.apache.log4j.Logger;


/**
 * @author djimenez
 */
public class MediatorContainer {

  private static final Logger logger =
    Logger.getLogger(MediatorContainer.class);

  private Collection<Mediator> mediatorCollection;

  public MediatorContainer() {
  }

  public Collection<Mediator> getMediatorCollection() {
    return mediatorCollection;
  }

  public void setMediatorCollection(
    final Collection<Mediator> mediatorCollection) {
    this.mediatorCollection = mediatorCollection;

    if (logger.isDebugEnabled()) {
      logger.debug("Added " + mediatorCollection.size() + "mediator(s)");
      logger.debug("Detail as follows: ");
      for (final Mediator mediator : mediatorCollection) {
        logger.debug("[MEDIATOR] " + mediator.getMediatorName());
      }
    }

  }

  @Override
  public String toString() {
    return "MediatorContainer [" + "mediatorCollection " + mediatorCollection
      + "]";
  }
}
