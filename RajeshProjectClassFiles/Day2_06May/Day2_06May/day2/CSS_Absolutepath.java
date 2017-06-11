package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSS_Absolutepath {
	
	
public static void main(String[] args) {
		
//		Launch App
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		
//		One way
//		Enter amount
//		ff.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[2]/span/div/div[2]/div[1]/div[3]/input")).sendKeys("10000");
//		ff.findElement(By.cssSelector("html>body>form>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(2)>span>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)>input")).sendKeys("10000");
		
//		second way
			
//		ff.findElement(By.xpath("/html/body/form/div[@id='wrapper']/div[@id='body_content']/div[@class='right']/span/div/div[@class='frmbody']/div[1]/div[@class='pdDiv3']/input")).sendKeys("10000");
//ff.findElement(By.cssSelector("html>body>form>div[id='wrapper']>div[id='body_content']>div[class='right']>span>div>div[class='frmbody']>div[class='drow']:nth-of-type(1)>div[class='pdDiv3']>input")).sendKeys("100000");
//ff.findElement(By.cssSelector("html>body>form>div#wrapper>div#body_content>div.right>span>div>div.frmbody>div.drow:nth-of-type(1)>div.pdDiv3>input")).sendKeys("100000");
		ff.findElement(By.cssSelector("html body form div#wrapper div#body_content div.right span div div.frmbody div.drow:nth-of-type(1) div.pdDiv3 input")).sendKeys("100000");
//		html body form#aspnetForm div#wrapper div#body_content div.right span#PgGeneral1_A_Cont_lblContent div.dynamicPg div.frmbody div.drow div.pdDiv3 input#one
		
		
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
