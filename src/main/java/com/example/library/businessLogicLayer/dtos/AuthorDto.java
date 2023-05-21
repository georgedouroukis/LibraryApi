package com.example.library.businessLogicLayer.dtos;

import java.util.Collection;
import java.util.HashSet;

public class AuthorDto {
	
	private int id;
	private String firstName;
	private String lastName;
	private String middleName;
	
	private Collection<Integer> books = new HashSet<>();
	
	
	public AuthorDto(int id, String firstName, String lastName, String middleName, Collection<Integer> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.books = books;
	}
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
	public Collection<Integer> getBooks() {
		return books;
	}
	
}
