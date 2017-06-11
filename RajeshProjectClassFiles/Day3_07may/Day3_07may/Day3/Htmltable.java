package Day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Htmltable {

	public static void main(String[] args) {
		FirefoxDriver fd = new FirefoxDriver();
		fd.get("http://www.homeloanshub.com/mortgage-calculator/");
		fd.manage().window().maximize();
		
		String tenure = "5";
		fd.findElement(By.name("principal")).sendKeys("10000");
		fd.findElement(By.name("interest")).sendKeys("10");
		fd.findElement(By.name("tenure")).sendKeys(tenure);
		
		int yearinint = Integer.parseInt(tenure);
		int monthinit = yearinint * 12;
		
		fd.findElement(By.className("btn1")).click();
		
		List<WebElement> ls = fd.findElements(By.xpath("//div[@id='emiresults']/table//tr"));
		int size = ls.size();
		
		System.out.println(size);
//		Second way
//		String souptu = fd.findElement(By.xpath("//div[@id='emiresults']/table/tbody/tr[" + size + "]/td[2]")).getText();
//		System.out.println(souptu);
		
//		third way
		String backwardoutput = fd.findElement(By.xpath("//div[@id='emiresults']/table/tbody//td[text()='" + monthinit + "']/../td[2]")).getText();
		
		System.out.println(backwardoutput);
		
		
//		One way
//		for(int i = 1 ; i<=size;i++){
//			
//			String months = fd.findElement(By.xpath("//div[@id='emiresults']/table/tbody/tr[" + i + "]/td[1]")).getText();
//			
//			if(months.equals(String.valueOf(monthinit))){
//				
//				String output = fd.findElement(By.xpath("//div[@id='emiresults']/table/tbody/tr[" + i + "]/td[2]")).getText();
//				System.out.println(output);
//				break;
//				
//			}	
//			
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
