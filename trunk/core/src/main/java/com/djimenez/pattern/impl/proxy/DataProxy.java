package com.djimenez.pattern.impl.proxy;

import com.djimenez.pattern.impl.observer.AbstractNotifier;
import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.Proxy;

public class DataProxy<T> extends AbstractNotifier implements Proxy {

  // the proxy name
  private String proxyName = "DataProxy";

  // the data object
  private T data = null;

  /**
   * Try to use DataProxy(final T data) as a constructor. Useful when
   * registering simple types such as long or wish a different name for the
   * proxy
   * 
   * @param proxyName
   * @param data
   */
  public DataProxy(final String proxyName, final T data) {
    if (proxyName != null) {
      this.proxyName = proxyName;
    }
    if (data != null) {
      this.data = data;
    }
  }

  /**
   * Common constructor.
   */
  public DataProxy(final T data) {
    this.proxyName = data.getClass().getName();
    if (data != null) {
      this.data = data;
    }
  }

  @Override
  public void assignFacade(final Facade proxyFacade) {
    this.setFacade(proxyFacade);
  }

  @Override
  public String getProxyName() {
    return this.proxyName;
  }

  public void setData(final T data) {
    this.data = data;
  }

  public T getData() {
    return this.data;
  }

  @Override
  public String toString() {
    return "DataProxy [data=" + this.data + ", proxyName=" + this.proxyName
      + "]";
  }

}
