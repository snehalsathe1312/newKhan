package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BaseClass;

public class Browser extends BaseClass{
	
	
	
	public static  WebDriver openBrowser(String browser) {
		if(browser.equals("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			
		}else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
		}
		
	
	driver.get("https://www.khanacademy.org/");
	driver.manage().window().maximize();
	return driver;
	
	
	
	}
}
