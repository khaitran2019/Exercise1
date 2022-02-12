package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private RemoteWebDriver driver;

	// Declare web elements
	@FindBy(xpath = "//div[text()='Inventory']")
	private WebElement divInventory;
	
	@FindBy(xpath = "//div[text()='Manufacturing']")
	private WebElement divManufacturing;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public HomePage(RemoteWebDriver _driver) {           
        this.driver = _driver; 
        PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Navigate to Inventory
	 */
	public void NavigateToInventory() {
		divInventory.click();
	}
	
	public void NavigateToManufacturing() {
		divManufacturing.click();
	}
}
