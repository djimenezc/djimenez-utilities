package com.djimenez.core.patterns.impl.observer;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.djimenez.core.patterns.interfaces.Function;
import com.djimenez.core.patterns.interfaces.Notification;
import com.djimenez.core.patterns.interfaces.Observer;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public class ObserverImpl implements Observer {

  private Object context;
  private Function notify;

  public ObserverImpl(final Function notify, final Object context) {
    this.context = context;
    this.notify = notify;
  }

  @Override
  public final boolean compareNotifyContext(final Object contextObject) {
    return this.context.equals(contextObject);
  }

  @Override
  public final boolean equals(final Object object) {
    boolean eval = false;
    if (object instanceof ObserverImpl) {
      final ObserverImpl rhs = (ObserverImpl) object;
      eval = new EqualsBuilder().append(this.context, rhs.context).isEquals();
    }
    return eval;
  }

  @Override
  public final Object getNotifyContext() {
    return this.context;
  }

  public final Function getNotifyMethod() {
    return this.notify;
  }

  @Override
  public final int hashCode() {
    return super.hashCode();
  }

  @Override
  public final void notifyObserver(final Notification notification) {

    this.getNotifyMethod().onNotification(notification);
  }

  @Override
  public final void setNotifyContext(final Object context) {
    this.context = context;
  }

  @Override
  public final void setNotifyMethod(final Function notifyMethod) {
    this.notify = notifyMethod;
  }

  @Override
  public final String toString() {
    return new ToStringBuilder(this).append("notifyContext",
      this.getNotifyContext()).append("notifyMethod", this.getNotifyMethod())
      .toString();
  }
}
