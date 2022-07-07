package com.sdet;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test02_GETRequest_HeaderValidation {
	@Test
	public void GETRequestHeader() {
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
		
		//Header Validation
		
		String contentType=response.header("Content-Type");// capture details of Content-Type header
		  System.out.println("Content Type is:"+contentType);
		  Assert.assertEquals(contentType, "application/json; charset=utf-8");
		  
		  String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
		  System.out.println("Content Encoding is:"+contentEncoding);
		  Assert.assertEquals(contentEncoding, "gzip");

	}

}
