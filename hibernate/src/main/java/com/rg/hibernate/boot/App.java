package com.rg.hibernate.boot;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.core.env.AbstractEnvironment;

import com.rg.hibernate.entity.User;

public class App {
	private static final Logger log = Logger.getLogger(App.class);
	
	static {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			log.debug("Transaction started");
			Criteria cr = session.createCriteria(User.class);
			@SuppressWarnings("unchecked")
			List<User> users = cr.list();
			log.info(users);
			tx.commit();
			log.debug("Transaction committed");
		} catch (RuntimeException e) {
			tx.rollback();
			log.error("Exception occured in main class", e);
		}
	}
}
