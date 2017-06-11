package Day4_Abstarctclass;

import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Abstractclass {
	
	
	FirefoxDriver fd;
	public void Launchapp(String URL) {
		// TODO Auto-generated method stub
		fd= new FirefoxDriver();
		fd.get(URL);
		fd.manage().window().maximize();
	}
	
	
	public void teardown() {
		// TODO Auto-generated method stub
		fd.quit();	
		
	}
	
	public abstract String searchandextract(String search) ;
	

}
