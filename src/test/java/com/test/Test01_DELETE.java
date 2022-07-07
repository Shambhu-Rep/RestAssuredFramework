package com.test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test01_DELETE {
	@Test
	private void test01_DELETE() {
		
		given().when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204);

	}
}
