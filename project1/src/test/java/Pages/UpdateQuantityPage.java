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
		btnCreate.click();
		
		// Clear textbox before type new text
		txtQuantity.clear();
		txtQuantity.sendKeys(Integer.toString(quantity));
		
		btnSave.click();
	}
	
	public void ClickOnApplicationIcon() {
		linkHome.click();
	}

}
