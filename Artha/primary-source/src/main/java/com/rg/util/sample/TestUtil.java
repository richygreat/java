package com.rg.util.sample;

import java.util.Arrays;
import java.util.List;

import com.rg.entity.Type;


public class TestUtil {
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Type o1 = new Type();
		o1.setTypeOrder(2);
		Type o2 = new Type();
		o2.setTypeOrder(1);
		List<Type> ls = Arrays.asList(o1, o2);
		System.out.println(ls);
		ls.sort(Type.TYPE_COMPARATOR);
		System.out.println(ls);
	}
}
