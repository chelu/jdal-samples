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

import org.jdal.samples.model.Book;
import org.jdal.vaadin.ui.form.BoxFormBuilder;
import org.jdal.vaadin.ui.table.PageableTable;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.Reindeer;

/**
 * Simple Test for PageableTable
 * 
 * @author Jose Luis Martin
 */
@Theme("sample")
@Title("JDAL Vaadin Pageable Table Sample")
public class TestApp extends UI {
	
	@Autowired
	private PageableTable<Book> bookTable;
	
	
	@Override
	public void init(VaadinRequest request) {
		Label title = new Label("JDAL Vaadin Sample Application - version 2.0");
		title.setStyleName(Reindeer.LABEL_H1);
	
		BoxFormBuilder fb = new BoxFormBuilder();
	
		fb.row(100);
		fb.add(title);
		fb.row();
		fb.setElastic();
		fb.add(bookTable);
		
		setContent(fb.getForm());
	}
}
