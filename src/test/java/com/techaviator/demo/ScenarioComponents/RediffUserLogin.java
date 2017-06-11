package com.techaviator.demo.ScenarioComponents;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.techaviator.demo.DataProviderComponents.RediffDataProvider;
import com.techaviator.demo.GenericComponents.RediffBaseClass;
import com.techaviator.demo.GenericComponents.RediffGenericAction;
import com.techaviator.demo.PageFactoryComponents.RediffLoginPage;

public class RediffUserLogin extends RediffBaseClass {

	//Declare instance variables
	RediffLoginPage loginWebElement;
	RediffGenericAction act;
//	Logger log;
	@BeforeMethod
	public void beforeMethod(){
		
		//Initialize instance variables
		
	}

	@Test(dataProvider = "RediffTestData", dataProviderClass = RediffDataProvider.class, enabled = true)
	public void userLogin_Valid(Map<String, String> testData) throws IOException {
		loginWebElement = new RediffLoginPage(driver);
		act = new RediffGenericAction();
		log = Logger.getLogger(RediffUserLogin.class);
		log.info("Test execution started...");
		
		//Enter User ID, Password and Submit
		act.clickLink(loginWebElement.webLnk_LinkText_SignIn);
		act.enterText(loginWebElement.webTxt_Name_EmailID, testData.get("UserName"));
		act.enterText(loginWebElement.webTxt_Name_Password, testData.get("Password"));
		act.clickButton(loginWebElement.webBtn_Xpath_Submit);

		String exp = testData.get("ExpectedResult");
		
		//Validate valid login result
		String actual = act.getText(loginWebElement.strText_ClassName_LoginName);
		
		//containsFullImageValidation(actual, exp, "Login to application");
		equalsFullImageValidation(actual, exp, "Login to application");
		
//		if(actual.equalsIgnoreCase(exp)) {
//			System.out.println("Valid Login Pass  "+ "Actual: "+ actual + "Expected: "+ testData.get("ExpectedResult"));
//			log.info("Login with valid credentials pass");
//		} else {
//			System.out.println("Valid Login Failed  "+ "Actual: "+ actual + "Expected: "+ testData.get("ExpectedResult"));
//			log.info("Login with invalid credentials failed");
//		}
//		log.info("Test execution completed...");
	}

	@Test(dataProvider = "RediffTestData", dataProviderClass = RediffDataProvider.class, enabled = false)
	public void userLogin_inValid(Map<String, String> testData) throws InterruptedException, IOException {

		log.info("Test execution started...");
		
		//Enter User ID, Password and Submit
		act.clickLink(loginWebElement.webLnk_LinkText_SignIn);
		act.enterText(loginWebElement.webTxt_Name_EmailID, testData.get("UserName"));
		act.enterText(loginWebElement.webTxt_Name_Password, testData.get("Password"));
		act.clickButton(loginWebElement.webBtn_Xpath_Submit);
		Thread.sleep(3000);
		
		//Validate in valid login result
		String actual = act.getText(loginWebElement.strText_XPath_ErrorMsg);
		
		equalsFullImageValidation(actual, testData.get("ExpectedResult"), "Login to application");
	
		if (actual.equalsIgnoreCase(testData.get("ExpectedResult"))) {
			//System.out.println("inValid Login Pass  "+ "Actual: "+ actual + "Expected: "+ testData.get("ExpectedResult"));
			log.info("Login with invalid credentials pass");
			startTest.log(LogStatus.PASS, "Login is passed");
		} else {
			//System.out.println("inValid Login Failed  "+ "Actual: "+ actual + "Expected: "+ testData.get("ExpectedResult"));
			log.info("Login with invalid credentials failed");
			startTest.log(LogStatus.PASS, "Login is failed"+startTest.addScreencast(takeScreenShot()));
		}
	}
}
