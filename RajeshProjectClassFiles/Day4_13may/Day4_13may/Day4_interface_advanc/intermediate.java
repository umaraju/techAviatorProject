package Day4_interface_advanc;

import org.openqa.selenium.firefox.FirefoxDriver;

public class intermediate implements SearchInter{
	FirefoxDriver fd;
	public void Launchapp(String URL) {
		// TODO Auto-generated method stub
		fd= new FirefoxDriver();
		fd.get(URL);
		fd.manage().window().maximize();
	}

	public String searchandextract(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	public void teardown() {
		// TODO Auto-generated method stub
		fd.quit();	
	}
	
	
	
	
	
	
	
	

}
