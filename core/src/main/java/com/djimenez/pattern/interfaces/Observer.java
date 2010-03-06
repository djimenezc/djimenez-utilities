package com.djimenez.pattern.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Observer {

  void setNotifyMethod(Function notifyMethod);

  void setNotifyContext(Object context);

  void notifyObserver(Notification notification) throws Throwable;

  boolean compareNotifyContext(Object context);

  Object getNotifyContext();
}
