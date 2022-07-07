package com.sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test05_GETRequest_ExtractJsonValidation {
	
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
		
		JsonPath jsonPath = response.jsonPath();
		Object per_page = jsonPath.get("per_page");
		System.out.println(per_page);
		
		Object id = jsonPath.get("data[0].id");
		System.out.println(id);
		
		Object first_name = jsonPath.get("data[1].first_name");
		System.out.println(first_name);
		
		Object email = jsonPath.get("data[4].email");
		System.out.println(email);
	}

}
