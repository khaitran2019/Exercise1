package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.Constants;

public class BasePage {
	
	protected RemoteWebDriver driver;
	
	public BasePage(RemoteWebDriver _driver) {
		this.driver = _driver; 
	}
	
	protected void waitPageTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	
	protected void waitForElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.SHORT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
}
