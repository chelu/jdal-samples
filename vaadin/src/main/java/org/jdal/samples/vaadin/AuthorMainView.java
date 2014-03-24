package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jdal.samples.model.Author;
import org.jdal.vaadin.ui.table.PageableTable;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class AuthorMainView extends VerticalLayout implements View {
	
	@Resource
	private PageableTable<Author> authorPageableTable;
	
	@PostConstruct
	public void init() {
		setSizeFull();
		setMargin(true);
		authorPageableTable.setWidthFull();
		addComponent(authorPageableTable);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
}
