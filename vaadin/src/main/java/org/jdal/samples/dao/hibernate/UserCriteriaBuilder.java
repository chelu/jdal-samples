package org.jdal.samples.dao.hibernate;

import org.hibernate.Criteria;
import org.jdal.dao.hibernate.AbstractCriteriaBuilder;
import org.jdal.samples.dao.filter.UserFilter;

public class UserCriteriaBuilder extends AbstractCriteriaBuilder {
	
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String USERNAME = "username";
	private static final String REGISTER_DATE = "registerDate";

	@Override
	public Criteria build(Criteria criteria, Object filter) {
		UserFilter f = (UserFilter) filter;
		like(criteria, NAME, f.getName());
		like(criteria, SURNAME, f.getSurname());
		like(criteria, USERNAME, f.getUsername());
		le(criteria, REGISTER_DATE, f.getRegisteredBefore());
		ge(criteria, REGISTER_DATE, f.getRegisteredAfter());
		
		return criteria;
	}

}
