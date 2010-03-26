package com.germinus.sample.model;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Date;

public class Book implements Comparable, Serializable {

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
    
	public Book(String author, String title, Integer count) {
        super();
        setAuthor(author);
        setTitle(title);
        setCount(count);
    }
    
    public Book(String author, String title, int count) {
        this(author, title, new Integer(count));
    }
    
    public synchronized String getAuthor() {
        return author;
    }

    public synchronized void setAuthor(String author) {
        if (author == null) throw new NullPointerException("author may not be null");
        this.author = author;
        this.hashCode = Integer.MIN_VALUE;
    }

    public synchronized String getTitle() {
        return title;
    }

    public synchronized void setTitle(String title) {
        if (title == null) throw new NullPointerException("title may not be null");
        this.title = title;
        this.hashCode = Integer.MIN_VALUE;
    }

    public synchronized String getDescription() {
        return description;
    }

    public synchronized void setDescription(String description) {
        this.description = description;
    }

    public Date getAvailability() {
        return availability;
    }
    
    public void setAvailability(Date availability) {
        this.availability = availability;
    }
    
    public synchronized Integer getCount() {
        return count;
    }

    public synchronized void setCount(Integer count) {
        this.count = count;
    }

    public synchronized Integer getKey() {
        return key;
    }

    public synchronized void setKey(Integer key) {
        this.key = key;
    }

    public synchronized void incrementCount(Integer increment) {
        int count = this.count.intValue() + increment.intValue();
        if (count < 0) count = 0;
        this.count = new Integer(count);
    }

    public int compareTo(Object obj) {
        if (obj == null) throw new NullPointerException("Cannot compare to null object");
        if (!(obj instanceof Book)) throw new ClassCastException("Can only compare to class" + this.getClass().getName());
        if (this.author == null || this.title == null) throw new NullPointerException("This object is not initialized yet");
        if (this.equals(obj)) return 0;
        Book book = (Book)obj;
        int res = getAuthor().compareTo(book.getAuthor());
        if (res != 0) return res;
        return getTitle().compareTo(book.getTitle());
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Book)) return false;
        if (this.author == null || this.title == null) return false;
        Book book = (Book)obj;
        return (this.author.equals(book.getAuthor()) &&
                 this.title.equals(book.getTitle()));
    }
    
    public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			String hashStr = this.getClass().getName() + ":" + this.toString();
			this.hashCode = hashStr.hashCode();
		}
		return this.hashCode;
    }

    public String toString() {
        return this.author + ":" + this.title;
    }
}

