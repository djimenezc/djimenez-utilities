package com.djimenez.model.keys;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author a.pastoriza.barcia
 * @version 1.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "key" })
@XmlRootElement(name = "keymapper")
public class Keymapper {

  @XmlElement(required = true)
  private List<Key> key;

  public final List<Key> getKey() {
    if (this.key == null) {
      this.key = new ArrayList<Key>();
    }
    return this.key;
  }

  @Override
  public final String toString() {
    return new ToStringBuilder(this).append("key", this.key).toString();
  }

}
