package com.rg.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesUtil extends Properties {
	private static final long serialVersionUID = -8060523758174561489L;

	@Value("${env}")
	public void setEnv(String env) {
		setProperty("env", env);
	}
	
	@Value("${hibernate.connection.url}")
	public void setHibernateUrl(String hibernateUrl) {
		setProperty("hibernate.connection.url", hibernateUrl);
	}

	@Value("${hibernate.connection.username}")
	public void setHibernateUname(String hibernateUname) {
		setProperty("hibernate.connection.username", hibernateUname);
	}

	@Value("${hibernate.connection.password}")
	public void setHibernatePwd(String hibernatePwd) {
		setProperty("hibernate.connection.password", hibernatePwd);
	}

	@Value("${hibernate.show_sql}")
	public void setHibernateShowSql(String hibernateShowSql) {
		setProperty("hibernate.show_sql", hibernateShowSql);
	}

	@Value("${hibernate.hbm2ddl.auto}")
	public void setHibernateDDLAutoType(String hibernateDDLAutoType) {
		setProperty("hibernate.hbm2ddl.auto", hibernateDDLAutoType);
	}

}
