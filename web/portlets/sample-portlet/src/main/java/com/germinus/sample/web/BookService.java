package com.germinus.sample.web;

import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.context.support.ApplicationObjectSupport;

import com.djimenez.model.DefaultValues;
import com.germinus.sample.model.Book;

public class BookService extends ApplicationObjectSupport {

  private final SortedMap<Integer, Book> books =
    Collections.synchronizedSortedMap(new TreeMap<Integer, Book>());

  private int initBooks = -1;

  public final int addBook(final Book book) {
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

  public final int addBook(final String author, final String title,
    final int count) {
    final Book book = new Book(author, title, count);
    return addBook(book);
  }

  public final int addBook(final String author, final String title,
    final Integer count) {
    final Book book = new Book(author, title, count);
    return addBook(book);
  }

  public final void deleteBook(final Book book) {
    deleteBook(book.getKey());
  }

  public final void deleteBook(final int key) {
    deleteBook(Integer.valueOf(key));
  }

  public final void deleteBook(final Integer key) {
    synchronized (books) {
      this.books.remove(key);
    }
  }

  /**
   * 
   */
  private void fillBooksPart1() {

    if ((initBooks < DefaultValues.ZERO_INT)
      || (initBooks > DefaultValues.ZERO_INT)) {
      final int count = 50;
      addBook("Neal Stephenson", "Snow Crash", count);
    }

    final int i = 1;
    if ((initBooks < DefaultValues.ZERO_INT) || (initBooks > i)) {
      final int count = 92;
      addBook("William Gibson", "Neuromancer", count);
    }

    final int j = 2;
    if ((initBooks < DefaultValues.ZERO_INT) || (initBooks > j)) {
      final int count = 12;
      addBook("Bruce Bethke", "Headcrash", count);
    }
  }

  /**
   * 
   */
  private void fillBooksPart2() {

    final int j2 = 3;

    if ((initBooks < DefaultValues.ZERO_INT) || (initBooks > j2)) {
      final int count = 44;
      addBook("Eric S. Nylund", "Signal To Noise", count);
    }

    final int k = 4;
    if ((initBooks < DefaultValues.ZERO_INT) || (initBooks > k)) {
      final int count = 10;
      addBook("Noman", "Shouldn't See This Book", count);
    }
  }

  public final SortedSet<Book> getAllBooks() {
    synchronized (books) {

      return new TreeSet<Book>(this.books.values());
    }
  }

  public final Book getBook(final int key) {
    return getBook(Integer.valueOf(key));
  }

  public final Book getBook(final Integer key) {
    synchronized (books) {
      return this.books.get(key);
    }
  }

  @Override
  public final void initApplicationContext() {

    fillBooksPart1();

    fillBooksPart2();
  }

  public final void saveBook(final Book book) {
    synchronized (books) {
      this.books.put(book.getKey(), book);
    }
  }

  public final void setInitBooks(final int initBooks) {
    this.initBooks = initBooks;
  }

}
