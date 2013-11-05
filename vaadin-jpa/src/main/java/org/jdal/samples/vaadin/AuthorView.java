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

import org.jdal.samples.model.Author;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;


/**
 * Author View
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class AuthorView extends AbstractView<Author> {
	
	private TextField name = FormUtils.newTextField();
	private TextField surname = FormUtils.newTextField();

	@PostConstruct
	public void init() {
		autobind();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Component buildPanel() {
		
		BoxFormBuilder fb = new BoxFormBuilder();
		
		fb.row();
		fb.add(getMessage("author.name"), name);
		fb.row();
		fb.add(getMessage("author.surname"), surname);
	
		
		return fb.getForm();
	}

}
