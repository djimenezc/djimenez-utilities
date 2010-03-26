package com.djimenez.core.patterns.impl.observer;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.djimenez.core.patterns.interfaces.Notification;

/**
 * @author djimenez
 * @version 1.0
 * @since 1.0
 */
public class SimpleNotification implements Notification {

  private final String name;
  private String type = null;
  private Object body = null;

  public SimpleNotification(final String name, final Object body,
    final String type) {
    this.name = name;
    this.body = body;
    this.type = type;
  }

  @Override
  public Object getBody() {
    return this.body;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public void setBody(final Object body) {
    this.body = body;
  }

  @Override
  public void setType(final String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("name", this.name).append("type",
      this.type).append("body", this.body).toString();
  }
}
