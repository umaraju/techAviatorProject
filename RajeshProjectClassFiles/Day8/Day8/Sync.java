package Day8;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sync {
	
	public static void main(String[] args) {
		
		
//		Launch App
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		ff.manage().window().maximize();
		ff.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		ff.findElement(By.cssSelector("div[class='frmbody']>div:nth-of-type(1) input")).sendKeys("10000");
//		ff.findElement(By.xpath("//div[@class='frmbody']/div[1]//input")).sendKeys("10000");
//		ff.findElement(By.xpath("//input[@name='interest']/../../../div[1]//input")).sendKeys("10000");
		
		
		//		Enter rate of Interest
		ff.findElement(By.name("interest")).sendKeys("10");
		
//		Enter duration
		ff.findElement(By.name("instalment")).sendKeys("120");
		
//		Click on calculate
		ff.findElement(By.name("B1")).click();
		
		
		WebDriverWait wait = new WebDriverWait(ff,60);
		wait.until(ExpectedConditions.visibilityOf(ff.findElement(By.id("four"))));
		
//		Extract EMI
		String output = ff.findElement(By.id("four")).getAttribute("value");
		
			
		System.out.println(output);
		
	
	
	
	}
}
