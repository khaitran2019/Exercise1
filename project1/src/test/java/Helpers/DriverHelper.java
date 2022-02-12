package Helpers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class DriverHelper {
		
	public static RemoteWebDriver createDriver(String flatform) {
		
		switch (flatform.toUpperCase()) {
			case "FIREFOX": 
				return initFireFoxDriver();
				
			case "CHROME":
				return initChromeDriver();
				
			default:
				return null;
		}
	}
	
	private static FirefoxDriver initFireFoxDriver() {
		FirefoxDriverManager driverManager = new FirefoxDriverManager();
		driverManager.setup();	
		
		FirefoxDriver driver= new FirefoxDriver();
		return driver;
	}
	
	private static ChromeDriver initChromeDriver() {
		ChromeDriverManager driverManager = new ChromeDriverManager();
		driverManager.setup();
		
		ChromeDriver driver= new ChromeDriver();
		return driver;
	}
	
}
