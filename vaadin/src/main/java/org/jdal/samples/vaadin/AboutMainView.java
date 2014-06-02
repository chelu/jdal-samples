package org.jdal.samples.vaadin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.jdal.beans.MessageSourceWrapper;
import org.jdal.vaadin.ui.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * Show About info.
 * 
 * @author Jose Luis Martin
 * @since 2.0
 */
public class AboutMainView extends TabSheet implements View {

	private MessageSourceWrapper messageSource = new MessageSourceWrapper();
	private VerticalLayout aboutPanel;
	private VerticalLayout thirdPartyLibrariesPanel;
	private Resource logo;
	
	@PostConstruct
	public void init() {
		setStyleName(Reindeer.TABSHEET_MINIMAL);
		addTabComponent("about", getAboutPanel());
		addTabComponent("thirdPartyLibraries", getThirdPartyLibrariesPanel());
	}
	
	private void addTabComponent(String caption, Component component) {
		addTab(component, messageSource.getMessage(caption));
	}
	
	private Component getAboutPanel() {
		if (aboutPanel == null) {
			this.aboutPanel = createVerticalLayout();
			HorizontalLayout hl = new HorizontalLayout();
			try {
				hl.setMargin(false);
				logo = new ExternalResource(new URL("http://www.jdal.org/images/jdal-logo.png"));
				Image img = new Image(null, logo);
				hl.addComponent(img);
				hl.setComponentAlignment(img, Alignment.TOP_LEFT);
			} 
			catch (MalformedURLException e) {}
			
			Box.addHorizontalStruct(hl, 20);
			String about = "<b>JDAL Vaadin Library Demo</b><br><br>Version: 2.0.0<br><br>" + 
					"&copy; Jose Luis Martin, all rights reserved.<br><br>" +
					"Source code at <a href='https://github.com/chelu/jdal-samples/tree/master/vaadin'>" +
					"https://github.com/chelu/jdal-samples/tree/master/vaadin</a><br><br>" +
					"See <a href='http://www.jdal.org'> http://www.jdal.org</a> for more info.";
					
			Label aboutLabel = new Label(about, ContentMode.HTML);
			hl.addComponent(aboutLabel);
			this.aboutPanel.addComponent(hl);
		}
		
		return this.aboutPanel;
	}

	/**
	 * 
	 */
	private VerticalLayout createVerticalLayout() {
		VerticalLayout vl = new VerticalLayout();
		vl.setSizeFull();
		vl.setMargin(true);
		
		return vl;
	}
	
	private Component getThirdPartyLibrariesPanel() {
		if (thirdPartyLibrariesPanel == null) {
			thirdPartyLibrariesPanel = createVerticalLayout();
			String tpl;
			try {
				tpl = IOUtils.toString(getClass().getResourceAsStream("/html/third_party_libraries.html"));
				Label tplLabel = new Label(tpl, ContentMode.HTML);
				thirdPartyLibrariesPanel.addComponent(tplLabel);
			} catch (IOException e) {
			}
		}

		return thirdPartyLibrariesPanel;
	}
	
	@Override
	public void enter(ViewChangeEvent event) {

	}
	
	public MessageSource getMessageSource() {
		return messageSource.getMessageSource();
	}
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource.setMessageSource(messageSource);
	}

}
