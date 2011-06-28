package org.jdal.samples.library.ui;

import info.joseluismartin.gui.AbstractView;
import info.joseluismartin.gui.form.BoxFormBuilder;
import info.joseluismartin.gui.form.FormUtils;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.jdal.samples.library.model.Author;

/**
 * Author View
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class AuthorView extends AbstractView<Author> {
	private JTextField name = new JTextField(25);
	private JTextField surname = new JTextField(25);
	
	public AuthorView() {
		this(new Author());
	}
	
	public AuthorView(Author author) {
		setModel(author);
		refresh();
	}
	
	public void init() {
		bind(name, "name");
		bind(surname, "surname");
	}
	
	@Override
	public JComponent buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.add("Name: ", name);
		fb.row();
		fb.add("Surname: ", surname);
		JComponent form = fb.getForm();
		form.setBorder(FormUtils.createTitledBorder("Author"));
		
		return form;
	}
}