package com.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ExcelUtils;

public class TC01_POST_DT {

	@Test(dataProvider = "test")
	public void postCreateUser(String name, String job) {
		System.out.println(name);
		System.out.println(job);
		/*
		 * RestAssured.baseURI = "https://reqres.in"; // Request Object
		 * RequestSpecification httpRequest = new RestAssured().given();
		 * 
		 * JSONObject json = new JSONObject(); json.put("name", name); json.put("job",
		 * job);
		 * 
		 * httpRequest.body(json.toJSONString()); httpRequest.header("Content-Type",
		 * "application/json"); // Response object Response response =
		 * httpRequest.request(Method.POST, "/api/users");
		 * 
		 * int statusCode = response.getStatusCode(); Assert.assertEquals(statusCode,
		 * 201);
		 * 
		 * String body = response.getBody().asString();
		 * System.out.println("Response Body is : " + body);
		 * 
		 * Assert.assertEquals(body.contains(name), true);
		 * 
		 * Assert.assertEquals(body.contains(job), true);
		 */
	}

	// Using Data Provider with hard code value
	// @DataProvider(name="test")
	private Object[][] dataTest() {

		String val[][] = { { "Smith", "Student" }, { "abc123", "QA" } };
		return val;

	}

	// Using Data Provider with Excel sheet integration
	@DataProvider(name = "test")
	public String[][] dataTestExcel() throws IOException {
		String fileLoc = System.getProperty("user.dir") + "//src//test//java//com//dataprovider//TestData.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileLoc, sheetName);
		int cellCount = ExcelUtils.getCellCount(fileLoc, sheetName, 1);
		String userData[][] = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				userData[i - 1][j] = ExcelUtils.getCellData(fileLoc, sheetName, i, j);
			}
		}

		return userData;

	}

}
