package com.germinus.sample.web;

import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ApplicationObjectSupport;

import com.germinus.sample.model.Book;

public class BookService extends ApplicationObjectSupport {

  private final SortedMap<Integer, Book> books =
    Collections.synchronizedSortedMap(new TreeMap<Integer, Book>());

  private int initBooks = -1;

  public int addBook(final Book book) {
    int key;
    synchronized (books) {
      if (books.isEmpty()) {
        key = 1;
      }
      else {
        key = books.lastKey().intValue() + 1;
      }
      final Integer keyObj = Integer.valueOf(key);
      book.setKey(keyObj);
      this.books.put(keyObj, book);
    }
    return key;
  }

  public int addBook(final String author, final String title, final int count) {
    final Book book = new Book(author, title, count);
    return addBook(book);
  }

  public int addBook(final String author, final String title,
    final Integer count) {
    final Book book = new Book(author, title, count);
    return addBook(book);
  }

  public void deleteBook(final Book book) {
    deleteBook(book.getKey());
  }

  public void deleteBook(final int key) {
    deleteBook(Integer.valueOf(key));
  }

  public void deleteBook(final Integer key) {
    synchronized (books) {
      this.books.remove(key);
    }
  }

  public SortedSet<Book> getAllBooks() {
    synchronized (books) {

      return new TreeSet<Book>(this.books.values());
    }
  }

  public Book getBook(final int key) {
    return getBook(Integer.valueOf(key));
  }

  public Book getBook(final Integer key) {
    synchronized (books) {
      return this.books.get(key);
    }
  }

  @Override
  public void initApplicationContext() throws BeansException {
    if ((initBooks < 0) || (initBooks > 0)) {
      addBook("Neal Stephenson", "Snow Crash", 50);
    }
    if ((initBooks < 0) || (initBooks > 1)) {
      addBook("William Gibson", "Neuromancer", 92);
    }
    if ((initBooks < 0) || (initBooks > 2)) {
      addBook("Bruce Bethke", "Headcrash", 12);
    }
    if ((initBooks < 0) || (initBooks > 3)) {
      addBook("Eric S. Nylund", "Signal To Noise", 44);
    }
    if ((initBooks < 0) || (initBooks > 4)) {
      addBook("Noman", "Shouldn't See This Book", 10);
    }
  }

  public void saveBook(final Book book) {
    synchronized (books) {
      this.books.put(book.getKey(), book);
    }
  }

  public void setInitBooks(final int initBooks) {
    this.initBooks = initBooks;
  }

}
