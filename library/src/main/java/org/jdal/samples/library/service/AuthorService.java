package org.jdal.samples.library.service;

import java.util.List;

import org.jdal.samples.library.model.Author;
import org.jdal.service.PersistentService;

/**
 * Author DAO
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public interface AuthorService extends PersistentService<Author, Long>{
	
	public List<Author> findByName(String pattern); 

}
