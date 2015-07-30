package com.rg.util.sample;

public class TestUtil {
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(TestUtil.isEmpty("Richy"));
	}
}
