package com.employeeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	public static Logger logger;
	public static String empId="16";
	
	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("EmployeeRestAPIs");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);

	}

}
