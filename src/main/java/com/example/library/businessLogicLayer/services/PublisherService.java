package com.example.library.businessLogicLayer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.PublisherDto;
import com.example.library.domainLayer.repositories.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository repo;
	
	public List<PublisherDto> getPublishers(){
		return null;
		
	}
	
	public PublisherDto getPublisherById() {
		return null;
	}
	
	public void createPublisher() {
		
	}
	
	public void updatePublisher() {
		
	}
	
	public void deletePublisher() {
		
	}


}
