package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Searchbing extends searchBase {
	
	
	String extractResults(String option){
		fd.findElement(By.id("sb_form_q")).sendKeys(option);
		fd.findElement(By.id("sb_form_go")).click();
		
		return fd.findElement(By.className("sb_count")).getText();
			
	}
	
	
	
	
	
	
	
	
	
	
	

}
