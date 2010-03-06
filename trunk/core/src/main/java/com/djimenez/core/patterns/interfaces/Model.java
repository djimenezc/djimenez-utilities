package com.djimenez.core.patterns.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Model {

  void registerProxy(Proxy proxy);

  void removeAllProxies();

  Proxy removeProxy(String proxy);

  Proxy retrieveProxy(String proxy);
}
