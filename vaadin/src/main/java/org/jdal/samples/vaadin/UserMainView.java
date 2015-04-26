package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jdal.samples.model.User;
import org.jdal.vaadin.ui.table.PageableTable;
import org.json.JSONArray;
import org.json.JSONException;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClientConnector.AttachListener;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UserMainView extends VerticalLayout implements View {

	@Resource
	private PageableTable<User> userPageableTable;
	
	@PostConstruct
	public void init() {
		setSizeFull();
		setMargin(true);
		this.userPageableTable.setWidthFull();
		addComponent(this.userPageableTable);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		
	}
}

