package org.jdal.samples.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jdal.dao.UserDao;
import org.jdal.dao.jpa.JpaDao;
import org.jdal.dao.jpa.JpaUtils;
import org.jdal.samples.model.User;


public class UserJpaDao extends JpaDao<User, Long> implements UserDao {
	
	private static final String USERNAME = "username";

	public UserJpaDao() {
		super(User.class);
	}

	public UserJpaDao(Class<User> entityClass) {
		super(entityClass);
	}

	@Override
	public User findByUsername(String username) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.where(cb.equal(JpaUtils.<String>getPath(root, USERNAME), username.trim()));
		
		List<User> result = em.createQuery(cq).getResultList();
		
		return result.size() > 0 ? result.get(0) : null;
	}

}
