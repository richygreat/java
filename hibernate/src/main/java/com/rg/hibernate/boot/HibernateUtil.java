package com.rg.hibernate.boot;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rg.hibernate.entity.User;

public class HibernateUtil {
	private static final Logger logger = Logger.getLogger(HibernateUtil.class);
	private static final SessionFactory sessionFactory;

	static {
		// Create configuration instance
		Configuration configuration = new Configuration();

		// Create properties file
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("hibernate.properties"));
		} catch (Exception e) {
			logger.error("Place hibernate.properties in classpath", e);
		}

		// Pass hibernate properties file
		configuration.setProperties(properties);

		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		
		configuration.configure().addAnnotatedClass(User.class);

		// Create session factory instance
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
