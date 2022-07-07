package com.sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test01_GETRequest {
	@Test
	public void GETRequest() {
		// Specify baseURI- domain name
		RestAssured.baseURI="https://reqres.in/";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		// Response object
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :"+statusCode);
		
		String resBody = response.getBody().asString();
		System.out.println("Response Body: "+resBody);
		
		String respBody = response.asString();
		System.out.println("Response Body: "+respBody);
		
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :"+statusLine);
		
		String header = response.getHeader("content-type");
		System.out.println("Header :"+header);
		
		long resTime = response.getTime();
		System.out.println("Response Time :"+resTime);
		
		
		

	}

}
