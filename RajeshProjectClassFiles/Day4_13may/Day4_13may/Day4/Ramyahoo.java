package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ramyahoo implements SearchInter{
	FirefoxDriver fd;
	public void Launchapp(String URL) {
		// TODO Auto-generated method stub
		fd= new FirefoxDriver();
		fd.get(URL);
		fd.manage().window().maximize();
		
	}

	public String searchandextract(String search) {
		// TODO Auto-generated method stub
		fd.findElement(By.tagName("input")).sendKeys(search);
		fd.findElement(By.className("sbb")).click();
		String output = fd.findElement(By.xpath("//span[contains(text(),' results')]")).getText();
		return output;
	}

	public void teardown() {
		// TODO Auto-generated method stub
		fd.quit();	
	}
	
	
	public String getPagetitle(){
		
		return fd.getTitle();
	}
	
	
	

}
