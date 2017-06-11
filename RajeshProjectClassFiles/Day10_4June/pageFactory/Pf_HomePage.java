package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibraries.CommonActions;

public class Pf_HomePage extends CommonActions{
	
	@FindBy(linkText="Sign In")
	public WebElement lk_signIn;
	
	@FindBy(id="username")
	public WebElement lbl_userName;
	
	public Pf_HomePage(WebDriver driver){		
		PageFactory.initElements(driver, this);		
	}
	
	
	
	
	

}
