package common;

import java.security.MessageDigest;

import crypt.CryptUtil;

public class CommonUtil {
	public static void main(String[] args) {
		
	}
	
	public static String hash(MessageDigest md, String plainText) {
		return CryptUtil.hash(md, plainText);
	}
}
