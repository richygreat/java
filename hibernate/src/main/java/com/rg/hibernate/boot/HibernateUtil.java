package com.rg.hibernate.boot;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rg.hibernate.entity.User;
import com.rg.spring.config.PropertiesUtil;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");
		PropertiesUtil props = context.getBean(PropertiesUtil.class);
		
		// Create configuration instance
		Configuration configuration = new Configuration();

		// Pass hibernate properties file
		configuration.setProperties(props);

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
