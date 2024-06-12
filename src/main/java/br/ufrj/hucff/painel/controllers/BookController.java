package br.ufrj.hucff.painel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrj.hucff.painel.dtos.BookRecordDto;
import br.ufrj.hucff.painel.modelo.Book;
import br.ufrj.hucff.painel.services.BookService;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody BookRecordDto bookRecordDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));
	}

}
