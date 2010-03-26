package com.djimenez.core.patterns.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Function {

  void onNotification(Notification notification) throws Throwable;
}