package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;

import org.jdal.samples.dao.filter.CategoryFilter;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

public class CategoryFilterView extends AbstractView<CategoryFilter> {

	private TextField name = FormUtils.newTextField();
	
	public CategoryFilterView() {
		this(new CategoryFilter());
	}

	public CategoryFilterView(CategoryFilter model) {
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
		fb.add(name, getMessage("categoryName"));
		
		return fb.getForm();
	}
	

}
