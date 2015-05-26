package com.rg.spring.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import com.rg.spring.config.PropertiesUtil;

public class App {
	static {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,
				"prod");
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");
		PropertiesUtil props = context.getBean(PropertiesUtil.class);
		System.out.println(props);
	}
}
