package br.ufrj.hucff.painel.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Book implements Serializable {

	/**
	 * @author ellysonalmeida
	 * @since 12/06/2024
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Pubisher publisher;
	
	@ManyToMany
	@JoinTable(name = "book_autor", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();
	
	@OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
	private Review review;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Pubisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Pubisher publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
}
