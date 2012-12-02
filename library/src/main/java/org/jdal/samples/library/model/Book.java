package org.jdal.samples.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.validator.constraints.NotBlank;


/**
 * Book Entity. Use ID identity for equals and hashcode. Don't store in
 * a map before save.
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
@Entity
@Table(name="books")
@NamedNativeQuery(name="test", query="select * from books where id = test(:id)", resultClass=Book.class)
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	@NotBlank
	protected String name = "";
	@ManyToOne
	@JoinColumn(name="authorid")
	private Author author;
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	private String isbn;
	private Date publishedDate;
	
	public String toString() {
		return name;
	}
	
	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * @return the publishedDate
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}
	
	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
