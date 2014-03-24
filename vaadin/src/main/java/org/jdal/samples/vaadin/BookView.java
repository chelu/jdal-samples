package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;

import org.jdal.samples.model.Book;
import org.jdal.ui.Editor;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.form.BoxFormBuilder;
import org.jdal.vaadin.ui.form.SimpleBoxFormBuilder;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

/**
 * Book Editor
 * 
 * @author Jose Luis Martin
 */
public class BookView extends AbstractView<Book> {

	private TextField name = new TextField();
	private TextField isbn = new TextField();
	private DateField publishedDate = new DateField();
	private ComboBox author = new ComboBox();
	private ComboBox category = new ComboBox();

	
	public BookView() {
		this(new Book());
	}

	public BookView(Book model) {
		super(model);
	}

	@PostConstruct
	public void init()  {
		autobind();
	}
	
	@Override
	protected Component buildPanel() {
		// Sets captions
		name.setCaption(getMessage("Book.title"));
		publishedDate.setCaption(getMessage("Book.publishedDate"));
		author.setCaption(getMessage("Book.author"));
		category.setCaption(getMessage("Book.category"));
		isbn.setCaption(getMessage("Book.isbn"));
		
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.setDefaultWidth(SimpleBoxFormBuilder.SIZE_FULL);
		fb.setFixedHeight();
		
		fb.row();
		fb.add(name);
		fb.row();
		fb.startBox();
		fb.row();
		fb.add(author);
		fb.add(category);
		fb.endBox();
		fb.row();
		fb.startBox();
		fb.row();
		fb.add(isbn);
		fb.add(publishedDate, 120);
		fb.endBox();
		
		return fb.getForm();
	}
	
	@Override
	public String getName() {
		Book model = getModel();
		
		if (model != null && model.getId() != null) {
			return model.getName();
		}
		
		return null;
	}

}
