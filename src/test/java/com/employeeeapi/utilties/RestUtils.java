package com.employeeeapi.utilties;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empName() {
		String alphabetic = RandomStringUtils.randomAlphabetic(3);
		return ("John" + alphabetic);

	}
	public static String empSal() {
		String salary = RandomStringUtils.randomNumeric(4);
		return (salary);

	}
	public static String empAge() {
		String age = RandomStringUtils.randomNumeric(2);
		return (age);

	}
	public static String empJob() {
		String alphabetic = RandomStringUtils.randomAlphabetic(1);
		return ("Tester" + alphabetic);

	}
}