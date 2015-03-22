
package com.rg.spring.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rg.spring.db.CosyDAO;
import com.rg.spring.db.User;
import common.CommonUtil;

@Service
public class CosyService {
	@Autowired
	private CosyDAO dao;
	
	public Integer createUser() throws NoSuchAlgorithmException {
		User u = new User();
		u.setName("Richy");
		u.setStatus(1);
		u.setEmail("richygreat@gmail.com");
		MessageDigest md = MessageDigest.getInstance("MD5");
		u.setPassword(CommonUtil.hash(md, "secret"));
		return dao.createUser(u);
	}
}
