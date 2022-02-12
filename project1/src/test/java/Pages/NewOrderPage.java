package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.Constants;
import Helpers.Utils;

public class NewOrderPage {
	
	private RemoteWebDriver driver;

	// Declare web elements
	@FindBy(xpath = "(//input[contains(@id, 'o_field_input_')])[1]")
	private WebElement txtProductName;
	
	@FindBy(xpath = "//input[@name='qty_producing']")
	private WebElement txtQuantity;
			
	@FindBy(xpath = "//button[@name='action_confirm']")
	private WebElement btnConfirm;
		
	@FindBy(xpath = "//button[@name='button_mark_done' and @class='btn btn-primary']")
	private WebElement btnMarkAsDone;
	
	@FindBy(xpath = "//button[.='Ok']")
	private WebElement btnOK;
	
	@FindBy(xpath = "//button[.='Apply']")
	private WebElement btnApply;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public NewOrderPage(RemoteWebDriver _driver) {           
        this.driver = _driver; 
        PageFactory.initElements(driver, this);
	}
	
	
	public void CreateOrder(String productName) {
		txtProductName.sendKeys(productName);

		// Handle case not found product name
		Utils.Sleep(2);
		btnConfirm.click();
	}
	
	public void MarkOrderAsDone() {
		btnMarkAsDone.click();
		btnOK.click();
		btnApply.click();
	}
}
