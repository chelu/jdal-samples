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
package org.jdal.samples.vaadin;

import info.joseluismartin.service.PersistentService;
import info.joseluismartin.vaadin.ui.AbstractView;

import java.util.Arrays;
import java.util.List;

import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.samples.model.Category;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Select;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 *
 */
public class BookFilterView extends AbstractView<BookFilter>  {
	
	private Form form = new Form();
	private String[] visibleProperties = new String[] {};
	private PersistentService<Category, Long> categoryService;
	private ComboBox category = new ComboBox("Category");
	
	public BookFilterView() {
		this(new BookFilter());
	}
	
	
	/**
	 * @param bookFilter
	 */
	public BookFilterView(BookFilter bookFilter) {
		setModel(bookFilter);
	}


	public void init() {
		List<Category> categories = categoryService.getAll();
		category.setItemCaptionMode(Select.ITEM_CAPTION_MODE_ID);
		for (Category c : categories)
			category.addItem(c);
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Component buildPanel() {		
		VerticalLayout vbox = new VerticalLayout();
		HorizontalLayout hl = new HorizontalLayout();
		form.setFormFieldFactory(new FilterFieldFactory());
		form.setItemDataSource(new BeanItem<BookFilter>(getModel()));
		form.setVisibleItemProperties(Arrays.asList(visibleProperties));	
		hl.setSpacing(true);
		form.setLayout(hl);
		vbox.addComponent(form);
		
		return vbox;
	}

	

	/**
	 * @return the visibleProperties
	 */
	public String[] getVisibleProperties() {
		return visibleProperties;
	}

	/**
	 * @param visibleProperties the visibleProperties to set
	 */
	public void setVisibleProperties(String[] visibleProperties) {
		this.visibleProperties = visibleProperties;
	}
	
	class FilterFieldFactory implements FormFieldFactory {

		/**
		 * {@inheritDoc}
		 */
		public Field createField(Item item, Object propertyId, Component uiContext) {
			if ("category".equals(propertyId))
				return category;
			
			return DefaultFieldFactory.get().createField(item, propertyId, uiContext);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void refresh() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void update() {
		form.commit();
	}


	/**
	 * @return the categoryService
	 */
	public PersistentService<Category, Long> getCategoryService() {
		return categoryService;
	}


	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(PersistentService<Category, Long> categoryService) {
		this.categoryService = categoryService;
	}
}
