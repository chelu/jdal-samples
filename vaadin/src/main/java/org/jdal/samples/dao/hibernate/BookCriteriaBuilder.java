package org.jdal.samples.dao.hibernate;

import org.hibernate.Criteria;
import org.jdal.dao.hibernate.AbstractCriteriaBuilder;
import org.jdal.samples.dao.filter.BookFilter;

/**
 * Criteria Builder for Book Filter
 * 
 * @author Jose Luis Martin
 */
public class BookCriteriaBuilder extends AbstractCriteriaBuilder {

	public Criteria build(Criteria criteria, Object filter) {
		BookFilter f = (BookFilter) filter;
		
		like(criteria, "name", f.getName());
		like(criteria, "isbn", f.getIsbn());
		eq(criteria, "category", f.getCategory());
		eq(criteria, "author", f.getAuthor());
		le(criteria, "publishedDate", f.getBefore());
		ge(criteria, "publishedDate", f.getAfter());
		
		return criteria;
	}
	
}
