package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Yahoosearchclass {
	FirefoxDriver fd;
	
	void launchApp(String url){
		
		fd = new FirefoxDriver();
		fd.get(url);
		fd.manage().window().maximize();		
		
	}
	
	String SearchandExtract(String searchoption){
	
		fd.findElement(By.tagName("input")).sendKeys(searchoption);
		fd.findElement(By.className("sbb")).click();
		String output = fd.findElement(By.xpath("//span[contains(text(),' results')]")).getText();
		return output;
	}
	
	
	void closeApp(){

		fd.close();
		
	}
	
	
	
	
	
	

}
