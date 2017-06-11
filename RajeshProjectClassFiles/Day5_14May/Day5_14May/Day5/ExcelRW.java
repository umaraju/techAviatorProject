package Day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	
	XSSFWorkbook wb;
	
//	inititslize workbook
	public void intilizeworkbook(String path) throws Exception{		
		FileInputStream fis = new FileInputStream(path);
//		Load the input stream
	    wb = new XSSFWorkbook(fis);
	}
	
//	get RowcountRowcount
	public int getRowcount(String Sheetname){
	XSSFSheet sheet1 = wb.getSheet(Sheetname);	
//	Read and write
	int rowcount = sheet1.getLastRowNum();
	return rowcount;
	}
//	get columnt
	
//	read cell
	
//	write cell
	
//	Save and close
	
	
	
	
	
	
	
	
	
	
	

}
