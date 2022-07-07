package com.sdet;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test04_GETRequest_ValidateJSONResponse {
	@Test
	public void GETRequestValidateJSONRequest() {
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
		
		//boolean contains = resBody.contains("total");
		//Assert.assertEquals(contains, true);

		boolean contains = resBody.contains("tobias.funke@reqres.in");
		Assert.assertEquals(contains, true);
	}

}
