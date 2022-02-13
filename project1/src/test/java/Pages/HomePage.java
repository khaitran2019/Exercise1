package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	//private String title = "Odoo";
	
	// Declare web elements
	@FindBy(xpath = "//div[text()='Inventory']")
	private WebElement divInventory;
	
	@FindBy(xpath = "//div[text()='Manufacturing']")
	private WebElement divManufacturing;
	
	private String devXpathInventory= "//div[text()='Inventory']";
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public HomePage(RemoteWebDriver _driver) {  
		super(_driver);
		waitForElement(devXpathInventory);
        PageFactory.initElements(driver, this);
	}
	
	
	public void NavigateToInventory() {
		divInventory.click();
	}
	
	public void NavigateToManufacturing() {
		divManufacturing.click();
	}
}
