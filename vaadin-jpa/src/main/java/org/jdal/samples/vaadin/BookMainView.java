package org.jdal.samples.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jdal.samples.model.Book;
import org.jdal.vaadin.ui.table.PageableTable;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class BookMainView extends VerticalLayout implements View {
	
	@Resource
	private PageableTable<Book> bookPageableTable;
	
	@PostConstruct
	public void init() {
		setSizeFull();
		this.bookPageableTable.setWidthFull();
		setMargin(true);
		addComponent(bookPageableTable);
	}
	
	/**
	 * Refresh table when entering in the View
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		this.bookPageableTable.refresh();
	}

}
