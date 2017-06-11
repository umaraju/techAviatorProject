package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Yahoosearchclass extends searchBase{
	
	
	String SearchandExtract(String searchoption){
	
		fd.findElement(By.tagName("input")).sendKeys(searchoption);
		fd.findElement(By.className("sbb")).click();
		String output = fd.findElement(By.xpath("//span[contains(text(),' results')]")).getText();
		return output;
	}
	
	
	
	
	
	
	
	

}
