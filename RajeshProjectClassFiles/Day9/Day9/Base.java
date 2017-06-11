package Day9;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {
	WebDriver ff ;
	ExtentReports eRports;
	ExtentTest startTest;
	
	@BeforeSuite
	public void prequisite(){
		eRports = new ExtentReports("E:\\MayReports\\Automation report_" + getdtime() + ".html");
	}
	
	@BeforeMethod
	public void launchApp(){
		ff= new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");		
		
	}
	
	@AfterMethod
	public void tearDown(){
		eRports.endTest(startTest);
		eRports.flush();
//		close the app
			ff.quit();
	}
	
//get the date and time stamp
 
	 public String getdtime(){
		Date date = new Date();
		SimpleDateFormat dformat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String dte = dformat.format(date);
		return dte;
	 }
	
//	get screenshot
	 public String getscreen() throws Exception{
		 TakesScreenshot imgcapture=(TakesScreenshot)ff;
			File screen = imgcapture.getScreenshotAs(OutputType.FILE);
			String fpath= "E:\\MayReports\\screenshot\\snap_" + getdtime() + ".png";
			FileUtils.copyFile(screen, new File(fpath));	 
	 		return fpath;
}

//	 common validation
	 public void cv_equals(String exp,String act,String stepname) throws Exception{
	 if(act.equals(exp)){

			startTest.log(LogStatus.PASS, stepname,"Passed the step " + stepname);
		}else{
			
			startTest.log(LogStatus.FAIL, stepname,"Failed as the actual is " + act + " and expected was " + exp + startTest.addScreenCapture(getscreen()));
		}
		
	 }
	 
	 
	 
	 public void cv_equals(double exp,double act,String stepname) throws Exception{
		 if(act==exp){

				startTest.log(LogStatus.PASS, stepname,"Passed the step " + stepname);
			}else{
				
				startTest.log(LogStatus.FAIL, stepname,"Failed as the actual is " + act + " and expected was " + exp + startTest.addScreenCapture(getscreen()));
			}
			
		 }
		 
	 
	 

}