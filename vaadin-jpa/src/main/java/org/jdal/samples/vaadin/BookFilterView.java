/*
 * Copyright 2009-2012 the original author or authors.
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

import javax.annotation.PostConstruct;

import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.samples.model.Category;
import org.jdal.service.PersistentService;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;
import org.jdal.vaadin.ui.form.SimpleBoxFormBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

/**
 * Book Filter View
 * 
 * @author Jose Luis Martin 
 */
@org.springframework.stereotype.Component
@Scope("prototype")
public class BookFilterView extends AbstractView<BookFilter> {
	
	private TextField name = new TextField();
	private TextField authorSurname = new TextField();
	private TextField authorName = new TextField();
	private DateField before = new DateField();

	public BookFilterView() {
		super(new BookFilter());
	}

	private DateField after = new DateField();
	private ComboBox category;
	@Autowired
	private PersistentService<Category, Long> categoryService;
	
	@PostConstruct
	public void init() {
		name.setNullRepresentation("");
		authorName.setNullRepresentation("");
		authorSurname.setNullRepresentation("");
		after.setResolution(DateField.RESOLUTION_DAY);
		before.setResolution(DateField.RESOLUTION_DAY);
		category = FormUtils.newComboBox(categoryService.getAll(), "name", getMessage("book.category"));
		
		autobind(); // bind controls to fields
		refresh();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.row();
		fb.add(getMessage("book.name"), name); 
		fb.setWidth(SimpleBoxFormBuilder.SIZE_FULL); // let this row to grow
		fb.add(category, 200);  // fix the column width
		fb.row();
		fb.startBox();  // start new box to add two compoenents in one cell
		fb.row();
		fb.add(getMessage("author.name"), authorName);
		fb.add(getMessage("author.surname"), authorSurname);
		fb.endBox();
		fb.startBox();
		fb.add(getMessage("book.after"), after);
		fb.add(getMessage("book.before"), before);
		fb.endBox();
		
		Component c = fb.getForm();
		c.setSizeFull();
		
		return c;
	}
}
