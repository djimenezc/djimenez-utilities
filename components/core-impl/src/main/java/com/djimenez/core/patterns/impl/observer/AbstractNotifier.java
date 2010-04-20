package com.djimenez.core.patterns.impl.observer;

import org.apache.log4j.Logger;

import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.Notifier;

/**
 * @author djimenez
 * @version 1.5
 * @since 1.0
 */
public abstract class AbstractNotifier implements Notifier {

  /**
   * Logger for this class
   */
  private static Logger logger = Logger.getLogger(AbstractNotifier.class);

  private Facade facade;

  @Override
  public final Facade getFacade() {
    return this.facade;
  }

  public void postNotification() {
    // hook method
  }

  public void preNotification() {
    // hook method
  }

  @Override
  public final void sendNotification(final String notificationName,
    final Object body, final String type) {
    if (logger.isDebugEnabled()) {
      logger.debug("From: " + this.getClass().getSimpleName());
      logger.debug("Subject: Sending notification " + notificationName);
      logger.debug("Body: " + body);
      logger.debug("Type: " + type);
    }
    else {
      logger.info("Sending notification " + notificationName);
    }

    try {
      this.preNotification();
      this.facade.sendNotification(notificationName, body, type);
      this.postNotification();
    }
    catch (final Exception exception) {
      this.facade.processException(exception);
    }
  }

  @Override
  public final void setFacade(final Facade facade) {
    this.facade = facade;
  }
}
