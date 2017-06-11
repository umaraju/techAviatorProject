package Day8;

import java.io.File;



import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Snapshot {
	
	public static void main(String[] args) throws Exception {
		
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat dformat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String dte = dformat.format(date);
		System.out.println(dte);
		
		
		
		
//		Launch App
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		

		ff.findElement(By.cssSelector("div[class='frmbody']>div:nth-of-type(1) input")).sendKeys("10000");
//		ff.findElement(By.xpath("//div[@class='frmbody']/div[1]//input")).sendKeys("10000");
//		ff.findElement(By.xpath("//input[@name='interest']/../../../div[1]//input")).sendKeys("10000");
		
		
		//		Enter rate of Interest
		ff.findElement(By.name("interest")).sendKeys("10");
		
//		Enter duration
		ff.findElement(By.name("instalment")).sendKeys("120");
		
//		Click on calculate
		ff.findElement(By.name("B1")).click();
		
//		Extract EMI
		String output = ff.findElement(By.id("four")).getAttribute("value");
		
		
	
		
		
		
		
		TakesScreenshot imgcapture=(TakesScreenshot)ff;
		File screen = imgcapture.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("E:\\snap_" + dte + ".png"));
		
		
		
		
		
		
		
		
		
		
		System.out.println(output);
		
		
		
		
		
		
	}
}
