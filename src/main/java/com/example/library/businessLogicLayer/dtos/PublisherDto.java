package com.example.library.businessLogicLayer.dtos;

import java.util.ArrayList;
import java.util.List;


public class PublisherDto {
	
	private int id;
	private String name;
	private String phone;
	private String email;

	private List<BookDto> books = new ArrayList<BookDto>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BookDto> getBooks() {
		return books;
	}

	public void setBooks(List<BookDto> books) {
		this.books = books;
	}
	
	
}
