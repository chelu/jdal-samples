package org.jdal.samples.vaadin;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.jdal.samples.model.Book;
import org.jdal.vaadin.VaadinUtils;
import org.jdal.vaadin.ui.table.PageableTable;
import org.springframework.util.SerializationUtils;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class BookMainView extends VerticalLayout implements View {
	
	@Resource
	private PageableTable<Book> bookPageableTable;
	
	@PostConstruct
	public void init() {
		setSizeFull();
		bookPageableTable.setWidthFull();
		setMargin(true);
		addComponent(bookPageableTable);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Enumeration<String> e = VaadinUtils.getSession().getAttributeNames();
		Map<String, Object> map = new HashMap<String, Object>();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			map.put(name, VaadinUtils.getSession().getAttribute(name));
		}
		
		try {
			FileUtils.writeByteArrayToFile(new File("/tmp/session.ser"), SerializationUtils.serialize(map));
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
	}

}
