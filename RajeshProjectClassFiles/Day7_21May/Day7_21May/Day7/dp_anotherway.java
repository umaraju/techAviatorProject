package Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dp_anotherway {
	
	@Test(dataProvider="sumdp")
	public void sum(String suma,String sumb,String exp){
		
		String a = suma;
		String b = sumb;
		String exp_result=exp;
	
		if(Double.parseDouble(a) + Double.parseDouble(b) == Double.parseDouble(exp_result)){
			System.out.println("pass");
		}else{
			
			System.out.println("fail");
		}		
	}
	
	
	@DataProvider(name="sumdp")
	public Iterator<String[]> dp_sum() throws Exception{
			
			ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\sum.xlsx");
			int row = ex.getRowcount("Sheet1");
		    int col = ex.getColcount("Sheet1");
		    
//		    create list
		    List<String[]> ls = new ArrayList<String[]>();
		    
//		iterate thru each row
			for(int iRow = 1;iRow<=row;iRow++)	{
//create a string array
				String[] x = new String[col];
				
//				iterate thru each column
				for(int jCol = 0;jCol< col;jCol++){

//					specific colum specific value
					String val = ex.readCellValue("Sheet1", iRow, jCol);
					x[jCol] = val;
					
				}
				
				ls.add(x);
						
			}
		
		
		return ls.iterator();
		
	}
	
	
	

}
