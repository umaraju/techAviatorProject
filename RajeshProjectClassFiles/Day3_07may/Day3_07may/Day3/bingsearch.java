package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bingsearch {
	
	public static void main(String[] args) {
		
		FirefoxDriver fd = new FirefoxDriver();
		fd.get("http://www.bing.com/");
		fd.manage().window().maximize();
		
		fd.findElement(By.id("sb_form_q")).sendKeys("Selenium");
		fd.findElement(By.id("sb_form_go")).click();
		
		System.out.println(fd.findElement(By.className("sb_count")).getText());
		
		
		
		
	}
	

}
