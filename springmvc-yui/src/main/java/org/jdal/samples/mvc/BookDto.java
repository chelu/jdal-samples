/*
 * Copyright 2009-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdal.samples.mvc;

import org.jdal.samples.model.Book;

/**
 * Book Data Transfer Object to exchange with YUI Datatable 
 *
 * @author Jose Luis Martin
 */
public class BookDto {
	private long id;
	private String author;
	private String category;
	private String isbn;
	private long publishedDate;
	private String name;
	
	public BookDto() {
		
	}
	
	/**
	 * @param b
	 */
	public BookDto(Book b) {
		this.id = b.getId();
		this.author = b.getAuthor().toString();
		this.category = b.getCategory().toString();
		this.isbn = b.getIsbn();
		this.publishedDate = b.getPublishedDate().getTime();
		this.name = b.getName();
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
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
	public long getPublishedDate() {
		return publishedDate;
	}
	
	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(long publishedDate) {
		this.publishedDate = publishedDate;
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
	
}
