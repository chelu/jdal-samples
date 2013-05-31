package org.jdal.samples.library.ui;

import java.awt.event.ActionEvent;

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
import org.jdal.service.PersistentService;
import org.jdal.swing.AbstractView;
import org.jdal.swing.GuiFactory;
import org.jdal.swing.ViewDialog;
import org.jdal.swing.action.FilterAutoCompletionListener;
import org.jdal.swing.form.BoxFormBuilder;
import org.jdal.swing.form.FormUtils;
import org.jdal.swing.list.ListComboBoxModel;

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
	private JCalendarCombo publishedDate =  new JCalendarCombo();
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
		autobind(); //  bind controls by property name
	}
	
	@Override
	protected JComponent buildPanel() {
		// fill category combo with data from database.
		category.setModel(new ListComboBoxModel(categoryService.getAll()));
		// Add auto-completion to author combo, limit max results to 1000 and order data by surname
		FilterAutoCompletionListener acl = new FilterAutoCompletionListener(author, 1000, "surname");
		acl.setPersistentService(authorService);
		author.setEditable(true);
		// Create a Box with author combo and add button
		Box authorBox = Box.createHorizontalBox();
		authorBox.add(author);
		authorBox.add(Box.createHorizontalStrut(5));
		authorBox.add(new JButton(new AddAuthorAction(FormUtils.getIcon(ADD_ICON))));
		// Build Form with a BoxFormBuilder
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.add(getMessage("Title"), name);
		fb.row();
		fb.add(getMessage("Author"), authorBox);	
		fb.row();
		fb.add(getMessage("ISBN"), isbn);
		fb.row();
		fb.add(getMessage("PublishedDate"), publishedDate);
		fb.row();
		fb.add(getMessage("Category"), category);
		
		JComponent form = fb.getForm();
		form.setBorder(FormUtils.createTitledBorder(getMessage("Book")));
		return form;
	}
	

	
	private class AddAuthorAction extends AbstractAction  {

		public AddAuthorAction(Icon icon) {
			putValue(Action.SMALL_ICON, icon);
		}

		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			
			ViewDialog<Author> dlg = (ViewDialog<Author>) guiFactory.getDialog(authorEditor);
			dlg.setModal(true);
			dlg.setVisible(true);
			if (dlg.getValue() == ViewDialog.OK) {
				getModel().setAuthor((Author) dlg.getModel());
				author.addItem(dlg.getModel());
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
