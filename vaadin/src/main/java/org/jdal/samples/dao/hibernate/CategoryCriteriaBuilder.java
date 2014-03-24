package org.jdal.samples.dao.hibernate;

import org.hibernate.Criteria;
import org.jdal.dao.hibernate.AbstractCriteriaBuilder;
import org.jdal.samples.dao.filter.CategoryFilter;

/**
 * CreriaBuilder for {@link CategoryFilter}
 * 
 * @author Jose Luis Martin.
 * @since 2.0
 */
public class CategoryCriteriaBuilder extends AbstractCriteriaBuilder {
	
	private static final String NAME = "name";

	@Override
	public Criteria build(Criteria criteria, Object filter) {
		CategoryFilter f = (CategoryFilter) filter;
		like(criteria, NAME, f.getName());
		
		return criteria;
	}

}
