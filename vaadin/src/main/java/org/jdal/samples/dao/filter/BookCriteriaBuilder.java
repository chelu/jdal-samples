package org.jdal.samples.dao.filter;

import org.hibernate.Criteria;
import org.jdal.dao.hibernate.AbstractCriteriaBuilder;
import org.springframework.util.StringUtils;

/**
 * Criteria Builder for Book Filter
 * 
 * @author Jose Luis Martin
 */
public class BookCriteriaBuilder extends AbstractCriteriaBuilder {

	public Criteria build(Criteria criteria, Object filter) {
		BookFilter f = (BookFilter) filter;
		
		like(criteria, "name", f.getName());
		eq(criteria, "category", f.getCategory());
		le(criteria, "publishedDate", f.getBefore());
		ge(criteria, "publishedDate", f.getAfter());
		
		// Author
		if (StringUtils.hasText(f.getAuthorName()) || StringUtils.hasText(f.getAuthorSurname())) {
			criteria.createAlias("author", "author");
			like(criteria, "author.name", f.getAuthorName());
			like(criteria, "author.surname", f.getAuthorSurname());
		}
		
		return criteria;
	}
	
}
