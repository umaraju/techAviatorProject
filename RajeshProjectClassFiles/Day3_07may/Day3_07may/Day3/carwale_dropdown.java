package Day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class carwale_dropdown {
	
	public static void main(String[] args) {
		
		FirefoxDriver fd = new FirefoxDriver();
		fd.get("https://www.carwale.com/");
		fd.manage().window().maximize();
		
		fd.findElement(By.xpath("//li[@data-tabs='usedCars']")).click();
		
		fd.findElement(By.id("budgetBtn")).click();
		
		List<WebElement> ls = fd.findElements(By.xpath("//ul[@id='minPriceList']/li"));
		int size = ls.size();
		
		
		for(int i = 0;i<size;i++){
			
			String output = ls.get(i).getText();
			System.out.println(output);		
			if(output.equals("12 Lakh")){
				ls.get(i).click();
				break;
			}
			
			
		}	
		
		
		
		
		
	}

}
