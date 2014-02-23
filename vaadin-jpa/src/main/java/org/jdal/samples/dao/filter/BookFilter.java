package org.jdal.samples.dao.filter;

import java.util.Date;

import org.jdal.annotations.Reference;
import org.jdal.dao.BeanFilter;
import org.jdal.samples.model.Author;
import org.jdal.samples.model.Category;

/**
 * Filter for Books
 * 
 * @author Jose Luis Martin
 */
public class BookFilter extends BeanFilter {
	
	private String name = "";
	@Reference
	private Author author;
	private Date before;
	private Date after;
	private String isbn = "";
	@Reference
	private Category category;
	
	public BookFilter() {
		this("book");
	}
	
	public BookFilter(String filterName) {
		super(filterName);
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
	 * @return the before
	 */
	public Date getBefore() {
		return before;
	}

	/**
	 * @param before the before to set
	 */
	public void setBefore(Date before) {
		this.before = before;
	}

	/**
	 * @return the after
	 */
	public Date getAfter() {
		return after;
	}

	/**
	 * @param after the after to set
	 */
	public void setAfter(Date after) {
		this.after = after;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
