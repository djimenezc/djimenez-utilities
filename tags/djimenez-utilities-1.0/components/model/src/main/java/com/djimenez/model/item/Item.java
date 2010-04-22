package com.djimenez.model.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

import com.djimenez.model.constants.JpaConstants;

/**
 * Created by IntelliJ IDEA. User: mjimenez Date: 01-ago-2007 Time: 10:28:04
 */

@Entity
@Table(name = "items")
public class Item {

  private Long id;
  private String name;
  private String description;

  @Column(length = JpaConstants.LENGTH_DESCRIPTION)
  public final String getDescription() {
    return description;
  }

  @Id
  @GeneratedValue
  public final Long getId() {
    return id;
  }

  @Column(nullable = false, length = JpaConstants.DEFAULT_LENGTH, unique = true)
  public final String getName() {
    return name;
  }

  public final void setDescription(final String description) {
    this.description = description;
  }

  public final void setId(final Long id) {
    this.id = id;
  }

  public final void setName(final String name) {
    this.name = name;
  }

  @Override
  public final String toString() {
    return new ToStringCreator(this).append("id", getId()).append("name",
      getName()).append("description", getDescription()).toString();
  }
}
