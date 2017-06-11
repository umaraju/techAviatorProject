package Day9;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Assignment extends Base {
	
//	Logger
	Logger Assign=Logger.getLogger(Assignment.class);
	
	
	@Test(dataProvider="dp_emi",dataProviderClass=Day9.dp.class)
	public void EMICalc(Map<String,String> mp) throws Exception{		
		startTest = eRports.startTest("TC01");
		Assign.info("Started execution");
		ff.findElement(By.cssSelector("div[class='frmbody']>div:nth-of-type(1)>div:nth-of-type(3)>input")).sendKeys(mp.get("Amount").replace(".0", ""));
		//		Enter rate of Interest
		ff.findElement(By.name("interest")).sendKeys(mp.get("rate").replace(".0", ""));
		//		Enter duration
		ff.findElement(By.name("instalment")).sendKeys(mp.get("tenure").replace(".0", ""));
		//		Click on calculate
		ff.findElement(By.name("B1")).click();
		//		Extract EMI
		String act_output = ff.findElement(By.id("four")).getAttribute("value");
		Assign.info("Application ouput is: " + act_output);
		startTest.log(LogStatus.INFO, "Application output","Application ouput is: " + act_output);
		String exp_output = mp.get("exp");
//		validation
		if(act_output.equals(exp_output)){
			System.out.println("pass");
			Assign.info("Passed as the EMI is correct");
			startTest.log(LogStatus.PASS, "EMI Validation","Passed as the EMI is correct");
		}else{
			System.out.println("fail");
			Assign.error("Failed as the actual is " + act_output + " and expected was " + exp_output);
			startTest.log(LogStatus.FAIL, "EMI Validation","Failed as the actual is " + act_output + " and expected was " + exp_output + startTest.addScreenCapture(getscreen()));
		}
		

		
	}
	

}
