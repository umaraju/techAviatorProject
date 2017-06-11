package com.techaviator.demo.PageFactoryComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.techaviator.demo.GenericComponents.RediffBaseClass;

public class RediffLoginPage extends RediffBaseClass {
	
	public RediffLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//Login page web elements
	
	@FindBy(linkText="Sign In")
	public WebElement webLnk_LinkText_SignIn;
	
	@FindBy(name = "logid")
	public WebElement webTxt_Name_EmailID;
	
	@FindBy(name = "pswd")
	public WebElement webTxt_Name_Password;
	
	@FindBy(xpath = "//input[@value = 'Login' ]")
	public WebElement webBtn_Xpath_Submit;
	
	@FindBy(className = "proper")
	public WebElement strText_ClassName_LoginName;
	
	@FindBy(xpath = "//b[contains(text(), 'Sorry')]")
	public WebElement strText_XPath_ErrorMsg;
	

}
