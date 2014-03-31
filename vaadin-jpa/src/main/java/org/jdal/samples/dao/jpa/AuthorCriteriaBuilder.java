package org.jdal.samples.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.jdal.dao.Filter;
import org.jdal.dao.jpa.JpaCriteriaBuilderSupport;
import org.jdal.samples.dao.filter.AuthorFilter;
import org.jdal.samples.model.Author;
import org.springframework.util.StringUtils;

import com.ctc.wstx.util.StringUtil;

/**
 * CriteriaBuilder for Author entity.
 * 
 * @author Jose Luis Martin
 * @since 2.0
 */
public class AuthorCriteriaBuilder extends JpaCriteriaBuilderSupport<Author, Author> {
	
	private static final String NAME = "name";
	private static final String SURNAME = "surname";

	public AuthorCriteriaBuilder() {
		super(Author.class);
	}
	
	@Override
	protected void doBuild(CriteriaQuery<Author> criteria, CriteriaBuilder cb,
			Filter filter) {
		
		AuthorFilter f = (AuthorFilter) filter;
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(f.getName()))
			predicates.add(like(NAME, f.getName()));
			
		if (!StringUtils.isEmpty(f.getSurname()))
			predicates.add(like(SURNAME, f.getSurname()));
		
		addAndWhere(criteria, cb, predicates);
	}

}
