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
package org.jdal.samples.springmvc;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.annotation.Resource;

import org.jdal.dao.Dao;
import org.jdal.dao.Page;
import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.samples.model.Book;
import org.jdal.samples.model.Category;
import org.jdal.web.table.PaginatedListAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller to handle "/book" requests
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
@Controller
@SessionAttributes("bookFilter")
@SuppressWarnings("unchecked")
public class BookController  {
	
	/** Persistent service for book categories */
	@Resource
	private Dao<Category, Long> categoryService;
	/** Persistent Service for Books */
	@Resource
	private Dao<Book, Long> bookService;
	
	/**
	 * Handle getPage request. Gets the Page from PaginatedListAdapter wrapper
	 * and query service for data.
	 * @param paginatedList the displaytag PaginatedList interface
	 * @param filter filter to apply
	 * 
	 */
	@RequestMapping()
	public void getPage(@ModelAttribute("paginatedList") PaginatedListAdapter paginatedList, 
				@ModelAttribute("bookFilter") BookFilter filter) {
		
		Page<Book> page = (Page<Book>) paginatedList.getModel();
		page.setFilter(filter);
		bookService.getPage(page);
	}

	/**
	 * Add the category list to model 
	 * @return List with all categories
	 */
	@ModelAttribute("categoryList")
	public List<Category> getCategories() {
		return categoryService.getAll();
	}
	
	/**
	 * Need to register the CategoryPropertyEditor for mapping ids of 
	 * category select to Category objects in bd.
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryPropertyEditor());
	}
	
	
	@ModelAttribute
	public BookFilter getBookFilter() {
		return new BookFilter();
	}
	
	/**
	 * @return the categoryService
	 */
	public Dao<Category, Long> getCategoryService() {
		return categoryService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(Dao<Category, Long> categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * @return the bookService
	 */
	public Dao<Book, Long> getBookService() {
		return bookService;
	}

	/**
	 * @param bookService the bookService to set
	 */
	public void setBookService(Dao<Book, Long> bookService) {
		this.bookService = bookService;
	}
	
	/**
	 * Property editor to map selected category from id string to Category.
	 */
	class CategoryPropertyEditor extends PropertyEditorSupport {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			Long id = Long.parseLong(text);
			Category value = id == 0 ? null : categoryService.get(id);
			setValue(value);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getAsText() {
			Category c = (Category) getValue();
			return c != null ? String.valueOf(c.getId()) : "";
		}
	}
}
