package com.techaviator.demo.GenericComponents;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * //Create Work Book //Get row count and return rown count //Get column count
 * and return column count //Get cell data and return data
 */

public class RediffReadWriteExcel {

	// Declare all work book instance variables
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cellValue;

	// Create Work Book
	public RediffReadWriteExcel(String filePath) throws IOException {

		// File input stream
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
	}

	// Get row count and return rown count
	public int getRowCount(String SheetName) {

		sheet = wb.getSheet(SheetName);
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;
	}

	// Get column count and return column count
	public int getColumnCount(String SheetName) {

		sheet = wb.getSheet(SheetName);
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		return lastCellNum;
	}

	// Get cell data and return data
	public String getCellData(String SheetName, int row, int col) {

		// Get sheet
		sheet = wb.getSheet(SheetName);

		// Get cell value by passing row and column
		cellValue = sheet.getRow(row).getCell(col);

		// Declare local string variable
		String testData = null;

		// Get test data based on its data type by converting to string type
		if(cellValue.getCellType()==Cell.CELL_TYPE_STRING) {

			testData = cellValue.getStringCellValue();
			
		} else if(cellValue.getCellType()==Cell.CELL_TYPE_NUMERIC) {

			testData = String.valueOf(cellValue.getNumericCellValue());
		} else if(cellValue.getCellType()==Cell.CELL_TYPE_BLANK) {

			testData = "";
		}
		// Return test data
		return testData;
	}
}
