package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends BasePage{

	private String title = "Odoo - WH/MO";

	// Declare web elements
	@FindBy(xpath = "//a[@name='product_id']")
	private WebElement linkProductName;

	@FindBy(xpath = "//span[@name='qty_producing']")
	private WebElement spanQuantity;

	/**
	 * Constructor
	 * 
	 * @param _driver
	 */
	public OrdersPage(RemoteWebDriver _driver) {
		super(_driver);
		waitPageTitle(title);
		PageFactory.initElements(driver, this);
	}

	public boolean doesProductNameExist(String productName) {
		String xpath = String.format("//a[@name='product_id' and .='%s']", productName);
		return doesElementExist(xpath);
	}
	
	public boolean doesQuantityExist(String quantity) {
		String xpath = String.format("//span[@name='qty_producing' and .='%s']", quantity);
		return doesElementExist(xpath);
	}
}
