package org.jdal.samples.vaadin;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.jdal.samples.model.Author;
import org.jdal.vaadin.ui.table.PageableTable;
import org.springframework.util.SerializationUtils;

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
		byte[] ser = new byte[0];
		try {
			ser = FileUtils.readFileToByteArray(new File("/tmp/session.ser"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> map = (Map<String, Object>) SerializationUtils.deserialize(ser);
		
		System.out.println(map);
	}
	
}
