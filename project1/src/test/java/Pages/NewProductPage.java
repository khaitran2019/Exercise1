package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductPage {
	
	private RemoteWebDriver driver;

	// Declare web elements
	@FindBy(xpath = "//input[@name='name']")
	private WebElement txtProductName;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnSave;
	
	@FindBy(xpath = "//button[.='Update Quantity']")
	private WebElement btnUpdateQuality;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public NewProductPage(RemoteWebDriver _driver) {           
        this.driver = _driver; 
        PageFactory.initElements(driver, this);
	}
	
	public void CreateANewProduct(String productName) {
		txtProductName.sendKeys(productName);
	}
	
	public void GotoUpdateQuality() {
		btnUpdateQuality.click();
	}
	
}
