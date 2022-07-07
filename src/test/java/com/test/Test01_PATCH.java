package com.test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test01_PATCH {
	@Test
	private void test02_PATCH() {
		JSONObject jobj=new JSONObject();
		jobj.put("name", "Shamb");
		jobj.put("job", "Engg");
		System.out.println(jobj);
		System.out.println(jobj.toJSONString());
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jobj.toJSONString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();

	}
	@Test
	private void test01_DELETE() {
		
		given().when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204);

	}
}
