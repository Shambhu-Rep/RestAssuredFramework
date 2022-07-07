package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static File file;
	public static FileInputStream fis;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fos;

	public static int getRowCount(String fileLoc, String sheetName) throws IOException {
		file = new File(fileLoc);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;

	}

	public static int getCellCount(String fileLoc, String sheetName, int rowNum) throws IOException {
		file = new File(fileLoc);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;

	}

	public static String getCellData(String fileLoc, String sheetName, int rowNum, int cellNum) throws IOException {
		file = new File(fileLoc);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data = "";
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;

	}

	public static void setCellData(String fileLoc, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {
		file = new File(fileLoc);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
		System.out.println("Updated");
	}
}
