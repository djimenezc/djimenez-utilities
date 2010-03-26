package com.germinus.sample.model;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: mjimenez
 * Date: 01-ago-2007
 * Time: 10:28:04
 */

@Entity
@Table(name = "items")
public class Item {
    protected Long id;
    protected String name;
    protected String description;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 50, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 150)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return new ToStringCreator(this)
                .append("id", getId())
                .append("name", getName())
                .append("description", getDescription())
                .toString();
    }
}
