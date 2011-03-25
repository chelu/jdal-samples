package org.jdal.samples.library.ui;

import info.joseluismartin.gui.AbstractView;
import info.joseluismartin.gui.GuiFactory;
import info.joseluismartin.gui.ViewDialog;
import info.joseluismartin.gui.action.AutoCompletionListener;
import info.joseluismartin.gui.form.BoxFormBuilder;
import info.joseluismartin.gui.form.FormUtils;
import info.joseluismartin.gui.list.ListComboBoxModel;
import info.joseluismartin.service.PersistentService;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendarCombo;
import org.jdal.samples.library.model.Author;
import org.jdal.samples.library.model.Book;
import org.jdal.samples.library.model.Category;
import org.jdal.samples.library.service.AuthorService;

/**
 * View Form for Books
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class BookView extends AbstractView<Book> {

	private static final String ADD_ICON = "/images/16x16/list-add.png";
	
	private JTextField name = new JTextField();
	private JTextField isbn = new JTextField();
	private JComboBox author = FormUtils.newCombo(25);
	private JCalendarCombo published = FormUtils.newJCalendarCombo();
	private JComboBox category = FormUtils.newCombo(25);
	private String authorEditor = "authorEditor";
	
	private GuiFactory guiFactory;
	private PersistentService<Category, Long> categoryService;
	private AuthorService authorService;
	
	public BookView() {
		this(new Book());
	}
	
	public BookView(Book book) {
		setModel(book);
	}

	public void init() {
		bind(name, "name");
		bind(isbn, "isbn");
		bind(author, "author");
		bind(category, "category");
		bind(published, "publishedDate");
		
		refresh();
	}
	
	@Override
	protected JComponent buildPanel() {
		new AuthorCompletionListener(author);
		author.setEditable(true);
		Box authorBox = Box.createHorizontalBox();
		authorBox.add(author);
		authorBox.add(Box.createHorizontalStrut(5));
		authorBox.add(new JButton(new AddAuthorAction(FormUtils.getIcon(ADD_ICON))));
		
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.add("Title: ", name);
		fb.row();
		fb.add("Author: ", authorBox);
		fb.row();
		fb.add("ISBN: ", isbn);
		fb.row();
		fb.add("Published Date:", published);
		fb.row();
		fb.add("Category", category);
		
		JComponent form = fb.getForm();
		form.setBorder(FormUtils.createTitledBorder("Book"));
		return form;
	}
	
	@Override
	public void doRefresh() {
		if (category != null)
			category.setModel(new ListComboBoxModel(categoryService.getAll()));
	}
	
	private class AuthorCompletionListener extends AutoCompletionListener {

		public AuthorCompletionListener(JComboBox combo) {
			super(combo);
		}

		@Override
		protected List<?> getList(String editing) {
			return authorService.findByName(editing);
		}
		
	}
	
	private class AddAuthorAction extends AbstractAction  {

		public AddAuthorAction(Icon icon) {
			putValue(Action.SMALL_ICON, icon);
		}

		public void actionPerformed(ActionEvent e) {
			ViewDialog dlg = (ViewDialog) guiFactory.getDialog(authorEditor);
			dlg.setModal(true);
			dlg.setVisible(true);
			if (dlg.getValue() == ViewDialog.OK) {
				getModel().setAuthor((Author) dlg.getModel());
				refresh();
			}
			
		}
		
	}

	/**
	 * @return the guiFactory
	 */
	public GuiFactory getGuiFactory() {
		return guiFactory;
	}

	/**
	 * @param guiFactory the guiFactory to set
	 */
	public void setGuiFactory(GuiFactory guiFactory) {
		this.guiFactory = guiFactory;
	}

	/**
	 * @return the categoryService
	 */
	public PersistentService<Category, Long> getCategoryService() {
		return categoryService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(PersistentService<Category, Long> categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * @return the authorService
	 */
	public AuthorService getAuthorService() {
		return authorService;
	}

	/**
	 * @param authorService the authorService to set
	 */
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	/**
	 * @return the authorEditor
	 */
	public String getAuthorEditor() {
		return authorEditor;
	}

	/**
	 * @param authorEditor the authorEditor to set
	 */
	public void setAuthorEditor(String authorEditor) {
		this.authorEditor = authorEditor;
	}

}
