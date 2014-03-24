package org.jdal.samples.dao;

import org.jdal.dao.Dao;
import org.jdal.model.User;

public interface UserDao extends Dao<User, Long>, org.jdal.dao.UserDao {

}
