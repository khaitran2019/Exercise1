package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateQuantityPage {
	
	private RemoteWebDriver driver;

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
        this.driver = _driver; 
        PageFactory.initElements(driver, this);
	}
	
	
	public void DefineQuantity(int quantity) {
		System.out.println("DefineQuantity 0");
		//btnCreate.click();
		clickBtnCreate();
		System.out.println("DefineQuantity 1");
		// Init element again to update with new UI
		PageFactory.initElements(driver, this);
		txtQuantity.clear();
		System.out.println("DefineQuantity 2");
		txtQuantity.sendKeys(Integer.toString(quantity));
		System.out.println("DefineQuantity 3");
		btnSave.click();
		System.out.println("DefineQuantity 4");
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
	        	e.printStackTrace();
	        }
	        attempts++;
	    }
	}
}
