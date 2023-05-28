package com.example.library.domainLayer.models;

import java.util.Collection;
import java.util.HashSet;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity(name="author")
public class Author {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	
	@ManyToMany(mappedBy = "authors"/* , fetch = FetchType.EAGER */)
	private Collection<Book> books = new HashSet<Book>();



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Collection<Book> getBooks() {
		return books;
	}

	
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	

}
