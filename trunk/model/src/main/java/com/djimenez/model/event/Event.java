package com.djimenez.model.event;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "events")
public class Event {

  private Long id;

  private String title;

  private Date date;

  public Event() {
  }

  public Date getDate() {
    return date;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  @Column(nullable = false, length = 20, unique = true)
  public String getTitle() {
    return title;
  }

  public void setDate(final Date date) {
    this.date = date;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this).append("id", getId()).append("title",
      getTitle()).append("date", getDate()).toString();
  }
}