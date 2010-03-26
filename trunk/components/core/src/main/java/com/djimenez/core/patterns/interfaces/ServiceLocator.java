package com.djimenez.core.patterns.interfaces;

/**
 * ServiceLocator implements and encapsulates service and component lookup.
 * ServiceLocator hides the implementation details of the lookup mechanism and
 * encapsulates related dependencies.
 * 
 * @author djimenez
 * @version 1.0
 */
public interface ServiceLocator {

  Object getBean(final String name);

  Object getService(final String serviceName);
}
