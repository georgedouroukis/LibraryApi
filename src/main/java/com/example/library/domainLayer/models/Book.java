package com.example.library.domainLayer.models;

import java.util.ArrayList;
import java.util.List;

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
	

	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	
	@ManyToMany
	@JoinTable(
		name="book_genres",
		joinColumns = @JoinColumn(name="genre_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"))
	private List<Genre> genres = new ArrayList<Genre>();
	
	
	@ManyToMany
	@JoinTable(
		name="book_authors",
		joinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"))
	private List<Author> authors = new ArrayList<Author>();
	
	
	
}
