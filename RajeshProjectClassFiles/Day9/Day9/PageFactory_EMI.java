package Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactory_EMI extends Keywords {
	
	@FindBy(css="div[class='frmbody']>div:nth-of-type(1)>div:nth-of-type(3)>input")
	public WebElement txt_amount;
	
	@FindBy(name="interest")
	public WebElement txt_rate;
	
	@FindBy(name="instalment")
	public WebElement txt_tenure;
	
	@FindBy(name="B1")
	public WebElement btn_tenure;
	
	@FindBy(id="four")
	public WebElement txt_Emi;

	
	public PageFactory_EMI(WebDriver driver){		
		PageFactory.initElements(driver, this);		
	}
	
	
	public void enterdetails(String amt,String rate,String tenure){
		
//		txt_amount.sendKeys(amt);
		enterVal(txt_amount, amt);
//		txt_rate.sendKeys(rate);
		enterVal(txt_rate,rate);
//		txt_tenure.sendKeys(tenure);
		enterVal(txt_tenure, tenure);
//		btn_tenure.click();
		clickEvent(btn_tenure);
		
	}
	
	
	
	
	
	

}
