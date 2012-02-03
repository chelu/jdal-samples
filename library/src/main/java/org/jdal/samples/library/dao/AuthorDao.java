package org.jdal.samples.library.dao;

import info.joseluismartin.dao.Dao;

import java.util.List;

import org.jdal.samples.library.model.Author;


/**
 * AuthorDao, add Author finders to Dao interface
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public interface AuthorDao extends Dao<Author, Long> {
	
	List<Author> findByName(String pattern);
}
