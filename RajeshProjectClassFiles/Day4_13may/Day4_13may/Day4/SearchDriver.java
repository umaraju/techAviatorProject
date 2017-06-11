package Day4;

public class SearchDriver {
	
	
	public static void main(String[] args) {
		
		String scenario = "Bing:Yahoo";
		
		String[] split = scenario.split(":");
	
		for(int i = 0 ; i < split.length;i++){
			
			SearchInter ry = null;
			String url = ""  ;
			if(split[i].equals("Yahoo")){
				ry = new Ramyahoo();
				url = "https://search.yahoo.com/";
				
			}else if(split[i].equals("Bing")){
				ry  = new Shyambing();
				url = "https://bing.com/";
			}
				
			
			
			ry.Launchapp(url);
			String result = ry.searchandextract("selenium");
			System.out.println(result);
			ry.teardown();	
			
			
			
			
			
		}
	
		
		
		
		
//		Yahoo and Bing implementing interface SearchInter
//		SearchInter sb = new Ramyahoo();
//		sb.Launchapp("https://search.yahoo.com/");
//		String result1 = sb.searchandextract("selenium");
//		System.out.println(result1);
//		sb.teardown();
		
		
		
		
		
		
		
	}
	
	

}
