package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;

import org.jdal.samples.model.Role;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

/**
 * View editor for {@link Role Roles}
 * 
 * @author Jose Luis Martin
 * @since 2.1
 */
public class RoleView extends AbstractView<Role> {
	
	private TextField role = FormUtils.newTextField();
	
	public RoleView() {
		this(new Role());
	}

	public RoleView(Role model) {
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
		fb.row();
		fb.add(role, getMessage("role"));
		
		return fb.getForm();
	}

}
