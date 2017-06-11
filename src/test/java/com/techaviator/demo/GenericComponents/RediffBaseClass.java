package com.techaviator.demo.GenericComponents;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RediffBaseClass {

	//Declare driver instance variable
	public WebDriver driver;
	public Logger log;
	public static ExtentReports eReport;
	public ExtentTest startTest;


	@BeforeMethod
	public void launchApplication() {

		//Launch Application
		driver = new FirefoxDriver();
		driver.get("http://books.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		
		eReport = new ExtentReports(System.getProperty("user.dir")+"/reports/reports_"+getDateTime()+".html");
		
	}
	
	//Get current date and time with required format then return
	public String getDateTime() {
		
		//1. Get new system date
		Date dt = new Date();
		
		//2. Get new simple data format
		SimpleDateFormat df = new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		
		//3. Convert date format to string by  appending .png extension
		String date = df.format(dt)+ ".png";
		
		//4. Return date
		return date;
	}
	
	//Take Full Screenshot, Get Output Type, Save Path to Variable, Copy file with TCID and Date then return
	public String takeScreenShot() throws IOException {
		
		//1. Take full screen shot
		TakesScreenshot sc = (TakesScreenshot) driver;
		
		//2. Get Output Type
		File screenShot = sc.getScreenshotAs(OutputType.FILE);
		
		//3. Save Path to Variable
		String scFilePath = System.getProperty("user.dir")+"//src//test//reports"+ ".png";
		
		//4. Copy file with TCID and Date
		FileUtils.copyFile(screenShot, new File(scFilePath+getDateTime()));
		
		//5. Return file path
		return scFilePath;
	}
	
	//Take web element screen screenshot
	public String takeWebElemntScreenShot(WebElement ele) throws IOException {
		
		//1. Get element location
		Point point = ele.getLocation();

		//2. Get element size with width
		int eleWidth = ele.getSize().getWidth();

		//3. Get element size with height
		int eleHeight = ele.getSize().getHeight();
		
		//4. Take full screen shot
		TakesScreenshot takeSC = (TakesScreenshot) driver;
		
		//5. Get OutputType file
		File outputFileSC = takeSC.getScreenshotAs(OutputType.FILE);
		
		//6. Get buffered image of full image using imageIO.read
		BufferedImage  fullImg = ImageIO.read(outputFileSC);
		
		//7. Get buffered image of sub image using fullimage. getSubImage
		BufferedImage subImg= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		
		//8. Write image using imageIO.write to sub image, png and file type
		ImageIO.write(subImg, "png", outputFileSC);
		
		//9. Save path to variable
		String path=System.getProperty("user.dir")+"//src//test//reports" + getDateTime() + ".png";
		
		//10. Copy file type with with TCID, Date
		FileUtils.copyFile(outputFileSC, new File(path));
		
		//11. Return file path
		return path;
	}
	
	// Validation methods for check points
	
	//Contains with full screen shot
	public void containsFullImageValidation(String Actual, String Expected, String StepName) throws IOException {
		
		if(Actual.contains(Expected)) {
			log.info("Step passed ");
			startTest.log(LogStatus.PASS, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected);
		}else{
			log.info("Step failed "+ StepName);
			startTest.log(LogStatus.FAIL, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected + startTest.addScreenCapture(takeScreenShot()));
		}	
	}
	
	//Contains with web element level screen shot
	public void containsElementLevelValidation(String Actual, String Expected, WebElement ele, String StepName) throws IOException {
		
		if(Actual.contains(Expected)) {
			log.info("Step passed "+ StepName);
			startTest.log(LogStatus.PASS, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected);
		}else{
			log.info("Step failed "+ StepName);
			startTest.log(LogStatus.FAIL, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected + startTest.addScreenCapture(takeWebElemntScreenShot(ele)));
		}	
	}
	//Equals with full screen shot
	public void equalsFullImageValidation(String Actual, String Expected, String StepName) throws IOException {
		
		if(Actual.equals(Expected)) {
			log.info("Step passed ");
			startTest.log(LogStatus.PASS, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected);
		}else{
			log.info("Step failed "+ StepName);
			startTest.log(LogStatus.FAIL, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected + startTest.addScreenCapture(takeScreenShot()));
		}	
	}
	
	//Equals with web element level screen shot
		public void equalsElementLevelValidation(String Actual, String Expected, WebElement ele, String StepName) throws IOException {
			
			if(Actual.equals(Expected)) {
				log.info("Step passed "+ StepName);
				startTest.log(LogStatus.PASS, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected);
			}else{
				log.info("Step failed "+ StepName);
				startTest.log(LogStatus.FAIL, StepName+ "Actual result is "+Actual+ "Expected result is "+Expected + startTest.addScreenCapture(takeWebElemntScreenShot(ele)));
			}	
		}
	
	@AfterMethod()
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.SUCCESS) {

			startTest.log(LogStatus.PASS, "Test completion", "Peassed the tests  "+ startTest.addScreenCapture(takeScreenShot()));
			
		}else if(result.getStatus() == ITestResult.FAILURE){
			
			startTest.log(LogStatus.FAIL, "Test completion ", result.getThrowable() + startTest.addScreenCapture(takeScreenShot()));
		}
	}
		
		@AfterMethod()
		public void tearDown() throws IOException {

		eReport.endTest(startTest);
		eReport.flush();
		driver.quit();
	}

}
