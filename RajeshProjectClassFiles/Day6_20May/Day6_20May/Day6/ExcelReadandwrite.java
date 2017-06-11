package Day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadandwrite {


	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
//	Create an input stream of data
	FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Age.xlsx");
//	Load the input stream
	XSSFWorkbook wb = new XSSFWorkbook(fis);
		
//	Load the sheet
	XSSFSheet sheet1 = wb.getSheet("Sheet1");
			
//	Read and write
	int rowcount = sheet1.getLastRowNum();
	
	for(int i = 1 ;i<=rowcount ; i ++){
		String celltext = null;
		XSSFCell cell = sheet1.getRow(i).getCell(1);
//		if the cell has string value
		if(cell.getCellType()==Cell.CELL_TYPE_STRING){
			celltext=cell.getStringCellValue();
//			if the cell has numeric value
		}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			celltext= String.valueOf(cell.getNumericCellValue());
//			if cell is having blank
		}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
			celltext="";
		}
		
		
		if(Double.parseDouble(celltext) > 18){
			sheet1.getRow(i).getCell(2).setCellValue("Major");
		}else{
			sheet1.getRow(i).getCell(2).setCellValue("Minor");
		}
		
		
		
	}
	
		
//	Save the xcel sheet using the output stream
	FileOutputStream fos = new FileOutputStream("C:\\Users\\DELL\\Desktop\\Age1.xlsx");
	wb.write(fos);
	
	fos.close();
	fis.close();
	
	
	
	
	
	}
}
