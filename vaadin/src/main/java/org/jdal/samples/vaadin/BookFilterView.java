package org.jdal.samples.vaadin;

import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

public class BookFilterView extends AbstractView<BookFilter> {
	
	private TextField name = new TextField();
	private ComboBox author = new ComboBox();
	

	public BookFilterView() {
		this(new BookFilter());
	}

	public BookFilterView(BookFilter model) {
		super(model);
		autobind();
		refresh();
	}

	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		
		fb.row();
		fb.add(name);
		fb.add(author);
		
		return fb.getForm();
	}

}
