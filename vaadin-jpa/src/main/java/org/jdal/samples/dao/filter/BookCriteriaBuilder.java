package org.jdal.samples.dao.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.apache.commons.lang.StringUtils;
import org.jdal.dao.Filter;
import org.jdal.dao.jpa.JpaCriteriaBuilderSupport;
import org.jdal.samples.model.Book;

/**
 * Criteria Builder for Book Filter
 * 
 * @author Jose Luis Martin
 */
public class BookCriteriaBuilder extends JpaCriteriaBuilderSupport<Book, Book> {

	public BookCriteriaBuilder() {
		super(Book.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doBuild(CriteriaQuery<Book> criteria, CriteriaBuilder cb, Filter filter) {
		BookFilter f = (BookFilter) filter;
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(f.getName()))
			predicates.add(like("name", f.getName()));
		
		if (!StringUtils.isEmpty(f.getAuthorName()))
			predicates.add(like("author.name", f.getAuthorName()));
		
		if (!StringUtils.isEmpty(f.getAuthorSurname()))
			predicates.add(like("author.surname", f.getAuthorSurname()));
		
		if (f.getCategory() != null)
			predicates.add(equal("category", f.getCategory()));
		
		if (f.getAfter() != null) 
			predicates.add(greatThanOrEqualTo("publishedDate", f.getAfter()));
		
		if (f.getBefore() != null)
			predicates.add(lessThanOrEqualTo("publishedDate", f.getBefore()));
		
		if (!predicates.isEmpty())
			addAndWhere(criteria, cb, predicates);
	}
}
