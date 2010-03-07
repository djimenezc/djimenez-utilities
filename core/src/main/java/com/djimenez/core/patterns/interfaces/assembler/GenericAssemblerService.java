package com.djimenez.core.patterns.interfaces.assembler;

import java.io.Serializable;
import java.util.List;

public interface GenericAssemblerService<I extends Serializable, E> {

  void delete(E entity);

  List<E> getAll();

  E getById(I id);

  void persist(E entity);
}
