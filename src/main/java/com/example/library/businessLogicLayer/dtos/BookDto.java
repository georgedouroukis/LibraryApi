package com.example.library.businessLogicLayer.dtos;

import java.util.ArrayList;
import java.util.List;

public class BookDto {
	
	private int id;
	private String isbn;
	private String title;
	private int pageNumber;
	private String publicationDate;
	
	private Integer publisher;
	private List<Integer> genres = new ArrayList<Integer>();
	private List<Integer> authors = new ArrayList<Integer>();
	
	
	public BookDto(int id, String isbn, String title, int pageNumber, String publicationDate, Integer publisher,
			List<Integer> genres, List<Integer> authors) {
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
	public List<Integer> getGenres() {
		return genres;
	}
	public List<Integer> getAuthors() {
		return authors;
	}
	

}
