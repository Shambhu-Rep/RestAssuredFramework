package bdd.restapi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GET_Request {
	@Test
	public void GetRequest() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("data[0].id", equalTo(7))
		.header("Content-Type", "application/json; charset=utf-8");
		

	}

}
