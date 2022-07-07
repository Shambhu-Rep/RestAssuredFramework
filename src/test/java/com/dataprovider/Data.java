package com.dataprovider;

import java.io.IOException;

import com.utils.ExcelUtils;

public class Data extends ExcelUtils {

	public static void main(String[] args) throws IOException {
		String fileLoc = System.getProperty("user.dir") + "//src//test//java//com//dataprovider//TestData.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils.setCellData(fileLoc, sheetName, 1, 3, "sheetName");
		
		/*
		 * int rowCount = ExcelUtils.getRowCount(fileLoc, sheetName); int cellCount =
		 * ExcelUtils.getCellCount(fileLoc, sheetName, 1);
		 * 
		 * System.out.println(rowCount); System.out.println(cellCount); String data1 =
		 * ExcelUtils.getCellData(fileLoc, sheetName, 1, 0); System.out.println(data1);
		 * 
		 * // String userData[][] = new String[rowCount][cellCount]; for (int i = 1; i
		 * <= rowCount; i++) { for (int j = 0; j <= cellCount; j++) {
		 * 
		 * String data = ExcelUtils.getCellData(fileLoc, sheetName, i, j);
		 * System.out.println(data); } }
		 */
	}
}
