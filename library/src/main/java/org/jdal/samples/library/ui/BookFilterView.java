package org.jdal.samples.library.ui;

import info.joseluismartin.beans.AppCtx;
import info.joseluismartin.gui.AbstractView;
import info.joseluismartin.gui.ApplicationContextGuiFactory;
import info.joseluismartin.gui.View;
import info.joseluismartin.gui.form.BoxFormBuilder;
import info.joseluismartin.gui.form.FormUtils;
import info.joseluismartin.gui.list.ListComboBoxModel;
import info.joseluismartin.service.PersistentService;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
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
	
	private JTextField name = new JTextField(15);
	private JTextField authorName = new JTextField(15);
	private JTextField authorSurname = new JTextField(15);
	private JCalendarCombo before = new JCalendarCombo();
	private JCalendarCombo after = new JCalendarCombo();
	private JComboBox category = FormUtils.newCombo(15);
	
	private PersistentService<Category, Long> categoryService;
	
	public BookFilterView() {
		this(new BookFilter());
	}
	
	public void init() {
			autobind();
	}
	
	public BookFilterView(BookFilter filter) {
		setModel(filter);
	}
	
	
	@Override
	protected JComponent buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		
		fb.add(getMessage("Title"), name);
		fb.add(getMessage("Author.name"), authorName);
		fb.add(getMessage("Author.surname"), authorSurname);
		fb.row();
		fb.add(getMessage("Category"), category);
		fb.add(getMessage("PublishedBefore"), before);
		fb.add(getMessage("PublishedAfter"), after);
		
		JComponent box = fb.getForm();
		box.setBorder(FormUtils.createTitledBorder(getMessage("Book.filter")));
		
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

	public static void main(String[] args) {
		ApplicationContextGuiFactory.setPlasticLookAndFeel();
		View<?> view = (View<?>) AppCtx.getInstance().getBean("filterView");
		JFrame f = new JFrame();
		f.add(view.getPanel());
		f.setVisible(true);
	}
	
}
