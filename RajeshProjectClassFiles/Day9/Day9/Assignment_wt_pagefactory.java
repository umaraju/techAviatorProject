package Day9;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Assignment_wt_pagefactory extends Base {
	
//	Logger
	Logger Assign=Logger.getLogger(Assignment_wt_pagefactory.class);
	
	
	@Test(dataProvider="dp_emi",dataProviderClass=Day9.dp.class)
	public void EMICalc(Map<String,String> mp) throws Exception{		
		startTest = eRports.startTest("TC01");
		Assign.info("Started execution");
		String amt=mp.get("Amount").replace(".0", "");
		String rate=mp.get("rate").replace(".0", "");
		String tenure = mp.get("tenure").replace(".0", "");
		
//		create object of page factory
		PageFactory_EMI emiPage = new PageFactory_EMI(ff);
		emiPage.enterdetails(amt, rate, tenure);
		
		String act_output = emiPage.txt_Emi.getAttribute("value");
		Assign.info("Application ouput is: " + act_output);
		startTest.log(LogStatus.INFO, "Application output","Application ouput is: " + act_output);
		String exp_output = mp.get("exp");
//		validation
		cv_equals(exp_output, act_output, "EMI Validation");
		

		
	}
	

}
