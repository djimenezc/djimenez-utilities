package com.djimenez.model.event;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

/**
 * Created by IntelliJ IDEA. User: mjimenez Date: 01-ago-2007 Time: 10:28:04
 */

@Entity
@Table(name = "events")
public class Event {

  protected Long id;
  protected String name;
  protected String description;
  private Date date;

  /**
   * @return the date
   */
  @Column
  public Date getDate() {
    return date;
  }

  @Column(length = 150)
  public String getDescription() {
    return description;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  @Column(nullable = false, length = 50, unique = true)
  public String getName() {
    return name;
  }

  /**
   * @param date
   *          the date to set
   */
  public void setDate(final Date date) {
    this.date = date;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this).append("id", getId()).append("name",
      getName()).append("description", getDescription()).toString();
  }
}
