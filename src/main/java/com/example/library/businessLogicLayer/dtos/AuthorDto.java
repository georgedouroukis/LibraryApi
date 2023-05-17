package com.example.library.businessLogicLayer.dtos;

import java.util.ArrayList;
import java.util.List;

public class AuthorDto {
	
	private int id;
	private String firstName;
	private String lastName;
	private String middleName;
	
	private List<BookDto> books = new ArrayList<BookDto>();
	
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
	public List<BookDto> getBooks() {
		return books;
	}
	public void setBooks(List<BookDto> books) {
		this.books = books;
	}
}
