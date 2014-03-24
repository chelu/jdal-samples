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


import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import org.jdal.dao.Dao;
import org.jdal.dao.Filter;
import org.jdal.dao.Page;
import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.samples.model.Category;
import org.jdal.web.table.DataTableModel;
import org.jdal.web.table.ModelMapper;
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
@SessionAttributes("filter")   // Store filter on Session
public class BookController  {
	
	/** Persistent service for book categories */
	@Resource
	private Dao<Category, Long> categoryService;
	/** Persistent Service for Books */
	@Resource
	private Dao<Object, Long> bookService;
	/** Model mapper */
	@Resource
	ModelMapper bookModelMapper;
	
	/**
	 * Handle getPage request. Gets the Page from PaginatedListAdapter wrapper
	 * and query service for data.
	 * @param paginatedList the displaytag PaginatedList interface
	 * @param filter filter to apply
	 * @return Model 
	 */
	@RequestMapping("/getPage")
	public void getPage(@ModelAttribute Filter filter) {
		// do nothing, only store filter on session
		// the table will request data using AJAX
	}
	
	@RequestMapping("/getData")
	public void  getData(HttpServletResponse response, @ModelAttribute DataTableModel dtm, 
			@ModelAttribute Filter filter) throws IOException {
		
		Page<Object> page = dtm.buildPage();
		page.setFilter(filter);
		bookService.getPage(page);
		dtm.setRecords(bookModelMapper.fromModel(page.getData()));
		dtm.setTotalRecords(page.getCount());
		
		JSON json = JSONSerializer.toJSON(dtm);
		  // write json string to response
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");             // HTTP/1.1
        response.addHeader("Cache-Control", "no-store");             // HTTP/1.1
        response.addHeader("Cache-Control", "must-revalidate");      // HTTP/1.1
        
        response.setContentType("application/x-json;charset=UTF-8");
        
	    json.write(response.getWriter());
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
	public Filter getFilter() {
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
	public Dao<Object, Long> getBookService() {
		return bookService;
	}

	/**
	 * @param bookService the bookService to set
	 */
	public void setBookService(Dao<Object, Long> bookService) {
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

	/**
	 * @return the modelMapper
	 */
	public ModelMapper getModelMapper() {
		return bookModelMapper;
	}

	/**
	 * @param modelMapper the modelMapper to set
	 */
	public void setModelMapper(ModelMapper modelMapper) {
		this.bookModelMapper = modelMapper;
	}
}
