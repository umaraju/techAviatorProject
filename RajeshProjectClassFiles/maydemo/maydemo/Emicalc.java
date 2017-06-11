package maydemo;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Emicalc {	
	
	public static void main(String[] args) {
		
//		Launch app
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
				
		
//		enter amount
		ff.findElement(By.id("one")).sendKeys("100000");		
//		enter interest
		ff.findElement(By.name("interest")).sendKeys("10");
//		enter tenure
		ff.findElement(By.id("three")).sendKeys("120");
//		Click on calculate
		ff.findElement(By.name("B1")).click();
//		Extract EMI
		String output = ff.findElement(By.id("four")).getAttribute("value");
		System.out.println(output);
		
//		Close app
		ff.close();
		
		
		
	}
	
}
