package org.jdal.samples.dao.hibernate;

import info.joseluismartin.dao.hibernate.HibernateDao;

import java.util.List;

import org.hibernate.Filter;
import org.jdal.samples.dao.AuthorDao;
import org.jdal.samples.model.Author;

/**
 * Author Dao hibernate implementation
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class AuthorHibernateDao extends HibernateDao<Author, Long> implements AuthorDao {

	public AuthorHibernateDao() {
		super(Author.class);
	}
	
	public List<Author> findByName(String pattern) {
		String name = pattern.trim() + "%";
		Filter filter = getSession().enableFilter("authorByNameFilter");
		filter.setParameter("pattern", name);
		
		return getAll();
	}
}
