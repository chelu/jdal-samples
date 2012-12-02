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
package org.jdal.samples.library.ui;

import info.joseluismartin.beans.AppCtx;
import info.joseluismartin.gui.AbstractView;
import info.joseluismartin.gui.Selector;
import info.joseluismartin.gui.TitledSeparator;
import info.joseluismartin.gui.ViewDialog;
import info.joseluismartin.gui.form.BoxFormBuilder;
import info.joseluismartin.gui.form.FormUtils;
import info.joseluismartin.gui.form.SimpleBoxFormBuilder;
import info.joseluismartin.service.PersistentService;

import javax.annotation.Resource;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTextField;

import model.Book;

import org.jdal.samples.library.model.Reader;

/**
 * Reader GUI Editor. Show Selector component for editing ManyToMany
 * relations with Books.
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 * @see info.joseluismartin.gui.Selector
 * @since 1.3.0
 */
public class ReaderView extends AbstractView<Reader> {
	
	private JTextField name = new JTextField();
	private JTextField surname = new JTextField();
	private Selector<Book> books = new Selector<Book>();
	@Resource
	private PersistentService<Book, Long> bookService;
	@Resource 
	private PersistentService<Reader, Long> readerService;
	
	
	/**
	 * Default Ctor 
	 */
	public ReaderView() {
		this(new Reader());
	}

	/**
	 * @param model
	 */
	public ReaderView(Reader model) {
		super(model);
	}
	
	/**
	 * Init method, called by container
	 */
	public void init() {
		// intialize book selector
		books.setAll(bookService.getAll());
		books.init();
		// bind controls to model properties by name
		autobind();
		refresh();
	}


	/**
	 * Build View component. Use a BoxFormBuilder to do it.
	 */
	@Override
	protected JComponent buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder(FormUtils.createTitledBorder(getMessage("Reader")));
		// uncomment to see box borders.
		// fb.setDebug(true) 
		fb.row();
		fb.startBox(); // Fixed height box for name and surname
		fb.setFixedHeight(true);
		fb.row();
		fb.add(getMessage("Name"), name);   // add two rows one with label and other with text field
		fb.row();
		fb.add(getMessage("Surname"), surname);
		fb.endBox();
		fb.row();
		fb.add(new TitledSeparator(getMessage("ReaderView.readedBooks")));
		fb.row(SimpleBoxFormBuilder.SIZE_UNDEFINED); // let this row to grow as needed
		fb.add(books);
		
		return fb.getForm();  // build the form
	}
	
	/**
	 * Initialize books collection to avoid LIE.
	 */
	@Override
	public void onSetModel(Reader reader) {
		if (readerService != null) {
			readerService.initialize(reader);
		}
	}

	/**
	 * @return the bookService
	 */
	public PersistentService<Book, Long> getBookService() {
		return bookService;
	}

	/**
	 * @param bookService the bookService to set
	 */
	public void setBookService(PersistentService<Book, Long> bookService) {
		this.bookService = bookService;
	}
	
	/**
	 * Simple test method to view the editor
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		AppCtx.setConfigPackage("conf");
		ViewDialog dlg = (ViewDialog) AppCtx.getInstance().getBean("readerEditor");
		dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dlg.refresh();
		dlg.setVisible(true);
	}

	/**
	 * @return the readerService
	 */
	public PersistentService<Reader, Long> getReaderService() {
		return readerService;
	}

	/**
	 * @param readerService the readerService to set
	 */
	public void setReaderService(PersistentService<Reader, Long> readerService) {
		this.readerService = readerService;
	}
	
}
