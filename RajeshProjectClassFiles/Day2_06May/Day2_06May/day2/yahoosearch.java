package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class yahoosearch {
	public static void main(String[] args) {
		
		
		FirefoxDriver fd = new FirefoxDriver();
		fd.get("https://search.yahoo.com/");
		fd.manage().window().maximize();
		
		fd.findElement(By.tagName("input")).sendKeys("Selenium");
		fd.findElement(By.className("sbb")).click();
//		one way
//		String output = fd.findElement(By.xpath("//div[@class='compPagination']/span")).getText();
		
//		second way
		String output = fd.findElement(By.xpath("//span[contains(text(),' results')]")).getText();
//		For eg Order_456,Order_567
//		fd.findElement(By.xpath("//span[contains(@id,'Order_')]")).click();
		
		System.out.println(output);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
