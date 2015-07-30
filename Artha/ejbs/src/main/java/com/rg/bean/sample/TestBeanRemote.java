package com.rg.bean.sample;

import javax.ejb.Remote;

@Remote
public interface TestBeanRemote {
	public Object get(String key);

	public void store(String key, Object value);
}
