package com.techaviator.demo.DataProviderComponents;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.techaviator.demo.GenericComponents.RediffReadWriteExcel;

public class RediffDataProvider {

	//Test data provider based on the test case
	@DataProvider(name = "RediffTestData")
	public static Iterator<Object[]> testDataProvider(Method m) throws IOException {
		
		Iterator<Object[]> rediffTestData = null;
		
		switch(m.getName().trim()){
		
		case "userLogin_Valid":
			
			rediffTestData = dataProvider("ta_UserLogin", "Valid");
			break;
			
		case "userLogin_inValid":
			
			rediffTestData = dataProvider("ta_UserLogin", "inValid");
		}
		
		return rediffTestData;
	}

	public static Iterator<Object[]> dataProvider(String SheetName, String ScriptName) throws IOException {
		
		//Create instance variables
/*		RediffReadWriteExcel wb;
		wb = new RediffReadWriteExcel();*/
		
		//Get work book
		//wb.excelWorkBook(System.getProperty("user.dir")+ "\\data\\techAviatorTestData.xlsx");
		//C:\techAviatorDemo\TechAviatorPoc\data\techAviatorTestData.xlsx

		RediffReadWriteExcel wb = new RediffReadWriteExcel(System.getProperty("user.dir")+ "\\data\\techAviatorTestData.xlsx");
		// Get row count
		int RowCount = wb.getRowCount(SheetName);

		//Get column count
		int ColCount = wb.getColumnCount(SheetName);

		//Declare Array List
		List<Object[]> arrList = new ArrayList<Object[]>();

		for (int row = 1; row <= RowCount; row++) {
			
			String scriptName = wb.getCellData(SheetName, row, 3);
			String ExecFlag = wb.getCellData(SheetName, row, 2);
			
			if(scriptName.equalsIgnoreCase(ScriptName) && ExecFlag.equalsIgnoreCase("Y")) {

			// Create Array Object
			Object[] arrObj = new Object[1];

			//Create Map
			Map<String, String> map = new HashMap<String, String>();

			for (int col = 0; col < ColCount; col++) {

				//Get column key
				String colKey = wb.getCellData(SheetName, 0, col);

				// Get cell value
				String cellValue = wb.getCellData(SheetName, row, col);

				//Add data to map
				map.put(colKey, cellValue);

			} // end of inner loop

			//Add map to array object
			arrObj[0] = map;

			//Add array object to array list
			arrList.add(arrObj);
		}
	} // end of out loop
		
		// Return array list
		return arrList.iterator();
	}

}
