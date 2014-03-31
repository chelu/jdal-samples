package org.jdal.samples.dao.filter;

import org.jdal.dao.BeanFilter;

public class CategoryFilter extends BeanFilter {

	private String name;
	
	public CategoryFilter() {
		this("categoryFilter");
	}

	public CategoryFilter(String filterName) {
		super(filterName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
