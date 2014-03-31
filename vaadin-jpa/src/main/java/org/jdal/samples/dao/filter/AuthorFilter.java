package org.jdal.samples.dao.filter;

import org.jdal.dao.BeanFilter;


/**
 * Filter for Author entity.
 * 
 * @author Jose Luis Martin
 * @since 2.0
 */
public class AuthorFilter extends BeanFilter {

	private String name;
	private String surname;
	
	public AuthorFilter() {
		this("authorFilter");
	}

	public AuthorFilter(String filterName) {
		super(filterName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
