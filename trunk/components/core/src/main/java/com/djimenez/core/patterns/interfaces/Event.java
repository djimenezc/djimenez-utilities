package com.djimenez.core.patterns.interfaces;

/**
 * <p>
 * The interface for an action that is usually initiated outside the scope of
 * internal logic.
 * </p>
 * <p>
 * Typically events are handled synchronous with the program flow, that is, the
 * program has one or more dedicated places where events are handled.
 * </p>
 * 
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Event {

  Object getBody();

  String getName();

  Object getSource();

  String getType();

  long getWhen();
}
