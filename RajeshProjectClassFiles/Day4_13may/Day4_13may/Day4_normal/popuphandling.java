package Day4_normal;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class popuphandling {

	public static void main(String[] args) {
		
		WebDriver ff = new FirefoxDriver();
		ff.get("https://bookshopofindia.com/booknotfound.asp");
		ff.manage().window().maximize();
		
		ff.findElement(By.name("btnSubmit")).click();
		
		Alert alert = ff.switchTo().alert();
		
		System.out.println(alert.getText());
//		alert.dismiss();
		alert.accept();
		
		ff.switchTo().defaultContent();
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
