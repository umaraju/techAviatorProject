package Day3;

import org.openqa.selenium.firefox.FirefoxDriver;

public class searchBase {
	FirefoxDriver fd;
	void OpenApp(String url){
		fd= new FirefoxDriver();
		fd.get(url);
		fd.manage().window().maximize();	
		
	}
	
	
void tearDown(){
		
		fd.quit();		
		
	}
	

}
