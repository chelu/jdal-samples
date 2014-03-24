package org.jdal.samples.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.jdal.dao.UserDao;
import org.jdal.dao.hibernate.HibernateDao;
import org.jdal.samples.model.User;


public class UserHibernateDao extends HibernateDao<User, Long> implements UserDao {
	
	private static final String USERNAME = "username";

	public UserHibernateDao() {
		this(User.class);
	}
	
	public UserHibernateDao(Class<User> persistentClass) {
		super(persistentClass);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User findByUsername(String username) {
		List users = getSession().createCriteria(User.class)
			.add(Restrictions.eq(USERNAME, username))
			.list();
		
		return (User) (users.size() > 0 ? users.get(0) : null);
	}

}
