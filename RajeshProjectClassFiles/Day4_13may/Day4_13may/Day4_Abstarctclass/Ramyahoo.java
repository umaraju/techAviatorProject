package Day4_Abstarctclass;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ramyahoo extends Abstractclass{

	public String searchandextract(String search) {
		// TODO Auto-generated method stub
		fd.findElement(By.tagName("input")).sendKeys(search);
		fd.findElement(By.className("sbb")).click();
		String output = fd.findElement(By.xpath("//span[contains(text(),' results')]")).getText();
		return output;
	}

//
//	public String searchandextract(String search) {
//		// TODO Auto-generated method stub
//		fd.findElement(By.tagName("input")).sendKeys(search);
//		fd.findElement(By.className("sbb")).click();
//		String output = fd.findElement(By.xpath("//span[contains(text(),' results')]")).getText();
//		return output;
//	}
//
//
//	
//	
//	public String getPagetitle(){
//		
//		return fd.getTitle();
//	}
//	
//	
	

}
