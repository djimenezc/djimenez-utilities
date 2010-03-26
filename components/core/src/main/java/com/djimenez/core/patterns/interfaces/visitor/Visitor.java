package com.djimenez.core.patterns.interfaces.visitor;

/**
 * Interface generic to visitors
 */
public interface Visitor {

  /**
   * Execute after visit.
   */
  void endVisit();

  /**
   * Execute before visit.
   */
  void startVisit();

}
