package org.jdal.samples;

import java.util.ArrayList;
import java.util.List;

import org.jdal.vaadin.annotation.UiMapping;
import org.jdal.vaadin.data.ListBeanContainer;
import org.springframework.stereotype.Component;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@Component
@UiMapping("/test/**")
@SuppressWarnings("unused")
public class TestUI extends UI {
	
	@Override
	protected void init(VaadinRequest request) {
	    HorizontalLayout horizontalLayout = new HorizontalLayout();
	    Values values = new Values();
	    values.setOtherValues(new Values());
	    Grid grid = new Grid();
	    grid.addColumn("values[1]");
	    List<Values> list = new ArrayList<Values>();
	    list.add(values);
	    
	    ListBeanContainer lbContainer = new ListBeanContainer(Values.class, list);
	    lbContainer.addProperty("values[1]");
	    grid.setContainerDataSource(lbContainer);
	    horizontalLayout.addComponent(grid);
	    horizontalLayout.setWidth(100, Unit.PERCENTAGE);
	    setContent(horizontalLayout);
	}
	
	private class Values {
		private String[] values = { "one", "two", "three" };
		private Values otherValues;

		
		public String[] getValues() {
			return values;
		}
		
		public void setValues(String[] values) {
			this.values = values;
		}
		
		/**
		 * @return the otherValues
		 */
		public Values getOtherValues() {
			return otherValues;
		}

		/**
		 * @param otherValues the otherValues to set
		 */
		public void setOtherValues(Values otherValues) {
			this.otherValues = otherValues;
		}

		
		
	}

}
