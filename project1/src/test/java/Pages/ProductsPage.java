package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage{
	
	private String title = "Odoo - Products";

	// Declare web elements
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btnCreate;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public ProductsPage(RemoteWebDriver _driver) {    
		super(_driver);
		waitPageTitle(title);
        PageFactory.initElements(driver, this);
	}
	
	
	public void NavigateToCreateNewProduct() {
		btnCreate.click();
	}
	
}
