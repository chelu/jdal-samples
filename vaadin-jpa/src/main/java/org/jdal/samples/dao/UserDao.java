package org.jdal.samples.dao;

import org.jdal.dao.Dao;
import org.jdal.model.User;

/**
 * {@link Dao} interface for {@link User Users}
 * 
 * @author Jose Luis Martin
 * @since 1.0
 */
public interface UserDao extends Dao<User, Long>, org.jdal.dao.UserDao {

}
