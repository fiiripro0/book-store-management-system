package com.LibraryMS.entity;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String publishDate;  // Change this line

	public Book(int id, String name, String author, String publishDate) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publishDate = publishDate;  // Change this line
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishDate() {
		return publishDate;  // Change this line
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;  // Change this line
	}
}
