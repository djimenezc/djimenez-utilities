package com.djimenez.core.components.model;

import java.util.HashMap;
import java.util.Map;

import com.djimenez.core.patterns.interfaces.Model;
import com.djimenez.core.patterns.interfaces.Proxy;

/**
 * @author djimenez
 * @version 1.1
 */
public final class ModelImpl implements Model {

  private static Model instance;
  public static Model getInstance() {
    if (instance == null) {
      instance = new ModelImpl();
    }
    return instance;
  }

  private final Map<String, Proxy> proxyMap;

  private ModelImpl() {
    this.proxyMap = new HashMap<String, Proxy>();
  }

  @Override
  public void registerProxy(final Proxy proxy) {
    this.proxyMap.put(proxy.getProxyName(), proxy);
  }

  @Override
  public void removeAllProxies() {
    this.proxyMap.clear();
  }

  @Override
  public Proxy removeProxy(final String proxy) {
    return this.proxyMap.remove(proxy);
  }

  @Override
  public Proxy retrieveProxy(final String proxy) {
    return this.proxyMap.get(proxy);
  }
}
