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

    private SortedMap books = Collections.synchronizedSortedMap(new TreeMap());

    private int initBooks = -1;
    
	public void initApplicationContext() throws BeansException {
        if (initBooks < 0 || initBooks > 0)
            addBook("Neal Stephenson", "Snow Crash", 50);
        if (initBooks < 0 || initBooks > 1)
            addBook("William Gibson", "Neuromancer", 92);
        if (initBooks < 0 || initBooks > 2)
            addBook("Bruce Bethke", "Headcrash", 12);
        if (initBooks < 0 || initBooks > 3)
            addBook("Eric S. Nylund", "Signal To Noise", 44);
        if (initBooks < 0 || initBooks > 4)
            addBook("Noman", "Shouldn't See This Book", 10);
	}

    public Book getBook (Integer key) {
        synchronized (books) {
            return (Book)this.books.get(key);
        }
    }
    
    public Book getBook (int key) {
        return getBook(new Integer(key));
    }
    
    public SortedSet getAllBooks () {
        synchronized (books) {
            return (SortedSet) new TreeSet(this.books.values());
        }
    }
    
    public int addBook (Book book) {
        int key;
        synchronized (books) {
            if (books.isEmpty()) key = 1;
            else key = ((Integer)books.lastKey()).intValue() + 1;
            Integer keyObj = new Integer(key);
            book.setKey(keyObj);
            this.books.put(keyObj, book);
        }
        return key;
    }

    public int addBook (String author, String title, Integer count) {
        Book book = new Book(author, title, count);
        return addBook(book);
    }

    public int addBook (String author, String title, int count) {
        Book book = new Book(author, title, count);
        return addBook(book);
    }

    public void saveBook (Book book) {
        synchronized (books) {
            this.books.put(book.getKey(),book);
        }
    }

    public void deleteBook (Integer key) {
        synchronized (books) {
            this.books.remove(key);
        }
    }

    public void deleteBook (Book book) {
        deleteBook(book.getKey());
    }

    public void deleteBook (int key) {
        deleteBook(new Integer(key));
    }

    public void setInitBooks(int initBooks) {
        this.initBooks = initBooks;
    }
    
}
