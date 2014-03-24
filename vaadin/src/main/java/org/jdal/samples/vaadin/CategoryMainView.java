package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jdal.samples.model.Category;
import org.jdal.vaadin.ui.table.PageableTable;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class CategoryMainView extends VerticalLayout implements View {
	
	@Resource
	private PageableTable<Category> categoryPageableTable;

	@PostConstruct
	public void init() {
		setSizeFull();
		setMargin(true);
		categoryPageableTable.setWidthFull();
		addComponent(categoryPageableTable);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
