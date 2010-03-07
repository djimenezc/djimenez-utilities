package com.djimenez.core.patterns.interfaces.visitor;

/**
 * @param <T>
 *          Template Object
 */
public interface Visitable<T extends Visitor> {

  /**
   * @param visitor
   */
  void accept(T visitor);
}
