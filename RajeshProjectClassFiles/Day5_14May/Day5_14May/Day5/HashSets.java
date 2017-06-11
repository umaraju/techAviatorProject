package Day5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSets {
public static void main(String[] args) {
		
		Set<String> al = new HashSet<String>();
		al.add("orange");
		al.add("mango");
		al.add("grapes");
		al.add("apple");
		al.add("mango");
		al.add("banana");
		al.add("pineapple");
//		check whether mango exist in list
//		System.out.println(al.contains("mango"));
		
//		for each
		for(String x : al){			
			System.out.println(x);			
		}
		System.out.println("------------");
//		Iterator
		Iterator<String> it = al.iterator();
		
		while(it.hasNext()){
			String val = it.next();
			System.out.println(val);		
			
		}
				
	}	
	

}
