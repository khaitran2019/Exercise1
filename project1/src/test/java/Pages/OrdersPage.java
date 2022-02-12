package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	
	private RemoteWebDriver driver;

	// Declare web elements
	@FindBy(xpath = "//a[@name='product_id']")
	private WebElement linkProductName;
	
	
	@FindBy(xpath = "//span[@name='qty_producing']")
	private WebElement spanQuantity;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public OrdersPage(RemoteWebDriver _driver) {           
        this.driver = _driver; 
        PageFactory.initElements(driver, this);
	}
		
	public String getProductName() {
		return linkProductName.getText();
	}
	
	public String getQuantityText() {
		return spanQuantity.getText();
	}
}
