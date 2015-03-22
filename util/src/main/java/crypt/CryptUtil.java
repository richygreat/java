package crypt;

import java.security.MessageDigest;

public class CryptUtil {
	public static void main(String[] args) throws Exception {
		System.out.println(hash(MessageDigest.getInstance("SHA"), "secret"));
	}
	
	public static String hash(MessageDigest md, String plainText) {
		StringBuilder sb = new StringBuilder();
		md.update(plainText.getBytes());
		byte byteData[] = md.digest();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}
}
