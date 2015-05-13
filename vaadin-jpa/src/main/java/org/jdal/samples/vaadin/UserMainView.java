package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jdal.beans.MessageSourceWrapper;
import org.jdal.samples.model.Role;
import org.jdal.samples.model.User;
import org.jdal.vaadin.annotation.ViewConfig;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.table.PageableTable;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

@ViewConfig(access="ROLE_ADMIN")
public class UserMainView extends VerticalLayout implements View {

	@Resource
	private PageableTable<User> userPageableTable;
	@Resource
    private PageableTable<Role> rolePageableTable;
	@Autowired
	private MessageSourceWrapper messageSource;
	
	@PostConstruct
	public void init() {
		setSizeFull();
		setMargin(true);
		setSpacing(true);
		this.userPageableTable.setWidthFull();
		this.rolePageableTable.setWidthFull();
		addComponent(FormUtils.createTitledSeparator(this.messageSource.getMessage("users")));
		addComponent(this.userPageableTable);
		addComponent(FormUtils.createTitledSeparator(this.messageSource.getMessage("roles")));
		addComponent(this.rolePageableTable);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.userPageableTable.refresh();
		this.rolePageableTable.refresh();
		
	}
}
