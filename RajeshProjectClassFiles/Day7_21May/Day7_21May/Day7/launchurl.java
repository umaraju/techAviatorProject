package Day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.firefox.FirefoxDriver;

public class launchurl {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
//		System.out.println(System.getProperty("user.dir"));
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\settings.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
//		System.out.println(prop.getProperty("qa"));
		
		
		
		
		
		FirefoxDriver fd = new FirefoxDriver();
		fd.get(prop.getProperty(prop.getProperty("abc")));
		
		
	}
	
}
