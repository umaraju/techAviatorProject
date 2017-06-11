package Day4;

public class Searchdriver_interface {
	
	
	public static void main(String[] args) {
		
		
		
//		Yahoo and Bing implementing interface SearchInter
		SearchInter sb = new Ramyahoo();
//		OR
//		Ramyahoo sb = new Ramyahoo();
		sb.Launchapp("https://search.yahoo.com/");
		String result1 = sb.searchandextract("selenium");
		System.out.println(result1);
		System.out.println(sb.getPagetitle());
		sb.teardown();
		
		
		
		
		
		
		
	}
	
	

}
