/*
 * Copyright 2005 Joe Walker Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.germinus.sample.model;

import org.directwebremoting.Security;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Person {

  private String name;

  private String address;

  private float salary;

  private int id;

  /*
   * (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj == this) {
      return true;
    }

    if (!this.getClass().equals(obj.getClass())) {
      return false;
    }

    final Person that = (Person) obj;

    if (this.id != that.id) {
      return false;
    }

    return true;
  }

  /**
   * @return the address
   */
  public final String getAddress() {
    return address;
  }

  /**
   * @return the id
   */
  public final int getId() {
    return id;
  }

  /**
   * @return the name
   */
  public final String getName() {
    return name;
  }

  /**
   * @return the salary
   */
  public final float getSalary() {
    return salary;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public final int hashCode() {
    final int i = 5924;
    return i + id;
  }

  /**
   * @param address
   *          the address to set
   */
  public final void setAddress(final String address) {
    this.address = Security.escapeHtml(address);
  }

  /**
   * @param id
   *          the id to set
   */
  public final void setId(final int id) {
    this.id = id;
  }

  /**
   * @param name
   *          the name to set
   */
  public final void setName(final String name) {
    this.name = Security.escapeHtml(name);
  }

  /**
   * @param salary
   *          the salary to set
   */
  public final void setSalary(final float salary) {
    this.salary = salary;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public final String toString() {
    return "Person[id=" + id + ",name=" + name + "]";
  }
}
