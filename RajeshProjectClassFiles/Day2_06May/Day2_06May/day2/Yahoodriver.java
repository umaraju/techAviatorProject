package day2;

public class Yahoodriver {

	
	public static void main(String[] args) {
		
		Yahoosearchclass yc = new Yahoosearchclass();
		yc.launchApp("https://search.yahoo.com/");
		System.out.println(yc.SearchandExtract("sikuli"));
		yc.closeApp();
		
	}
	
	
}

