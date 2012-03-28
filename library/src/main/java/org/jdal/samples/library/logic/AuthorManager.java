package org.jdal.samples.library.logic;

import info.joseluismartin.logic.PersistentManager;

import java.util.List;

import org.jdal.samples.library.dao.AuthorDao;
import org.jdal.samples.library.model.Author;
import org.jdal.samples.library.service.AuthorService;

/**
 * Author Service 
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class AuthorManager extends PersistentManager<Author, Long> implements AuthorService {

	public List<Author> findByName(String pattern) {
		return getAuthorDao().findByName(pattern);
	}
	
	public AuthorDao getAuthorDao() {
		return (AuthorDao) dao;
	}
	
}
