package com.djimenez.model.keys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author a.pastoriza.barcia
 * @version 1.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "valueList" })
@XmlRootElement(name = "key")
public class Key implements Serializable {

  private static final long serialVersionUID = 1L;

  protected List<ValueList> valueList;

  @XmlAttribute(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "NMTOKEN")
  protected String code;

  @XmlAttribute(required = true)
  protected int id;

  public String getCode() {
    return this.code;
  }

  public int getId() {
    return this.id;
  }

  public List<ValueList> getValueList() {
    if (this.valueList == null) {
      this.valueList = new ArrayList<ValueList>();
    }
    return this.valueList;
  }

  public boolean isEchoable() {
    return ((this.valueList != null) && (this.valueList.size() > 0));
  }

  public void setCode(final String value) {
    this.code = value;
  }

  public void setId(final int value) {
    this.id = value;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("id", this.id).append("valueList",
      this.valueList).append("code", this.code).toString();
  }

}
