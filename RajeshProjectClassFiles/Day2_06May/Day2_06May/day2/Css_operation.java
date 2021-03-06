package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Css_operation {

	public static void main(String[] args) {
		
//		Launch App
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		
//		Enter amount
//		ff.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[2]/span/div/div[2]/div[1]/div[3]/input")).sendKeys("10000");		
//		ff.findElement(By.xpath("//input[@id='one']")).sendKeys("10000");
//		ff.findElement(By.xpath("//div[@class='frmbody']/div[1]/div[@class='pdDiv3']/input")).sendKeys("10000");
		
//		Forward traversing
		ff.findElement(By.xpath("//div[@class='frmbody']/div[1]//input")).sendKeys("100000");
		
//		Enter rate of Interest
//		And Operation
//		ff.findElement(By.xpath("//input[@id='two' and @name='interest']")).sendKeys("10");
//		ff.findElement(By.cssSelector("input[id='two'][name='interest']")).sendKeys("10");
//		id=two
//		OR Operation
//		ff.findElement(By.xpath("//input[@id='twoplus' or @name='interest']")).sendKeys("10");
		ff.findElement(By.cssSelector("input[id='twoplus'],input[name='interest']")).sendKeys("10");
//		Enter duration
		ff.findElement(By.name("instalment")).sendKeys("120");
		
//		Click on calculate
		ff.findElement(By.name("B1")).click();
		
//		Extract EMI
		String output = ff.findElement(By.id("four")).getAttribute("value");
		
		System.out.println(output);
		
		
	}	
	
}
