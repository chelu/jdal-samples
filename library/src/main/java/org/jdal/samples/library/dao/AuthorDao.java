package org.jdal.samples.library.dao;

import java.util.List;

import org.jdal.dao.Dao;
import org.jdal.samples.library.model.Author;


/**
 * AuthorDao, add Author finders to Dao interface
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public interface AuthorDao extends Dao<Author, Long> {
	
	List<Author> findByName(String pattern);
}
