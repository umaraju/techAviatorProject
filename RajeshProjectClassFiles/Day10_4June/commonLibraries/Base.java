package commonLibraries;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public WebDriver ff;
	public Logger Log;
	public ExtentReports eReports;
	public ExtentTest startTest;
	
	@BeforeSuite
	public void prerequisite(){		
		 eReports = new ExtentReports("E:\\MayReports\\AutomationReport_" + getdtime() + ".html" );
	}
	
	
	
	@BeforeMethod
	public void launchApp(){
		
		ff= new FirefoxDriver();
		ff.get("http://books.rediff.com/");
		ff.manage().window().maximize();
		ff.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	}
	
	
	@AfterMethod
	public void tearDown(){		
		eReports.endTest(startTest);
		eReports.flush();
		ff.quit();
	}
	
	//get the date and time stamp
	 
		 public String getdtime(){
			Date date = new Date();
			SimpleDateFormat dformat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
			String dte = dformat.format(date);
			return dte;
		 }
		
//			get screenshot
		 public String getscreen() throws Exception{
			 TakesScreenshot imgcapture=(TakesScreenshot)ff;
				File screen = imgcapture.getScreenshotAs(OutputType.FILE);
				String fpath= "E:\\MayReports\\screenshot\\snap_" + getdtime() + ".png";
				FileUtils.copyFile(screen, new File(fpath));	 
		 		return fpath;
	}

}






