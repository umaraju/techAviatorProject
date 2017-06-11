package Day5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hashmaps {
	
	public static void main(String[] args) {
		
	Map<String, String> hm = new HashMap<String,String>();	
		hm.put("usa", "22");
		hm.put("india", "1");
		hm.put("china", "30");
		hm.put("uk", "32");
		hm.put("japan", "40");
		hm.put("china", "40");
	
		
		System.out.println(hm.get("india"));
		
		Iterator<String> it = hm.keySet().iterator();
		
		while(it.hasNext()){
			String key = it.next();
			System.out.println("key is: " + key + " <<<>>> value is: " + hm.get(key));
					
		}
		
		
		
		
	}	

}
