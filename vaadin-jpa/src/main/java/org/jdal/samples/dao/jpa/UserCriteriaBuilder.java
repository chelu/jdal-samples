package org.jdal.samples.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.jdal.dao.Filter;
import org.jdal.dao.jpa.JpaCriteriaBuilderSupport;
import org.jdal.samples.dao.filter.UserFilter;
import org.jdal.samples.model.User;
import org.springframework.util.StringUtils;

public class UserCriteriaBuilder extends JpaCriteriaBuilderSupport<User, User> {
	
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String USERNAME = "username";
	private static final String REGISTER_DATE = "registerDate";
	
	public UserCriteriaBuilder() {
		super(User.class);
	}

	@Override
	protected void doBuild(CriteriaQuery<User> criteria, CriteriaBuilder cb,
			Filter filter) {

		UserFilter f = (UserFilter) filter;
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(f.getName()))
			predicates.add(like(NAME, f.getName()));
		
		if (!StringUtils.isEmpty(f.getSurname()))
			predicates.add(like(SURNAME, f.getSurname()));
		
		if (!StringUtils.isEmpty(f.getUsername()))
			predicates.add(like(USERNAME, f.getUsername()));
		
		addPredicateIfNotNull(predicates, lessThanOrEqualTo(REGISTER_DATE, f.getRegisteredBefore()));
		addPredicateIfNotNull(predicates, greatThanOrEqualTo(REGISTER_DATE, f.getRegisteredAfter()));
		
		addAndWhere(criteria, cb, predicates);
	}

}
