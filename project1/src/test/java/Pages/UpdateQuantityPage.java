package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateQuantityPage extends BasePage{
	
	private String title= "Odoo - Update Quantity";

	// Declare web elements
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btnCreate;
	
	@FindBy(xpath = "//input[@name='inventory_quantity']")
	private WebElement txtQuantity;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnSave;
	
	@FindBy(xpath = "//a[@title='Home menu']")
	private WebElement linkHome;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public UpdateQuantityPage(RemoteWebDriver _driver) {           
        super(_driver);
        waitPageTitle(title);
        PageFactory.initElements(driver, this);
	}
	
	
	public void DefineQuantity(int quantity) {
		//clickBtnCreate();
		btnCreate.click();
		// Init element again to update with new UI
		txtQuantity.clear();
		txtQuantity.sendKeys(Integer.toString(quantity));
		btnSave.click();
	}
	
	public void ClickOnApplicationIcon() {
		linkHome.click();
	}
	
	/**
	 * Handle stale element exception
	 * Try to click 3 times
	 */
	private void clickBtnCreate() {
		int attempts = 0;
	    while(attempts < 3) {
	        try {
	        	btnCreate.click();
	            break;
	        } catch(Exception e) {
	        	// No need to log this exception
	        }
	        attempts++;
	    }
	}
}
