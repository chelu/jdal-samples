package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jdal.annotation.SerializableProxy;
import org.jdal.dao.Dao;
import org.jdal.dao.Page;
import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.samples.model.Author;
import org.jdal.samples.model.Category;
import org.jdal.ui.bind.Initializer;
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

	@Resource
	@SerializableProxy
	private Dao<Category, Long> categoryDao;
	@Resource 
	@SerializableProxy
	private Dao<Author, Long> authorDao;
	
	public BookFilterView() {
		this(new BookFilter());
	}

	public BookFilterView(BookFilter model) {
		super(model);
	}
	
	@PostConstruct
	public void init() {
		autobind();
		setInitializeControls(false);
		refresh();
	}

	/**
	 * Build {@link org.jdal.ui.View} component using a {@link BoxFormBuilder}
	 */
	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.setMargin(false);
		
		fb.row();
		fb.add(name, getMessage("Book.title"),  BoxFormBuilder.SIZE_FULL);
		fb.add(author, getMessage("Book.author"));
		fb.add(category, getMessage("Book.category"));
		fb.add(before, getMessage("BookFilter.publishedBefore"));
		fb.add(after, getMessage("BookFilter.publishedAfter"));
		fb.add(isbn, getMessage("Book.isbn"), 100);
		
		return fb.getForm();
	}

	
	/**
	 * Refresh category and author combos from Daos.
	 */
	@Override
	protected void doRefresh() {
		if (this.authorDao != null) {
			Page<Author> authors = new Page<Author>(Integer.MAX_VALUE, 1, "surname");
			FormUtils.fillCombo(this.author, this.authorDao.getPage(authors).getData());
		}
		
		if (this.categoryDao != null)  {
			Page<Category> categories = new Page<Category>(Integer.MAX_VALUE, 1, "name");
			FormUtils.fillCombo(this.category, this.categoryDao.getPage(categories).getData());
			
		}
	}
	
}
