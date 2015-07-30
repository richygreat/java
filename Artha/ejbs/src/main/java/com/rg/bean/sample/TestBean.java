package com.rg.bean.sample;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import org.apache.log4j.Logger;

/**
 * Session Bean implementation class TestBean
 */
@Singleton
@LocalBean
public class TestBean implements TestBeanRemote, TestBeanLocal {
	private static final Logger log = Logger.getLogger(TestBean.class);

	private Map<String, Object> cache;

	/**
	 * Default constructor.
	 */
	public TestBean() {
		log.info("Inside constructor");
	}

	@PostConstruct
	public void initCache() {
		this.cache = new HashMap<String, Object>();
	}

	public Object get(String key) {
		return this.cache.get(key);
	}

	public void store(String key, Object value) {
		this.cache.put(key, value);
	}

}
