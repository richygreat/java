package com.rg.bean.sample;

import javax.ejb.Local;

@Local
public interface TestBeanLocal {
	public Object get(String key);

	public void store(String key, Object value);
}
