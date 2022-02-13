package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.Constants;

public class BasePage {
	
	protected RemoteWebDriver driver;
	
	public BasePage(RemoteWebDriver _driver) {
		this.driver = _driver; 
	}
	
	public void NavigateToProducts() {
		clickMenuItem("Products", "Products");
	}
	
	/**
	 * Wait for page title display in expected time
	 * @param expectedTitle
	 */
	protected void waitPageTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.MEDIUM_TIME);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	
	/**
	 * Wait for web element clickable in expected time
	 * @param xpath
	 */
	protected void waitForElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.MEDIUM_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	protected boolean doesElementExist(String xpath) {
		boolean isExisted = false;
		try {
			WebElement elm = driver.findElementByXPath(xpath);
			if (elm.isDisplayed()) {
				isExisted = true;
			}
		} catch (Exception e) {
			// Do nothing
		}
		return isExisted;
	}
	
	/**
	 * Find and lick on menu item main item > sub item
	 * @param mainItem
	 * @param subItem
	 */
	protected void clickMenuItem(String mainItem, String subItem) {
		String mainXpath = "//div[@class='o_menu_sections']//span[text()='%s']";
		mainXpath = String.format(mainXpath, mainItem);
				
		String subXpath = "//div[@class='o_menu_sections']//a[text()='%s']";
		subXpath = String.format(subXpath, subItem);
		
		driver.findElementByXPath(mainXpath).click();
		driver.findElementByXPath(subXpath).click();
	}
}
