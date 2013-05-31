package org.jdal.samples.library.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.jdal.samples.library.model.Author;
import org.jdal.swing.AbstractView;
import org.jdal.swing.form.BoxFormBuilder;
import org.jdal.swing.form.FormUtils;

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
		autobind();  // bind controls to model properties by name
	}
	
	@Override
	public JComponent buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.add(getMessage("Name"), name);
		fb.row();
		fb.add(getMessage("Surname"), surname);
		JComponent form = fb.getForm();
		form.setBorder(FormUtils.createTitledBorder(getMessage("Author")));
		
		return form;
	}
}
