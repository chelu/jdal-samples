package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;

import org.jdal.samples.dao.filter.UserFilter;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

/**
 * {@link View} for {@link UserFilter}.
 * 
 * @author Jose Luis Martin
 * @since 2.0
 */
public class UserFilterView extends AbstractView<UserFilter> {

	private TextField username = FormUtils.newTextField();
	private TextField name = FormUtils.newTextField();
	private TextField surname = FormUtils.newTextField();
	private DateField registeredBefore = FormUtils.newDateField();
	private DateField registeredAfter = FormUtils.newDateField();
	
	public UserFilterView() {
		this(new UserFilter());
	}

	public UserFilterView(UserFilter model) {
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
		fb.add(username, getMessage("username"));
		fb.add(name, getMessage("name"));
		fb.add(surname, getMessage("surname"));
		fb.add(registeredAfter, getMessage("registeredAfter"), 120);
		fb.add(registeredBefore, getMessage("registeredBefore"), 120);
		
		return fb.getForm();
	}

}
