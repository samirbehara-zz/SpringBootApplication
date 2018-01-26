package com.demo.springbootdemo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootdemo.dto.BookDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/books")
@Api("v1 - book")
public class BookController {
	
	/*@RequestMapping(method = RequestMethod.GET)
	public List<BookDto> getBooks() {
		
	
		List<BookDto> books = new ArrayList();
		books.add( new BookDto("11", "Appress AWS", "Samir", "Technical"));
		books.add( new BookDto("12", "Wrox Java", "Patrick", "Technical"));
		return books;
		
	}*/
	
	private int idCounter = 0;
	
	private List<BookDto> books = new ArrayList();
	
	@RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get All Books")
	public List<BookDto> getBooks() {
		
		return books;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ApiOperation(value = "Get Book by ID")
	public BookDto getBookbyID(@PathVariable("id") String id) {
		
		for(BookDto book : books) {
			if(book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create a Book")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto book){
		
		book.setId(String.valueOf(idCounter++));
		books.add(book);
		return new ResponseEntity<BookDto>(book, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	 @ApiOperation(value = "Delete a pre-existing book by ID")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") String id) {
		
		for(Iterator<BookDto> iter = books.iterator(); iter.hasNext(); ) {
			
			BookDto book = iter.next();
			if(book.getId().equals(id)) {
				iter.remove();
				return ResponseEntity.ok().build();
			}
			
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@RequestMapping(method = RequestMethod.PUT , value = "{id}")
	@ApiOperation(value = "Update a pre-existing book by ID")
	public ResponseEntity<BookDto> UpdateBook(@PathVariable("id") String id, @RequestBody BookDto book)
	{
		
		for(Iterator<BookDto> iter = books.iterator(); iter.hasNext(); ) {
			
			BookDto existing  = iter.next();
			if(existing.getId().equals(id)) {
				existing.copyFrom(book);
				
				return ResponseEntity.status(HttpStatus.OK).body(existing);
			}
			
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PostConstruct
	public void setup() {
		/*books.add( new BookDto("1", "Appress AWS", "Samir", "Technical"));
		books.add( new BookDto("2", "Wrox Java", "Patrick", "Technical"));*/
		
		books.add( new BookDto(String.valueOf(idCounter++), "Book1", "Samir", "Technical"));
		books.add( new BookDto(String.valueOf(idCounter++), "Book2", "Patrick", "Technical"));
	}

}
