package com.test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test01_POST {
	@Test
	private void test01_POST() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "Shamb");
		map.put("job", "Engg");
		System.out.println(map);
		JSONObject jobj=new JSONObject(map);
		System.out.println(jobj);
		System.out.println(jobj.toJSONString());

	}
	@Test
	private void test02_POST() {
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
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);

	}
}
