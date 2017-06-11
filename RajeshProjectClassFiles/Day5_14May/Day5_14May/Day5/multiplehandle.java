package Day5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class multiplehandle {
public static void main(String[] args) {
	WebDriver ff = new FirefoxDriver();
	ff.get("http://in.rediff.com/");
	ff.manage().window().maximize();
//	parent window
	String pwindow = ff.getWindowHandle();
	
	Set<String> allhandles = ff.getWindowHandles();
	
	Iterator<String> it = allhandles.iterator();
	while(it.hasNext()){
		String handle = it.next();
		if(!pwindow.equals(handle)){
			ff.switchTo().window(handle);
			ff.close();
			ff.switchTo().window(pwindow);
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
}
}
