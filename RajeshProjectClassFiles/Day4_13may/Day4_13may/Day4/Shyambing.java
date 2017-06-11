package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Shyambing implements SearchInter{
	FirefoxDriver fd;
	public void Launchapp(String URL) {
		// TODO Auto-generated method stub
		fd= new FirefoxDriver();
		fd.get(URL);
		fd.manage().window().maximize();
		
	}

	public String searchandextract(String search) {
		// TODO Auto-generated method stub
		fd.findElement(By.id("sb_form_q")).sendKeys(search);
		fd.findElement(By.id("sb_form_go")).click();
		
		return fd.findElement(By.className("sb_count")).getText();
	}

	public void teardown() {
		// TODO Auto-generated method stub
		fd.quit();	
	}


}
