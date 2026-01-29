package com.example.biblioteca.model;

import java.util.Objects;

public class Book {
	// id será gerado no backend
	private String id;
	private String title;
	private String author;
	private String year;

	public Book() {}

	public Book(String id, String title, String author, String year) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public String getYear() { return year; }
	public void setYear(String year) { this.year = year; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;
		Book book = (Book) o;
		return Objects.equals(id, book.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
