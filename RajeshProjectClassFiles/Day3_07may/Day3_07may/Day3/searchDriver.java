package Day3;

public class searchDriver {
	
	public static void main(String[] args) {
		
		Searchbing sb = new Searchbing();
		sb.OpenApp("http://www.bing.com/");
		String extractResults = sb.extractResults("sikuli");
		System.out.println(extractResults);
		sb.tearDown();
		
		
		Yahoosearchclass ys = new Yahoosearchclass();
		ys.OpenApp("https://search.yahoo.com/");
		System.out.println(ys.SearchandExtract("sikuli"));
		ys.tearDown();
		
		
		
		
		
	}	

}
