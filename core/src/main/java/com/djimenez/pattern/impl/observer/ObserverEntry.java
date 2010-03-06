package com.djimenez.pattern.impl.observer;

import org.apache.log4j.Logger;

import com.djimenez.pattern.exception.ObserverEntryException;
import com.djimenez.pattern.interfaces.Notification;
import com.djimenez.pattern.interfaces.Observer;

/**
 * @author djimenez
 * @version 1.1
 * @since 1.0
 */
public class ObserverEntry {

  private static final Logger logger = Logger.getLogger(ObserverEntry.class);
  private Observer observer;
  private String notificationName;

  public ObserverEntry(final String notificationName, final Observer observer) {
    if ((notificationName != null) && (observer != null)) {
      this.observer = observer;
      this.notificationName = notificationName;
    }
    else {
      throw new ObserverEntryException(
        "Neither Notification Name nor Observer can be null");
    }
  }

  public Observer getObserver() {
    return this.observer;
  }

  public void addObserver(final Observer observerNew) {
    if (this.observer != null) {
      if (logger.isDebugEnabled()) {
        logger.debug("Overridding observer: " + this.observer + "to "
          + observerNew);
      }
      this.observer = observerNew;
    }
    else {
      throw new ObserverEntryException("Observer cannot be null");
    }
  }

  public void deleteObserver(final Observer observerDeleted) {
    if (observerDeleted != null) {
      if (this.observer.equals(observerDeleted)) {
        this.observer = null;
      }
    }
    else {
      throw new ObserverEntryException("Observer cannot be null");
    }
  }

  public void notifyObservers(final Notification notification) throws Throwable {
    if (notification != null) {
      if (this.observer != null) {
        this.observer.notifyObserver(notification);
      }
      else {
        throw new ObserverEntryException(
          "Cannot notify with a null observer the: " + notification.getName());
      }
    }
    else {
      throw new ObserverEntryException("Cannot notify with a null notification");
    }
  }

  public String getNotificationName() {
    return this.notificationName;
  }
}
