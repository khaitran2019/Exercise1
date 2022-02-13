package Pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage{
	
	private String title = "Odoo - Inventory Overview";
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public InventoryPage(RemoteWebDriver _driver) {           
        super(_driver);
        waitPageTitle(title);
        PageFactory.initElements(driver, this);
	}
}
