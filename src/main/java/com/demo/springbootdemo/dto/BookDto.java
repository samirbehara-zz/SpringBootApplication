package com.demo.springbootdemo.dto;

public class BookDto {
	
	private String id;
	private String title;
	private String author;
	private String genre;
	
	
	public BookDto(String id, String title, String author, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
	}
	
	public BookDto() {
	
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void copyFrom(BookDto book) {
		setAuthor(book.getAuthor());
		setTitle(book.getTitle());
		setGenre(book.getGenre());
	}

}
