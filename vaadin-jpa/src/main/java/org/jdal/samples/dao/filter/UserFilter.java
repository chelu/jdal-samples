package org.jdal.samples.dao.filter;

import java.util.Date;

import org.jdal.dao.BeanFilter;

public class UserFilter extends BeanFilter {

	private String username;
	private String name;
	private String surname;
	private String mail;
	private Date registeredBefore;
	private Date registeredAfter;
	
	public UserFilter() {
		this("userFilter");
	}

	public UserFilter(String filterName) {
		super(filterName);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getRegisteredBefore() {
		return registeredBefore;
	}

	public void setRegisteredBefore(Date registeredBefore) {
		this.registeredBefore = registeredBefore;
	}

	public Date getRegisteredAfter() {
		return registeredAfter;
	}

	public void setRegisteredAfter(Date registeredAfter) {
		this.registeredAfter = registeredAfter;
	}

	
}
