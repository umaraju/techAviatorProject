package Day6;

public class useExcelRW {
	
	public static void main(String[] args) throws Exception {
		
//		ExcelRW ex = new ExcelRW();		
//		ex.intializeWorkbook("C:\\Users\\DELL\\Desktop\\Age.xlsx");
		
		ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\Age.xlsx");
		
		int rowcount = ex.getRowcount("Sheet1");	
		
		for(int i = 1 ;i<=rowcount;i++){
			
			String Age = ex.readCellValue("Sheet1", i, 1);
			
			if(Double.parseDouble(Age) > 18){
				
				ex.writeCellVCalue("Sheet1", i, 2, "major");
			}else{
				
				ex.writeCellVCalue("Sheet1", i, 2, "minor");
			}
			
			
					
		}
		
		ex.Saveandclose("C:\\Users\\DELL\\Desktop\\Age2.xlsx");
		
		
		
		
	}	

}
