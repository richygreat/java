package com.rg.util.sample;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestUtil {
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DATE, 24);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.YEAR, 2015);
		System.out.println(cal.getTime());
		Calendar now = new GregorianCalendar();
		now.add(Calendar.DATE, 21);
		System.out.println(now.getTime());
		long diff = now.getTimeInMillis() - cal.getTimeInMillis();
		diff = diff / 1000 / 60 / 60 / 24 / 7;
		System.out.println(diff);
	}
}
