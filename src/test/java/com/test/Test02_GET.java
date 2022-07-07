package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Test02_GET {
	@Test
	private void test02_GET() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.first_name[1]", equalTo("Lindsay"))
			.body("data.first_name", hasItems("Lindsay","Tobias"))
			.log().all();
		

	}

}
