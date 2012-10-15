package org.jdal.samples.library.dao.hibernate;

import info.joseluismartin.dao.hibernate.HibernateDao;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.jdal.samples.library.dao.AuthorDao;
import org.jdal.samples.library.model.Author;
import org.jdal.samples.library.model.Book;

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
	
	public Book findBookById(int id) {
		Query q = getSession().getNamedQuery("test");
		q.setParameter("id", 7);
		
		return (Book) q.list().get(0);
	}
}
