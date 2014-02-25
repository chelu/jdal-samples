package org.jdal.samples.library.ui;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendarCombo;
import org.jdal.beans.AppCtx;
import org.jdal.dao.Dao;
import org.jdal.samples.library.dao.filter.BookFilter;
import org.jdal.samples.library.model.Category;
import org.jdal.service.PersistentService;
import org.jdal.swing.AbstractView;
import org.jdal.swing.ApplicationContextGuiFactory;
import org.jdal.swing.View;
import org.jdal.swing.form.BoxFormBuilder;
import org.jdal.swing.form.FormUtils;
import org.jdal.swing.list.ListComboBoxModel;

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
	private JComboBox<Category> category = FormUtils.newCombo(Category.class, 15);
	
	private Dao<Category, Long> categoryService;
	
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
	public Dao<Category, Long> getCategoryService() {
		return categoryService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(Dao<Category, Long> categoryService) {
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
