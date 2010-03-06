package com.djimenez.core.patterns.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Observer {

  boolean compareNotifyContext(Object context);

  Object getNotifyContext();

  void notifyObserver(Notification notification) throws Throwable;

  void setNotifyContext(Object context);

  void setNotifyMethod(Function notifyMethod);
}
