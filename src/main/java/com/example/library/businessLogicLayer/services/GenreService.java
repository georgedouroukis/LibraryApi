package com.example.library.businessLogicLayer.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.businessLogicLayer.dtos.converters.BookDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.GenreDtoConverter;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Genre;
import com.example.library.domainLayer.repositories.BookRepository;
import com.example.library.domainLayer.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	
	public Collection<GenreDto> getGenres(){
		 return genreRepo.findAll()
				.stream()
				.map(g->GenreDtoConverter.toDto(g))
				.collect(Collectors.toSet());
	}
	
	public GenreDto getGenreById(int id) {
		GenreDto genre = GenreDtoConverter.toDto(
				genreRepo.findById(id).get());
		return genre;
	}
	
	public int createGenre(GenreDto dto) {
		Genre newGenre = GenreDtoConverter.toEntity(dto);
		genreRepo.save(newGenre);
		return newGenre.getId();
	}
	
	public int updateGenre(GenreDto dto) {
		Genre genre = genreRepo.findById(dto.getId()).get();
		genre.setGenre(dto.getGenre());
		genreRepo.save(genre);
		return genre.getId();
	}
	
	
	/*addBook, removeBook, getBooks
	 * addSubGenre, removeSubGenre, getSubGenres
	 * addOrReplaceParentGenre, removeParentGenre, getParentGenre
	 * */
	
	//mapped also by BookService
	public void addBook(int genreId, int bookId) {
		Book book = bookRepo.findById(bookId).get();
		Genre genre = genreRepo.findById(genreId).get();
		genre.getBooks().add(book);
		genreRepo.save(genre);
	}
	
	//mapped also by BookService
	public void removeBook(int genreId, int bookId) {
		Book book = bookRepo.findById(bookId).get();
		Genre genre = genreRepo.findById(genreId).get();
		genre.getBooks().removeIf(b->b.equals(book));
		genreRepo.save(genre);
	}
	
	public Collection<BookDto> getBooks(int id) {
		Genre genre = genreRepo.findById(id).get();
		Collection<Book> books = genre.getBooks();
		Collection<BookDto> booksdtos = books.stream().map(b->BookDtoConverter.toDto(b)).collect(Collectors.toSet());
		return booksdtos;
	}
	
	public void addSubGenre(int genreId, int subId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre sub = genreRepo.findById(subId).get();		
		genre.getSubGenres().add(sub);
		genreRepo.save(genre);
	}
	
	public void removeSubGenre(int genreId, int subId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre sub = genreRepo.findById(subId).get();		
		genre.getSubGenres().removeIf(s->s.equals(sub));
		genreRepo.save(genre);
	}
	
	public Collection<GenreDto> getSubGenres(int id) {
		Genre genre = genreRepo.findById(id).get();
		Collection<Genre> subgenres = genre.getSubGenres();
		Collection<GenreDto> subgenresdtos = subgenres.stream().map(s->GenreDtoConverter.toDto(s)).collect(Collectors.toSet());
		return subgenresdtos;
	}
	
	public void addOrReplaceParentGenre(int genreId, int parentId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre parent = genreRepo.findById(parentId).get();	
		genre.setParentGenre(parent);
		genreRepo.save(genre);
	}
	
	public void removeParentGenre(int genreId) {
		Genre genre = genreRepo.findById(genreId).get();
		genre.setParentGenre(null);
		genreRepo.save(genre);
	}
	
	public GenreDto getParentGenre(int genreId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre parent = genre.getParentGenre();
		GenreDto dto = GenreDtoConverter.toDto(parent);
		return dto;
	}
	
	public void deleteGenre(int genreId) {
		Genre genre = genreRepo.findById(genreId).get();
		genreRepo.delete(genre);
	}

}
