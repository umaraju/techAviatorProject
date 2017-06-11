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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reportss {
	WebDriver ff;
	public void Test() throws Exception {
		
		
		 
		 ExtentReports eRports = new ExtentReports("E:\\Automation report_" + getdtime() + ".html");
		 ExtentTest startTest = eRports.startTest("TC01");
		 
//		 Launch App
			ff = new FirefoxDriver();
			ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
			ff.findElement(By.cssSelector("div[class='frmbody']>div:nth-of-type(1) input")).sendKeys("10000");
			startTest.log(LogStatus.PASS,"started execution","Passed as successfully started the execution");
			//		Enter rate of Interest
			ff.findElement(By.name("interest")).sendKeys("10");
			
//			Enter duration
			ff.findElement(By.name("instalment")).sendKeys("120");
						
//			Click on calculate
			ff.findElement(By.name("B1")).click();
			
//			Extract EMI
			String output = ff.findElement(By.id("four")).getAttribute("value");
			if(output.equals("345")){
				
				startTest.log(LogStatus.PASS, "validation of EMI", "Passed as actual and expected matches");
			}else {
				
				startTest.log(LogStatus.FAIL, "validation of EMI", "failed as actual value is " + output + " and expected value was 345" + startTest.addScreenCapture(getscreenshot()) );
				}
			
			
			
			System.out.println(output);
			
			
			eRports.endTest(startTest);
			eRports.flush();
		 
		 
		 
		 
		 
		 
		 
		 
	}	
	 
	 public String getscreenshot() throws Exception{
			TakesScreenshot imgcapture=(TakesScreenshot)ff;
			File screen = imgcapture.getScreenshotAs(OutputType.FILE);
			String fpath="E:\\snap_" + getdtime() + ".png";
			FileUtils.copyFile(screen, new File(fpath));
		 
		 return fpath;
		 
	 }
	 
	 public String getdtime(){
		 Date date = new Date();
		System.out.println(date);
		SimpleDateFormat dformat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String dte = dformat.format(date);
		return dte;
	 }
}
