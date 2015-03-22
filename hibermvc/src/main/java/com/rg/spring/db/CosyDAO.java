package com.rg.spring.db;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CosyDAO {
	private static final Logger logger = LoggerFactory.getLogger(CosyDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public Integer createUser(User u) {
		Integer id = null;
		logger.info("User Creation starts");
		id = (Integer) sessionFactory.getCurrentSession().save(u);
		logger.info("User Creation ends");
		return id;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserlist() {
		logger.info("User List Fetch starts");
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
		logger.info("User List Fetch ends");
		return listUser;
	}
}
