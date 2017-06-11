package Day4_interface_advanc;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Shyambing extends intermediate{

	public String searchandextract(String search) {
		// TODO Auto-generated method stub
		fd.findElement(By.id("sb_form_q")).sendKeys(search);
		fd.findElement(By.id("sb_form_go")).click();
		
		return fd.findElement(By.className("sb_count")).getText();
	}



}
