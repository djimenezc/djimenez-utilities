package com.djimenez.pattern.impl.observer;

import org.apache.log4j.Logger;

import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.Notifier;

/**
 * @author djimenez
 * @version 1.5
 * @since 1.0
 */
public abstract class AbstractNotifier implements Notifier {

  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(AbstractNotifier.class);
  protected Facade facade;

  @Override
  public void setFacade(final Facade facade) {
    this.facade = facade;
  }

  @Override
  public Facade getFacade() {
    return this.facade;
  }

  public void preNotification() {
    // hook method
  }

  public void postNotification() {
    // hook method
  }

  @Override
  public void sendNotification(final String notificationName,
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
    catch (final Throwable throwable) {
      this.facade.processException(throwable);
    }
  }
}
