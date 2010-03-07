package com.djimenez.core.patterns.interfaces.dao;

import java.io.Serializable;
import java.util.Collection;

public interface BasicDao<I extends Serializable, E> {

  /**
   * Method that return a object from persistent tier by the field id
   * 
   * @param id
   * @return
   */
  E findById(I id);

  /**
   * Method that return the all objects of the parameterizable type-
   * 
   * @return
   */
  Collection<E> loadAll();

}
