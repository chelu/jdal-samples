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
		autobind();
		refresh();
	}

	@Override
	protected Component buildPanel() {
		setFieldCaptions();
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.setMargin(false);
		
		fb.row();
		fb.add(name, BoxFormBuilder.SIZE_FULL);
		fb.add(author);
		fb.add(category);
		fb.add(before);
		fb.add(after);
		fb.add(isbn, 100);
		
		return fb.getForm();
	}

	private void setFieldCaptions() {
		name.setCaption(getMessage("Book.title"));
		author.setCaption(getMessage("Book.author"));
		category.setCaption(getMessage("Book.category"));
		before.setCaption(getMessage("BookFilter.publishedBefore"));
		after.setCaption(getMessage("BookFilter.publishedAfter"));
		isbn.setCaption(getMessage("Book.isbn"));
	}

}
