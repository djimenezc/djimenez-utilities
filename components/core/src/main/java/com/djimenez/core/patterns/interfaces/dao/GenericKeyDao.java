package com.djimenez.core.patterns.interfaces.dao;

import java.io.Serializable;

public interface GenericKeyDao<I extends Serializable, E> extends
  BasicDao<I, E> {

  /**
   * Method that delete a specific object in the persistent tier
   * 
   * @param entity
   * @param id
   */
  void remove(E entity, I id);

  /**
   * Method that save a object information in the persistent tier
   * 
   * @param entity
   * @param id
   */
  void save(E entity, I id);
}
