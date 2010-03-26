package com.djimenez.model.keys;

import javax.xml.bind.annotation.XmlRegistry;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
@XmlRegistry
public class ObjectFactory {

  public ObjectFactory() {
    // do nothing yet
  }

  public Key createKey() {
    return new Key();
  }

  public Keymapper createKeymapper() {
    return new Keymapper();
  }

  public ValueList createValueList() {
    return new ValueList();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).toString();
  }

}
