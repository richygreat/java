package com.rg.hibernate.boot;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rg.hibernate.entity.User;

public class App {
	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			logger.debug("Transaction started");
			Criteria cr = session.createCriteria(User.class);
			List<User> users = cr.list();
			logger.info(users);
			tx.commit();
			logger.debug("Transaction committed");
		} catch (RuntimeException e) {
			tx.rollback();
			logger.error("Exception occured in main class", e);
		}
	}
}
