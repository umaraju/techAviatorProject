package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class linktext_partial {

	
	public static void main(String[] args) {
		
		
		FirefoxDriver fd = new FirefoxDriver();
		fd.get("http://www.bing.com/");
		fd.manage().window().maximize();
		
//		Linktext
//	fd.findElement(By.linkText("Office Online")).click();
	
//	partiallinktext
	fd.findElement(By.partialLinkText("Online")).click();
		
		fd.quit();
		
		
		
		
		
		
		
		
	}
}
