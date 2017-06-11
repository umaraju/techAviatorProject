package Day8;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Logss {
	
	public static void main(String[] args) {
		
		Logger EMIcalc = Logger.getLogger(Logss.class);
	
//		Launch App
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		EMIcalc.info("Started Execution");
		EMIcalc.info("Launched application");
		ff.findElement(By.cssSelector("div[class='frmbody']>div:nth-of-type(1) input")).sendKeys("10000");
//		ff.findElement(By.xpath("//div[@class='frmbody']/div[1]//input")).sendKeys("10000");
//		ff.findElement(By.xpath("//input[@name='interest']/../../../div[1]//input")).sendKeys("10000");
		
		
		//		Enter rate of Interest
		ff.findElement(By.name("interest")).sendKeys("10");
		
//		Enter duration
		ff.findElement(By.name("instalment")).sendKeys("120");
		
		
		EMIcalc.info("Entered the values");
//		Click on calculate
		ff.findElement(By.name("B1")).click();
		
//		Extract EMI
		String output = ff.findElement(By.id("four")).getAttribute("value");
		EMIcalc.info("Extracted values");

		System.out.println(output);
		
		

		
		
		
		
		
		
		
	}
}
