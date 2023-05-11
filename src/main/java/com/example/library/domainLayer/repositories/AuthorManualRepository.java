package com.example.library.domainLayer.repositories;


import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.domainLayer.models.Author;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transaction;


@Transactional
@Repository
public class AuthorManualRepository
{
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Author> get()
	{
		List<Author> result = entityManager
                .createQuery("select c from cities c", Author.class)
                .getResultStream()
                .filter(o -> o instanceof Author)
                .map(o -> (Author) o)
                .collect(Collectors.toList());
        
        return result;
	}
	
	public Author getById(int id)
    {
        return entityManager.find(Author.class, id);
    }
	
	public int create(Author a)
	{
		entityManager
			.createNativeQuery("INSERT INTO author (first_name, last_name, middle_name) VALUES (?,?,?)")
			.setParameter(1, a.getFirstName())
			.setParameter(2, a.getLastName())
			.setParameter(3, a.getMiddleName())
			.executeUpdate();
		
		int entityId = ((Number) entityManager
			.createNativeQuery("SELECT a.id FROM author a WHERE a.last_name = ?")
			.setParameter(1, a.getLastName())
			.getSingleResult()).intValue();
		
		return entityId;
	}
}
