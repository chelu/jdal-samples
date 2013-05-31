package org.jdal.samples.library.dao.hibernate;

import java.util.List;

import org.hibernate.Filter;
import org.jdal.dao.hibernate.HibernateDao;
import org.jdal.samples.library.dao.AuthorDao;
import org.jdal.samples.library.model.Author;

/**
 * Author Dao hibernate implementation
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class AuthorHibernateDao extends HibernateDao<Author, Long> implements AuthorDao {

	public AuthorHibernateDao() {
		this(Author.class);
	}
	
	public AuthorHibernateDao(Class<Author> clazz) {
		super(clazz);
	}

	public List<Author> findByName(String pattern) {
		String name = pattern.trim() + "%";
		Filter filter = getSession().enableFilter("authorByNameFilter");
		filter.setParameter("pattern", name);
		
		return getAll();
	}

}
