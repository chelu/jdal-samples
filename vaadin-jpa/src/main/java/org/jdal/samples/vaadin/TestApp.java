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
import info.joseluismartin.vaadin.ui.table.PageableTable;

import org.jdal.samples.model.Book;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 * Simple Test for PageableTable and ContainerDataSource.
 * 
 * @author Jose Luis Martin
 */
@SuppressWarnings("serial")
public class TestApp extends Application {
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		Window mainWindow = new Window("JDAL Vaadin Sample");
		Label title = new Label("JDAL Vaadin Sample Application");
		title.setStyleName(Reindeer.LABEL_H1);
		PageableTable<Book> pageableTable = (PageableTable<Book>) AppCtx.getInstance().getBean("bookPageableTable");
		Panel panel = new Panel("Table with external paginator and server side paging and sorting");
		panel.addComponent(pageableTable);
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
        layout.addComponent(title);
		layout.addComponent(panel);
		mainWindow.setContent(layout);
		setMainWindow(mainWindow);
	}
}
