package dataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import commonLibraries.ExcelRW;


public class Dp_RediffProj {
	
	@DataProvider(name="Dpglobal")
	public static  Iterator<Object[]> data_common(Method m) throws Exception{		
		Iterator<Object[]> cl = null;
		switch (m.getName().trim()){
		
		case "validLogin":
			cl  = commonlogic("Login","validlogin");
			break;
		
		case "invalidLogin":
			cl =commonlogic("Login","invalidlogin");
			break;
		
		}
		
		return cl;
	}
	
	
	public static Iterator<Object[]> commonlogic(String Sheetname,String Script) throws Exception{
		
	ExcelRW ex = new ExcelRW(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx");
	
	int rowcount = ex.getRowcount(Sheetname);
	int colcount = ex.getColcount(Sheetname);
	
	List<Object[]> ls = new ArrayList<Object[]>();
	
//	iterate thru each row
	for(int iRow=1;iRow<=rowcount;iRow++){
		String scriptname = ex.readCellValue(Sheetname, iRow, 3).trim() ;
		String flag = ex.readCellValue(Sheetname, iRow, 2).trim();
		if(scriptname.equalsIgnoreCase(Script) && flag.equalsIgnoreCase("y")){
//		object array
		Object[] obj = new Object[1];
//		create a map
		Map<String, String> hm = new HashMap<String, String>();
		
//		column iteration
		for(int iCol=0;iCol<colcount;iCol++){
			
			String key=ex.readCellValue(Sheetname, 0, iCol);
			String val=ex.readCellValue(Sheetname, iRow, iCol);
			hm.put(key, val);
			
			
			
		}	//			column iteration	
		obj[0]=hm;
		ls.add(obj);
		}
	}//		iterate thru each row
	
	
	return ls.iterator();
	
	}
	

}
