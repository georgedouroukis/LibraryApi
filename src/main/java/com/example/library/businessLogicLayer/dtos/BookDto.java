package com.example.library.businessLogicLayer.dtos;

import java.util.Collection;
import java.util.HashSet;

public class BookDto {
	
	private int id;
	private String isbn;
	private String title;
	private int pageNumber;
	private String publicationDate;
	
	private Integer publisher;
	private Collection<Integer> genres = new HashSet<Integer>();
	private Collection<Integer> authors = new HashSet<Integer>();
	
	
	public BookDto(int id, String isbn, String title, int pageNumber, String publicationDate, Integer publisher,
			Collection<Integer> genres, Collection<Integer> authors) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.pageNumber = pageNumber;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
		this.genres = genres;
		this.authors = authors;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Integer getPublisher() {
		return publisher;
	}
	public Collection<Integer> getGenres() {
		return genres;
	}
	public Collection<Integer> getAuthors() {
		return authors;
	}
	

}
