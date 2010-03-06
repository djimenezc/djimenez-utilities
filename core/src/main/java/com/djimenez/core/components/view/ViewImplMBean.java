package com.djimenez.core.components.view;

import java.util.Map;

/**
 * @author djimenez
 */
public interface ViewImplMBean {

  Map<String, String> getMediatorMap();

  Map<String, String> getObserverMap();
}
