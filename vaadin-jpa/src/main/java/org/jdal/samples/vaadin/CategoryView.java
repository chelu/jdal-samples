package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;

import org.jdal.samples.model.Category;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

public class CategoryView extends AbstractView<Category> {

	private TextField name = FormUtils.newTextField();
	
	public CategoryView() {
		this(new Category());
	}

	public CategoryView(Category model) {
		super(model);
	}

	@PostConstruct
	public void init() {
		autobind();
	}
	
	@Override
	protected Component buildPanel() {
		throw new org.springframework.security.access.AccessDeniedException("No se puede");
//		BoxFormBuilder fb = new BoxFormBuilder();
//		fb.setDefaultWidth(BoxFormBuilder.SIZE_FULL);
//		fb.setMargin(false);
//		fb.row();
//		fb.add(name, getMessage("categoryName"));
//		
//		return fb.getForm();
	}

}
