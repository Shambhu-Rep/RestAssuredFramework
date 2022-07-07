package bdd.restapi;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.employeeeapi.utilties.RestUtils;

import io.restassured.RestAssured;

public class POST_Request {
	public static Map<String, String> map=new HashedMap<>();
	@BeforeClass
	public void setup() {
		map.put("name", RestUtils.empName());
		map.put("job", RestUtils.empJob());
		
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";
	}
	@Test
	public void Post_Request() {
		given()
		.body(map)
		.contentType("application/json; charset=utf-8")
		.when()
		.post()
		.then()
		.statusCode(201);
		

	}

}
