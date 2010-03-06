package com.djimenez.pattern.interfaces;

public interface EventListener {

  /**
   * Manage events
   * 
   * @param event
   *          The event generated
   */
  void onEvent(Event event);

}
