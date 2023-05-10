package com.example.library.domainLayer.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;


@Entity(name="book")
public class Book {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String isbn;
	
	private String title;
	
	@Column(name="page_number")
	private int pageNumber;
	
	@Column(name="publication_date")
	private String publicationDate;
	

	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	
	@JsonManagedReference
	@ManyToMany /* (fetch = FetchType.EAGER) */
	@JoinTable(
		name="book_genres",
		joinColumns = @JoinColumn(name="genre_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"))
	private List<Genre> genres = new ArrayList<Genre>();
	
	
	@JsonManagedReference
	@ManyToMany /* (fetch = FetchType.EAGER) */
	@JoinTable(
		name="book_authors",
		joinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"))
	private List<Author> authors = new ArrayList<Author>();


	
	public String getTitle() {
		return title;
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


	public Publisher getPublisher() {
		return publisher;
	}


	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}


	public List<Genre> getGenres() {
		return genres;
	}


	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}


	public List<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
