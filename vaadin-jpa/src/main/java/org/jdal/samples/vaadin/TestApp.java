/*
 * Copyright 2009-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdal.samples.vaadin;

import info.joseluismartin.beans.AppCtx;
import info.joseluismartin.vaadin.data.ContainerDataSource;
import info.joseluismartin.vaadin.ui.Box;
import info.joseluismartin.vaadin.ui.table.PageableTable;

import org.jdal.samples.dao.filter.BookFilter;
import org.jdal.samples.model.Book;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;

/**
 * Simple Test for PageableTable and ContainerDataSource.
 * 
 * @author Jose Luis Martin
 */
@SuppressWarnings("serial")
public class TestApp extends Application {
	
	private PageableTable<Book> pageableTable;
	private BookFilterView bookFilterView;
	private Table dataSourceTable;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		Window mainWindow = new Window("JDAL Vaadin Sample");
		Label title = new Label("JDAL Vaadin Sample Application");
		title.setStyleName(Reindeer.LABEL_H1);
		
		pageableTable = (PageableTable<Book>) AppCtx.getInstance().getBean("bookPageableTable");
		bookFilterView = (BookFilterView) AppCtx.getInstance().getBean("bookFilterView");
		dataSourceTable = (Table) AppCtx.getInstance().getBean("dataSourceTable");	
		BookFilter bf = bookFilterView.getModel();
		
		Button applyFilterButton = new Button("Apply Filter", new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				// on pageable table update the filter and request first page
				bookFilterView.update();
				pageableTable.getPaginator().firstPage();
				// on table with datasource ge the ContainerDataSource reference and set the filter
				ContainerDataSource cds = (ContainerDataSource) dataSourceTable.getContainerDataSource();
				cds.setFilter(bookFilterView.getModel());
			}
		});		
		
		pageableTable.getPaginator().getModel().setFilter(bf);
		Panel panel = new Panel("Table with external paginator and server side paging and sorting");
		panel.addComponent(bookFilterView.buildPanel());
		
		VerticalLayout vl = new VerticalLayout();
		Box.addVerticalStruct(vl, 10);
		vl.addComponent(applyFilterButton);
		Box.addVerticalStruct(vl, 10);
		panel.addComponent(vl);
		panel.addComponent(pageableTable);
		Panel otherPanel = new Panel("Table with paginator in datasource and server side paging and sorting ");
		otherPanel.addComponent(dataSourceTable);
		VerticalLayout layout = new VerticalLayout();
        Box.addVerticalStruct(layout, 10);
        layout.addComponent(title);
        Box.addVerticalStruct(layout, 10);
		layout.addComponent(panel);
		Box.addVerticalStruct(layout, 10);
		layout.addComponent(otherPanel);
		mainWindow.setContent(layout);
		setMainWindow(mainWindow);
	}
}
