package Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testassignment {
	
	@Test(dataProvider="sumdp")
	public void sum(Map<String,String> hm){
		
		String a = hm.get("s1");
		String b = hm.get("s2");
		String exp_result=hm.get("exp");
	
		if(Double.parseDouble(a) + Double.parseDouble(b) == Double.parseDouble(exp_result)){
			System.out.println("pass");
		}else{
			
			System.out.println("fail");
		}		
	}
	
	
	@DataProvider(name="sumdp")
	public Iterator<Object[]> dp_sum() throws Exception{
			
			ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\sum.xlsx");
			int row = ex.getRowcount("Sheet1");
		    int col = ex.getColcount("Sheet1");
		    
//		    create list
		    List<Object[]> ls = new ArrayList<Object[]>();
		    
//		iterate thru each row
			for(int iRow = 1;iRow<=row;iRow++)	{
//				create array
				Object[] obj = new Object[1];
				
//				create map
				Map<String, String> hm = new HashMap<String,String>();			
				
//				iterate thru each column
				for(int jCol = 0;jCol< col;jCol++){
//					column heading
					String key = ex.readCellValue("Sheet1",0,jCol);
//					specific colum specific value
					String val = ex.readCellValue("Sheet1", iRow, jCol);
					System.out.println("key : " + key + "Value: " + val);
					hm.put(key, val);				
					
				}
				
				obj[0]=hm;
				ls.add(obj);
						
			}
		
		
		return ls.iterator();
		
	}
	
	
	

}
