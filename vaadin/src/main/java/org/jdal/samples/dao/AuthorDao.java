package org.jdal.samples.dao;

import java.util.List;

import org.jdal.dao.Dao;
import org.jdal.samples.model.Author;

public interface AuthorDao extends Dao<Author, Long> {
	
	List<Author> findByName(String pattern);
}
