package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;

import org.jdal.samples.model.Author;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

public class AuthorView extends AbstractView<Author> {

	private TextField name = FormUtils.newTextField();
	private TextField surname = FormUtils.newTextField();
	
	public AuthorView() {
		this(new Author());
	}

	public AuthorView(Author model) {
		super(model);
	}

	@PostConstruct
	public void init() {
		autobind();
	}
	
	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.setDefaultWidth(BoxFormBuilder.SIZE_FULL);
		fb.setMargin(false);
		fb.row();
		fb.add(name, getMessage("name"));
		fb.row();
		fb.add(surname, getMessage("surname"));
		
		return fb.getForm();
	}

}
