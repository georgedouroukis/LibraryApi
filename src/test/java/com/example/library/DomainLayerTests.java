package com.example.library;


import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.domainLayer.models.Author;
import com.example.library.domainLayer.repositories.AuthorRepository;
import com.example.library.domainLayer.repositories.BookRepository;
import com.example.library.domainLayer.repositories.GenreRepository;
import com.example.library.domainLayer.repositories.PublisherRepository;



@SpringBootTest
class DomainLayerTests {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private PublisherRepository publisherRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private AuthorRepository authorRepo;

	
	@Test
	@Transactional
	@Commit
	void contextLoads() {
		
		
//		List<Book> books = new ArrayList<>();
//		bookRepo.findAll().forEach(b->books.add(b));
		
//		books.forEach(b->System.out.println(b.getTitle()+": "+b.getPublisher().getName()));
		
		
//		books.forEach(b->b.getAuthors().forEach(a->System.out.println(a.getLastName())));
		

		Author author = new Author(); 
			
			author.setFirstName("George");
			author.setLastName("Douroukis");
			author.setMiddleName("wwewe");
			author.setId(61);
			
		
//		Publisher publisher = new Publisher() {{
//			setName("patakis");
//			setEmail("patakis@gmail.com");
//			setPhone("6912345678");
//		}};
//		
//		Genre genre = new Genre() {{
//			setGenre("Drama");
//		}};
//		
//		Book book = new Book() {{
//			setAuthors(new ArrayList<Author>() {{add(author);}});
//			setTitle("potiri");
//			setIsbn("1165845612356");
//			setPublicationDate("2020");
//			setGenres(new ArrayList<Genre>() {{add(genre);}});
//			setPublisher(publisher);
//		}};
		
//			List<Author> list = new ArrayList<>();
//			
//			authorRepo.findAll().forEach(a->System.out.println(a.getLastName()));
			
		authorRepo.save(author);
//		publisherRepo.save(publisher);
//		genreRepo.save(genre);
//		bookRepo.save(book);
//		
		
	
		Assertions.assertThat(true).isEqualTo(true);

		
	}

}
