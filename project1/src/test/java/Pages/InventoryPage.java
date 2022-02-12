package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	
	private RemoteWebDriver driver;

	// Declare web elements
	@FindBy(xpath = "//div[@class='o_menu_sections']//span[text()='Products']")
	private WebElement menuMainProduct;
	
	@FindBy(xpath = "//div[@class='o_menu_sections']//a[text()='Products']")
	private WebElement menuSubProduct;
	
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public InventoryPage(RemoteWebDriver _driver) {           
        this.driver = _driver; 
        PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Navigate to Inventory
	 */
	public void NavigateToProducts() {
		menuMainProduct.click();
		menuSubProduct.click();
	}
}
