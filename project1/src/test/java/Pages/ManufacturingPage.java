package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturingPage {
	
	private RemoteWebDriver driver;

	// Declare web elements
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btnCreate;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public ManufacturingPage(RemoteWebDriver _driver) {           
        this.driver = _driver; 
        PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Create order
	 */
	public void NavigateToCreateOrder() {
		btnCreate.click();
	}
}
