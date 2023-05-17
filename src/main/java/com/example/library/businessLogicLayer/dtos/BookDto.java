package com.example.library.businessLogicLayer.dtos;

import java.util.ArrayList;
import java.util.List;

public class BookDto {
	
	private int id;
	private String isbn;
	private String title;
	private int pageNumber;
	private String publicationDate;
	
	private PublisherDto publisher;
	private List<GenreDto> genres = new ArrayList<GenreDto>();
	private List<AuthorDto> authors = new ArrayList<AuthorDto>();
	
	
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
	public PublisherDto getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}
	public List<GenreDto> getGenres() {
		return genres;
	}
	public void setGenres(List<GenreDto> genres) {
		this.genres = genres;
	}
	public List<AuthorDto> getAuthors() {
		return authors;
	}
	public void setAuthors(List<AuthorDto> authors) {
		this.authors = authors;
	}

}
