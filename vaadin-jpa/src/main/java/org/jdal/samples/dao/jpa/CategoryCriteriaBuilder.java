package org.jdal.samples.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.jdal.dao.Filter;
import org.jdal.dao.jpa.JpaCriteriaBuilderSupport;
import org.jdal.samples.dao.filter.CategoryFilter;
import org.jdal.samples.model.Category;
import org.springframework.util.StringUtils;

/**
 * CreriaBuilder for {@link CategoryFilter}
 * 
 * @author Jose Luis Martin.
 * @since 2.0
 */
public class CategoryCriteriaBuilder extends JpaCriteriaBuilderSupport<Category, Category> {
	
	private static final String NAME = "name";
	
	public CategoryCriteriaBuilder() {
		super(Category.class);
	}

	@Override
	protected void doBuild(CriteriaQuery<Category> criteria,
			CriteriaBuilder cb, Filter filter) {
		
		CategoryFilter f = (CategoryFilter) filter;
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(f.getName()))
			predicates.add(like(NAME, f.getName()));
		
		addAndWhere(criteria, cb, predicates);
	}

}
