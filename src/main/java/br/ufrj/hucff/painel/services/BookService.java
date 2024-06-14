package br.ufrj.hucff.painel.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.ufrj.hucff.painel.dtos.BookRecordDto;
import br.ufrj.hucff.painel.modelo.Book;
import br.ufrj.hucff.painel.modelo.Review;
import br.ufrj.hucff.painel.repositories.AuthorRepository;
import br.ufrj.hucff.painel.repositories.BookRepository;
import br.ufrj.hucff.painel.repositories.PublisherRepository;
import jakarta.transaction.Transactional;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final PublisherRepository publisherRepository;
	
	public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
			PublisherRepository pubisherRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.publisherRepository = pubisherRepository;
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@Transactional
	public void deleteBook(UUID id) {
		bookRepository.deleteById(id);
	}
	
	@Transactional
	public Book saveBook(BookRecordDto bookRecordDto) {
		Book book = new Book();
		book.setTitle(bookRecordDto.title());
		book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
		book.setAuthors(authorRepository.findAllById(bookRecordDto.autorIds()).stream().collect(Collectors.toSet()));
		
		Review review = new Review();
		review.setComment(bookRecordDto.reviewComment());
		review.setBook(book);
		book.setReview(review);
		
		return bookRepository.save(book);
	}
	
	
	
	
	

}
