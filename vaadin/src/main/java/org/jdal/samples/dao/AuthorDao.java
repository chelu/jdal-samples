package org.jdal.samples.dao;

import info.joseluismartin.dao.Dao;

import java.util.List;

import org.jdal.samples.model.Author;

public interface AuthorDao extends Dao<Author, Long> {
	
	List<Author> findByName(String pattern);
}
