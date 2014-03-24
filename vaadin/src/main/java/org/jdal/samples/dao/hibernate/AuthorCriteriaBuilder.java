package org.jdal.samples.dao.hibernate;

import org.hibernate.Criteria;
import org.jdal.dao.hibernate.AbstractCriteriaBuilder;
import org.jdal.samples.dao.filter.AuthorFilter;

/**
 * CriteriaBuilder for Author entity.
 * 
 * @author Jose Luis Martin
 * @since 2.0
 */
public class AuthorCriteriaBuilder extends AbstractCriteriaBuilder {

	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	
	@Override
	public Criteria build(Criteria criteria, Object filter) {
		AuthorFilter f = (AuthorFilter) filter;
		like(criteria, NAME, f.getName());
		like(criteria, SURNAME, f.getSurname());
		
		return criteria;
	}

}
