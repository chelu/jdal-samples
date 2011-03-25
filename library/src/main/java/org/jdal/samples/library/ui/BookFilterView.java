package org.jdal.samples.library.ui;

import info.joseluismartin.gui.AbstractView;
import info.joseluismartin.gui.form.BoxFormBuilder;
import info.joseluismartin.gui.form.FormUtils;
import info.joseluismartin.gui.list.ListComboBoxModel;
import info.joseluismartin.service.PersistentService;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendarCombo;
import org.jdal.samples.library.dao.filter.BookFilter;
import org.jdal.samples.library.model.Category;

/**
 * View for Book Filter
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class BookFilterView extends AbstractView<BookFilter> {
	
	private JTextField name = new JTextField();
	private JTextField authorName = new JTextField();
	private JTextField authorSurname = new JTextField();
	private JCalendarCombo before = FormUtils.newJCalendarCombo();
	private JCalendarCombo after = FormUtils.newJCalendarCombo();
	private JComboBox category = FormUtils.newCombo(25);
	
	private PersistentService<Category, Long> categoryService;
	
	public BookFilterView() {
		this(new BookFilter());
	}
	
	public BookFilterView(BookFilter filter) {
		setModel(filter);
	}
	
	public void init() {
		bind(name, "name");
		bind(authorName, "authorName");
		bind(authorSurname, "authorSurname");
		bind(before, "before");
		bind(after, "after");
		bind(category, "category");
	}
	
	@Override
	protected JComponent buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		
		fb.add("Title: ", name);
		fb.add("Author Name: ", authorName);
		fb.add("Author Surname: ", authorSurname);
		fb.row();
		fb.add("Category: ", category);
		fb.add("Published Before: ", before);
		fb.add("Published After: ", after);
		
		JComponent box = fb.getForm();
		box.setBorder(FormUtils.createTitledBorder("Book Filter"));
		
		return box;
	}
	
	@Override
	public void doRefresh() {
		List<Category> categories = categoryService.getAll();
		categories.add(0, null);
		category.setModel(new ListComboBoxModel(categories));
		
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

	
}
