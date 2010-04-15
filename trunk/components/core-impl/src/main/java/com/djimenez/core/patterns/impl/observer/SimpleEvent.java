package com.djimenez.core.patterns.impl.observer;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.djimenez.core.patterns.interfaces.Event;

public class SimpleEvent implements Event {

  private final String name;
  private final Object body;
  private final Object source;
  private final String type;
  private final long when;

  public SimpleEvent(final String name, final Object body, final String type) {
    this(name, body, type, null, System.currentTimeMillis());
  }

  public SimpleEvent(final String name, final Object body, final String type,
    final long when) {
    this(name, body, type, null, when);
  }

  public SimpleEvent(final String name, final Object body, final String type,
    final Object source) {
    this(name, body, type, source, System.currentTimeMillis());
  }

  public SimpleEvent(final String name, final Object body, final String type,
    final Object source, final long when) {
    this.name = name;
    this.body = body;
    this.type = type;
    this.source = source;
    this.when = when;
  }

  @Override
  public final Object getBody() {
    return this.body;
  }

  @Override
  public final String getName() {
    return this.name;
  }

  @Override
  public final Object getSource() {
    return this.source;
  }

  @Override
  public final String getType() {
    return this.type;
  }

  @Override
  public final long getWhen() {
    return this.when;
  }

  @Override
  public final String toString() {

    return new ToStringBuilder(this).append("body", this.body).append("source",
      this.source).append("when", this.when).append("name", this.name).append(
      "type", this.type).toString();
  }

}
