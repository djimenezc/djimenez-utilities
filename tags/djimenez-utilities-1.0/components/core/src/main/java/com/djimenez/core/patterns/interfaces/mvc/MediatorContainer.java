package com.djimenez.core.patterns.interfaces.mvc;

import java.util.Collection;

import org.apache.log4j.Logger;

/**
 * @author djimenez
 */
public class MediatorContainer {

  private static final Logger LOG = Logger.getLogger(MediatorContainer.class);

  private Collection<Mediator> mediatorCollection;

  public final Collection<Mediator> getMediatorCollection() {
    return mediatorCollection;
  }

  public final void setMediatorCollection(
    final Collection<Mediator> mediatorCollection) {
    this.mediatorCollection = mediatorCollection;

    if (LOG.isDebugEnabled()) {
      LOG.debug("Added " + mediatorCollection.size() + "mediator(s)");
      LOG.debug("Detail as follows: ");
      for (final Mediator mediator : mediatorCollection) {
        LOG.debug("[MEDIATOR] " + mediator.getMediatorName());
      }
    }

  }

  @Override
  public final String toString() {
    return "MediatorContainer [" + "mediatorCollection " + mediatorCollection
      + "]";
  }
}
