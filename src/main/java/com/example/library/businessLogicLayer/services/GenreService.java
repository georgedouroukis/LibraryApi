package com.example.library.businessLogicLayer.services;

import java.util.List;
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
	
	
	public List<GenreDto> getGenres(){
		 return genreRepo.findAll()
				.stream()
				.map(g->GenreDtoConverter.toDto(g))
				.collect(Collectors.toList());
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
	
	public List<BookDto> getBooks(int id) {
		Genre genre = genreRepo.findById(id).get();
		List<Book> books = genre.getBooks();
		List<BookDto> booksdtos = books.stream().map(b->BookDtoConverter.toDto(b)).collect(Collectors.toList());
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
	
	public List<GenreDto> getSubGenres(int id) {
		Genre genre = genreRepo.findById(id).get();
		List<Genre> subgenres = genre.getSubGenres();
		List<GenreDto> subgenresdtos = subgenres.stream().map(s->GenreDtoConverter.toDto(s)).collect(Collectors.toList());
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
