package br.ufrj.hucff.painel.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufrj.hucff.painel.modelo.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {
	
	Book findBookByTitle(String title);
	
	@Query(value = "SELECT * FROM book WHERE publisher_id = :id", nativeQuery = true)
	List<Book> findBooksByPublisherId(@Param("id") UUID id);

}
