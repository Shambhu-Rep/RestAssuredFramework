package com.sdet;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test03_GETRequest_GetAllHeaders {
	@Test
	public void GETRequestAllHeader() {
		// Specify baseURI- domain name
		RestAssured.baseURI="https://reqres.in/";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		// Response object
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :"+statusCode);
		// Print response log in console window
		String resBody = response.getBody().asString();
		System.out.println("Response Body: "+resBody);
		
		String respBody = response.asString();
		System.out.println("Response Body: "+respBody);
		
		Headers allHeaders = response.headers();
		for (Header header:allHeaders) {
			//System.out.println(header); //Get all headers
			System.out.println(header.getName()+"   "+header.getValue());
		}
		

	}

}
