package com.example.library.businessLogicLayer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.businessLogicLayer.dtos.PublisherDto;
import com.example.library.businessLogicLayer.dtos.converters.AuthorDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.BookDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.GenreDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.PublisherDtoConverter;
import com.example.library.domainLayer.models.Author;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Genre;
import com.example.library.domainLayer.models.Publisher;
import com.example.library.domainLayer.repositories.AuthorRepository;
import com.example.library.domainLayer.repositories.BookRepository;
import com.example.library.domainLayer.repositories.GenreRepository;
import com.example.library.domainLayer.repositories.PublisherRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private PublisherRepository publisherRepo;
	
	public List<BookDto> getBooks(){
		return bookRepo.findAll()
				.stream()
				.map(b->BookDtoConverter.toDto(b))
				.collect(Collectors.toList());
		
	}
	
	public BookDto getBookById(int id) {
		BookDto book = BookDtoConverter.toDto(
				bookRepo.findById(id).get());
		return book;
		
	}
	
	public int createBook(BookDto dto) {
		Book newBook = BookDtoConverter.toEntity(dto);
		bookRepo.save(newBook);
		return newBook.getId();
		
	}
	
	public int updateBook(BookDto dto) {
		Book book = bookRepo.findById(dto.getId()).get();
		book.setIsbn(dto.getIsbn());
		book.setTitle(dto.getTitle());
		book.setPageNumber(dto.getPageNumber());
		book.setPublicationDate(dto.getPublicationDate());
		bookRepo.save(book);
		return book.getId();
	}
	
	/* addGenre, removeGenre, getGenres,
	 * addAuthor, removeAuthor, getAuthors,
	 * addOrReplacePublisher, removePublisher, getPublisher
	 * */
	
	//mapped also by GenreService
	public void addGenre(int bookId, int genreId) {
		Book book = bookRepo.findById(bookId).get();
		Genre genre = genreRepo.findById(genreId).get();
		book.getGenres().add(genre);
		bookRepo.save(book);
	}
	
	//mapped also by GenreService
	public void removeGenre(int bookId, int genreId) {
		Book book = bookRepo.findById(bookId).get();
		Genre genre = genreRepo.findById(genreId).get();
		book.getGenres().removeIf(g->g.equals(genre));
		bookRepo.save(book);
	}
	
	public List<GenreDto> getGenres(int id) {
		Book book = bookRepo.findById(id).get();
		List<Genre> genres = book.getGenres();
		List<GenreDto> genresdtos = genres.stream().map(g->GenreDtoConverter.toDto(g)).collect(Collectors.toList());
		return genresdtos;
	}
	
	//mapped also by AuthorService
	public void addAuthor(int bookId, int authorId) {
		Book book = bookRepo.findById(bookId).get();
		Author author = authorRepo.findById(authorId).get();
		book.getAuthors().add(author);
		bookRepo.save(book);
	}
	
	//mapped also by AuthorService
	public void removeAuthor(int bookId, int authorId) {
		Book book = bookRepo.findById(bookId).get();
		Author author = authorRepo.findById(authorId).get();
		book.getAuthors().removeIf(a->a.equals(author));
		bookRepo.save(book);
	}
	
	public List<AuthorDto> getAuthors(int bookId) {
		Book book = bookRepo.findById(bookId).get();
		List<Author> authors = book.getAuthors();
		List<AuthorDto> authorsdtos = authors.stream().map(a->AuthorDtoConverter.toDto(a)).collect(Collectors.toList());
		return authorsdtos;
	}
	
	public void addOrReplacePublisher(int bookId, int publisherId) {
		Book book = bookRepo.findById(bookId).get();
		Publisher publisher = publisherRepo.findById(publisherId).get();
		book.setPublisher(publisher);
		bookRepo.save(book);
	}
	
	public void removePublisher(int bookId) {
		Book book = bookRepo.findById(bookId).get();
		book.setPublisher(null);
		bookRepo.save(book);
		
	}
	
	public PublisherDto getPublisher(int bookId) {
		Book book = bookRepo.findById(bookId).get();
		Publisher publisher = book.getPublisher();
		PublisherDto dto = PublisherDtoConverter.toDto(publisher);
		return dto;
	}
	
	public void deleteBook(int bookId) {
		Book book = bookRepo.findById(bookId).get();
		bookRepo.delete(book);
	}

}
