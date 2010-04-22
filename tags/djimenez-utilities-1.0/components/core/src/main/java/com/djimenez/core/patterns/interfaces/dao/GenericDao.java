package com.djimenez.core.patterns.interfaces.dao;

import java.io.Serializable;

/**
 * Generic DAO Pattern
 * 
 * @author djimenez
 * @param <I>
 * @param <E>
 */
public interface GenericDao<I extends Serializable, E> extends BasicDao<I, E> {

  /**
   * Method that delete a specific object in the persistent tier
   * 
   * @param entity
   */
  void remove(E entity);

  /**
   * Method that save a object information in the persistent tier
   * 
   * @param entity
   */
  void save(E entity);

}
