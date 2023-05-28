package com.example.library.domainLayer.models;


import java.util.Collection;
import java.util.HashSet;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


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
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	
	@JsonManagedReference
	@ManyToMany /* (fetch = FetchType.EAGER) */
	@JoinTable(
		name="book_genres",
		joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="genre_id", referencedColumnName = "id"))
	private Collection<Genre> genres = new HashSet<Genre>();
	
	
	@JsonManagedReference
	@ManyToMany /* (fetch = FetchType.EAGER) */
	@JoinTable(
		name="book_authors",
		joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"))
	private Collection<Author> authors = new HashSet<Author>();


	
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Publisher getPublisher() {
		return publisher;
	}


	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}


	public Collection<Genre> getGenres() {
		return genres;
	}


	public void setGenres(Collection<Genre> genres) {
		this.genres = genres;
	}


	public Collection<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
