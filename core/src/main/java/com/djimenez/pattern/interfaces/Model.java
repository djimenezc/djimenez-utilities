package com.djimenez.pattern.interfaces;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public interface Model {

  void registerProxy(Proxy proxy);

  Proxy retrieveProxy(String proxy);

  Proxy removeProxy(String proxy);

  void removeAllProxies();
}
