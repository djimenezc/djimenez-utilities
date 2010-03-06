package com.djimenez.pattern.core.model;

import java.util.HashMap;
import java.util.Map;

import com.djimenez.pattern.interfaces.Model;
import com.djimenez.pattern.interfaces.Proxy;

/**
 * @author djimenez
 * @version 1.1
 */
public final class ModelImpl implements Model {

  private static Model instance;
  private final Map<String, Proxy> proxyMap;

  private ModelImpl() {
    this.proxyMap = new HashMap<String, Proxy>();
  }

  public static Model getInstance() {
    if (instance == null) {
      instance = new ModelImpl();
    }
    return instance;
  }

  @Override
  public void registerProxy(final Proxy proxy) {
    this.proxyMap.put(proxy.getProxyName(), proxy);
  }

  @Override
  public Proxy removeProxy(final String proxy) {
    return this.proxyMap.remove(proxy);
  }

  @Override
  public Proxy retrieveProxy(final String proxy) {
    return this.proxyMap.get(proxy);
  }

  @Override
  public void removeAllProxies() {
    this.proxyMap.clear();
  }
}
