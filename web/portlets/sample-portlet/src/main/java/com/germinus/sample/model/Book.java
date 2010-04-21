package com.germinus.sample.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Comparable<Object>, Serializable {

  private static final long serialVersionUID = 1L;

  private Integer key;
  private String author;
  private String title;
  private String description;
  private Date availability;
  private Integer count;

  private int hashCode = Integer.MIN_VALUE;

  public Book() {
    super();
  }

  public Book(final String author, final String title, final int count) {
    this(author, title, Integer.valueOf(count));
  }

  public Book(final String author, final String title, final Integer count) {
    super();
    setAuthor(author);
    setTitle(title);
    setCount(count);
  }

  public final int compareTo(final Object obj) {
    if (obj == null) {
      throw new NullPointerException("Cannot compare to null object");
    }
    if (!(obj instanceof Book)) {
      throw new ClassCastException("Can only compare to class"
        + this.getClass().getName());
    }
    if ((this.author == null) || (this.title == null)) {
      throw new NullPointerException("This object is not initialized yet");
    }
    if (this.equals(obj)) {
      return 0;
    }
    final Book book = (Book) obj;
    final int res = getAuthor().compareTo(book.getAuthor());
    if (res != 0) {
      return res;
    }
    return getTitle().compareTo(book.getTitle());
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Book)) {
      return false;
    }
    if ((this.author == null) || (this.title == null)) {
      return false;
    }
    final Book book = (Book) obj;
    return (this.author.equals(book.getAuthor()) && this.title.equals(book
      .getTitle()));
  }

  public final synchronized String getAuthor() {
    return author;
  }

  public final Date getAvailability() {
    return availability;
  }

  public final synchronized Integer getCount() {
    return count;
  }

  public final synchronized String getDescription() {
    return description;
  }

  public final synchronized Integer getKey() {
    return key;
  }

  public final synchronized String getTitle() {
    return title;
  }

  @Override
  public final int hashCode() {
    if (Integer.MIN_VALUE == this.hashCode) {
      final String hashStr = this.getClass().getName() + ":" + this.toString();
      this.hashCode = hashStr.hashCode();
    }
    return this.hashCode;
  }

  public final synchronized void incrementCount(final Integer increment) {

    int countAux = this.count.intValue() + increment.intValue();

    if (countAux < 0) {

      countAux = 0;
    }
    this.count = Integer.valueOf(countAux);
  }

  public final synchronized void setAuthor(final String author) {

    if (author == null) {
      throw new NullPointerException("author may not be null");
    }
    this.author = author;
    this.hashCode = Integer.MIN_VALUE;
  }

  public final void setAvailability(final Date availability) {

    this.availability = availability;
  }

  public final synchronized void setCount(final Integer count) {

    this.count = count;
  }

  public final synchronized void setDescription(final String description) {
    this.description = description;
  }

  public final synchronized void setKey(final Integer key) {
    this.key = key;
  }

  public final synchronized void setTitle(final String title) {
    if (title == null) {
      throw new NullPointerException("title may not be null");
    }
    this.title = title;
    this.hashCode = Integer.MIN_VALUE;
  }

  @Override
  public final String toString() {
    return this.author + ":" + this.title;
  }
}