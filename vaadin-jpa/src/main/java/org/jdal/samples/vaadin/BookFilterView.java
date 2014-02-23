package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;

import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

/**
 * Book Filter
 * 
 * @author Jose Luis Martin
 */
public class BookFilterView extends AbstractView<BookFilter> {
	
	private TextField name = FormUtils.newTextField();
	private ComboBox author = new ComboBox();
	private ComboBox category = new ComboBox();
	private DateField before = new DateField();
	private DateField after = new DateField();
	private TextField isbn =  FormUtils.newTextField();

	public BookFilterView() {
		this(new BookFilter());
	}

	public BookFilterView(BookFilter model) {
		super(model);
	}
	
	@PostConstruct
	public void init() {
		// bind controls to model by name
		autobind();
		// update controls from model
		refresh();
	}

	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.setMargin(false);
		
		fb.row();
		fb.add(name, getMessage("Book.title"), BoxFormBuilder.SIZE_FULL);
		fb.add(author, getMessage("Book.author"));
		fb.add(category, getMessage("Book.category"));
		fb.add(before, getMessage("BookFilter.publishedBefore"));
		fb.add(after, getMessage("BookFilter.publishedAfter"));
		fb.add(isbn, getMessage("Book.isbn"), 100);
		
		return fb.getForm();
	}
}
