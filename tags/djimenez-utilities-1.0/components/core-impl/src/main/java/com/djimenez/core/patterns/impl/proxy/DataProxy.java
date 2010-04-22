package com.djimenez.core.patterns.impl.proxy;

import com.djimenez.core.patterns.impl.observer.AbstractNotifier;
import com.djimenez.core.patterns.interfaces.Facade;
import com.djimenez.core.patterns.interfaces.Proxy;

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

    if (data != null) {
      this.proxyName = data.getClass().getName();
      this.data = data;
    }
  }

  @Override
  public final void assignFacade(final Facade proxyFacade) {
    this.setFacade(proxyFacade);
  }

  public final T getData() {
    return this.data;
  }

  @Override
  public final String getProxyName() {
    return this.proxyName;
  }

  public final void setData(final T data) {
    this.data = data;
  }

  @Override
  public final String toString() {
    return "DataProxy [data=" + this.data + ", proxyName=" + this.proxyName
      + "]";
  }

}
