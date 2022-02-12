package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturingPage extends BasePage{
	
	private String title = "Odoo - Manufacturing Orders";

	// Declare web elements
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btnCreate;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public ManufacturingPage(RemoteWebDriver _driver) {           
        super(_driver);
        waitPageTitle(title);
        PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Create order
	 */
	public void NavigateToCreateOrder() {
		btnCreate.click();
	}
}
