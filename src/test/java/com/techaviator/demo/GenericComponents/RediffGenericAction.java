package com.techaviator.demo.GenericComponents;

import org.openqa.selenium.WebElement;

public class RediffGenericAction {
	
	//Clear input text filed
	public void clearText(WebElement webElementLocator) {
		
		webElementLocator.clear();	
	}
	
	//Enter focus cursor in input box
	public void focusText(WebElement webElementLocator) {
		
		webElementLocator.click();
	}
	
	//Enter text in input box
	public void enterText(WebElement webElementLocator, String inputValue) {
		
		webElementLocator.sendKeys(inputValue);	
	}
	
	//Click web button
	public void clickButton(WebElement webElementLocator) {
		
		webElementLocator.click();
		
	}
	
	//Click web link
	public void clickLink(WebElement webElementLocator) {
		
		webElementLocator.click();
		
	}
	
	//Get text string from web page
	public String getText(WebElement webElementLocator) {
		
		String strText = webElementLocator.getText();
		return strText;
		
	}
	
	//Select web list item
	//Explicit wait on web element
	//Check web element exists
	//Check web element displayed
	//Check web element selected
}
