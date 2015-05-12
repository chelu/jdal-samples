package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jdal.samples.model.User;
import org.jdal.vaadin.annotation.ViewConfig;
import org.jdal.vaadin.ui.table.PageableTable;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

@ViewConfig(access="ROLE_ADMIN")
public class UserMainView extends VerticalLayout implements View {

	@Resource
	private PageableTable<User> userPageableTable;
	
	@PostConstruct
	public void init() {
		setSizeFull();
		setMargin(true);
		userPageableTable.setWidthFull();
		addComponent(userPageableTable);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
