package org.jdal.samples.vaadin;

import org.jdal.samples.model.Book;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

/**
 * Book Editor
 * 
 * @author Jose Luis Martin
 */
public class BookView extends AbstractView<Book> {

	private TextField name = new TextField();
	private ComboBox author = new ComboBox();
	private ComboBox category = new ComboBox();
	
	public BookView() {
		this(new Book());
	}

	public BookView(Book model) {
		super(model);
		autobind();
		refresh();
	}

	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		
		fb.row();
		fb.add(name);
		fb.row();
		fb.add(author);
		fb.row();
		fb.add(category);
		
		return fb.getForm();
	}
}
