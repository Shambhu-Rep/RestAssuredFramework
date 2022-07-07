package com.sdet;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test01_POSTRequest {
	@Test
	public void POSTRequest() {
		// Specify baseURI- domain name
		RestAssured.baseURI = "https://reqres.in/";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request payload sending with POST request
		JSONObject reqestParam = new JSONObject();
		reqestParam.put("name", "Jhones");
		reqestParam.put("job", "Tester");

		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(reqestParam.toJSONString()); // attach above data to the request
		// Response object
		Response response = httpRequest.request(Method.POST, "/api/users");

		int statusCode = response.getStatusCode();
		System.out.println("Status Code :" + statusCode);
		Assert.assertEquals(statusCode, 201);

		String resBody = response.getBody().asString();
		System.out.println("Response Body: " + resBody);

		String respBody = response.asString();
		System.out.println("Response Body: " + respBody);

		String statusLine = response.getStatusLine();
		System.out.println("Status Line :" + statusLine);

		String header = response.getHeader("content-type");
		System.out.println("Header :" + header);

		long resTime = response.getTime();
		System.out.println("Response Time :" + resTime);

	}

}
