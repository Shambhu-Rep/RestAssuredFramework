package com.employeeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class TC01_GET_All_Employees extends TestBase {

	
		@BeforeClass
		void getAllEmployees() throws InterruptedException
		{
		
		logger.info("*********Started TC001_GET_All_Employees **********");
			
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		System.out.println(response.getStatusCode());
		Thread.sleep(5000);
		}
				
		@Test
		public void checkResposeBody()
		{
			logger.info("***********  Checking Respose Body **********");
			
			String responseBody = response.getBody().asString();
			System.out.println("responseBody=="+responseBody);
			logger.info("Response Body==>"+responseBody);
			Assert.assertTrue(responseBody!=null);
			
		}
		


	
}
