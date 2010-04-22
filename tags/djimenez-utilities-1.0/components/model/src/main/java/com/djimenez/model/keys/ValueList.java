package com.djimenez.model.keys;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author a.pastoriza.barcia
 * @version 1.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "valueList")
public class ValueList {

  @XmlAttribute(required = true)
  private String value;

  public final String getValue() {
    return this.value;
  }

  public final void setValue(final String value) {
    this.value = value;
  }

  @Override
  public final String toString() {
    return new ToStringBuilder(this).append("value", this.value).toString();
  }

}
