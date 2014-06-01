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

import org.jdal.vaadin.ui.Box;
import org.jdal.vaadin.ui.SimpleApplicationUI;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;

/**
 * Sample Application UI
 * 
 * @author Jose Luis Martin
 */
@Theme("sample")
@PreserveOnRefresh
@Title("JDAL Vaadin Sample")
public class TestApp extends SimpleApplicationUI {

	@Override
	protected void buildMain() {
		super.buildMain();
		Label logo = new Label("JDAL Vaadin");
		logo.setStyleName("app-title");
		logo.setSizeUndefined();
		this.top.setExpandRatio(getButtonBar(), 10);
		this.top.addComponent(logo);
		this.top.setComponentAlignment(logo, Alignment.MIDDLE_RIGHT);
		Box.addHorizontalStruct(top, 20);
		// go to first button
		this.buttonBar.click(null);
	}
	
}
