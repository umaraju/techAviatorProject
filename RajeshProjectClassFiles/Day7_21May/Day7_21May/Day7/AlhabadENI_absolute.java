package Day7;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AlhabadENI_absolute {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\settings.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String btype="ff;ch;ie";

		String[] br = btype.split(";");
		
		for(int i = 0 ;i<br.length;i++){
		WebDriver ff=null;	
	if(br[i].equals("ff")){
		ff = new FirefoxDriver();
		
	}else if(br[i].equals("ch")) {
		System.setProperty("webdriver.chrome.driver",prop.getProperty("path") + "\\chromedriver.exe" );
	ff = new ChromeDriver();
		
	}else if(br[i].equals("ie")){
		
		System.setProperty("webdriver.ie.driver", prop.getProperty("path") + "\\IEDriverServer.exe");
		ff = new InternetExplorerDriver();
		
	}
		
		
//		Launch App
//		Firefox browser
//		FirefoxDriver ff = new FirefoxDriver();
		
//		chrome driver
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver",prop.getProperty("path") + "\\chromedriver.exe" );
//		ChromeDriver ff = new ChromeDriver();
		
//		Ie driver
		
//		System.setProperty("webdriver.ie.driver", prop.getProperty("path") + "\\IEDriverServer.exe");
//		InternetExplorerDriver ff = new InternetExplorerDriver();
			
		
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		
//		Enter amount
//		ff.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[2]/span/div/div[2]/div[1]/div[3]/input")).sendKeys("10000");		
		ff.findElement(By.xpath("/html/body/form/div[@id='wrapper']/div[@id='body_content']/div[@class='right']/span/div/div[@class='frmbody']/div[1]/div[@class='pdDiv3']/input")).sendKeys("10000");
//		Enter rate of Interest
		ff.findElement(By.name("interest")).sendKeys("10");
		
//		Enter duration
		ff.findElement(By.name("instalment")).sendKeys("120");
		
//		Click on calculate
		ff.findElement(By.name("B1")).click();
		
//		Extract EMI
		String output = ff.findElement(By.id("four")).getAttribute("value");
		
		System.out.println(output);
		ff.quit();
		}
		
	}	
	
}
