package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class crossbrowser {

	public static void main(String[] args) {
		
//		Launch App
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		
//		Enter amount
//		ff.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[2]/span/div/div[2]/div[1]/div[3]/input")).sendKeys("10000");		
		ff.findElement(By.xpath("/html/body/form/div[@id='wrapper']/div[@id='body_content']/div[@class='right']/span/div/div[@class='frmbody']/div[1]/div[@class='pdDiv3']/input")).sendKeys("10000");
//		Enter rate of Interest
		ff.findElement(By.name("interest")).sendKeys("10");
		
//		Enter duration
		ff.findElement(By.name("instalment")).sendKeys("120");
		
//		Click on calculate
		ff.findElement(By.name("B1")).click();
		
//		Extract EMI
		String output = ff.findElement(By.id("four")).getAttribute("value");
		
		System.out.println(output);
		
		
	}	
	
}
