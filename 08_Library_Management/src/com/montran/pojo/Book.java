package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "book_master")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookCode;

	@Column(name = "book_name")
	private String title;

	@Column(name = "book_author")
	private String author;

	@Column(name = "book_type")
	private String isIssuable;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookCode, String title, String author, String isIssuable) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.author = author;
		this.isIssuable = isIssuable;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsIssuable() {
		return isIssuable;
	}

	public void setIsIssuable(String isIssuable) {
		this.isIssuable = isIssuable;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", author=" + author + ", isIssuable=" + isIssuable
				+ "]";
	}
	
	
}
