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
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class BookCriteriaBuilder extends JpaCriteriaBuilderSupport<Book, Book> {


	public BookCriteriaBuilder() {
		super(Book.class);
	}

	@Override
	protected void doBuild(CriteriaQuery<Book> criteria, CriteriaBuilder cb, Filter filter) {
		BookFilter f = (BookFilter) filter;
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		addPredicateIfNotNull(predicates, equal("category", f.getCategory()));
		addPredicateIfNotNull(predicates, lessThanOrEqualTo("publishedDate", f.getBefore()));
		addPredicateIfNotNull(predicates, greatThanOrEqualTo("publishedDate", f.getAfter()));
		
		if (StringUtils.isNotEmpty(f.getName()))
			predicates.add(like("name", f.getName()));
		
		if (StringUtils.isNotEmpty(f.getAuthorName()))
			 predicates.add(like("author.name", f.getAuthorName()));
		
		if (StringUtils.isNotEmpty(f.getAuthorSurname()))
			predicates.add(like("author.surname", f.getAuthorSurname()));
		
		if (StringUtils.isNotEmpty(f.getIsbn()))
			predicates.add(like("isbn", f.getIsbn()));

		addAndWhere(criteria, cb, predicates);
	}
}
