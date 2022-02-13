package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	// Declare web elements
	@FindBy(xpath = "//input[@name='login']")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement btnLogin;
	
	/**
	 * Constructor 
	 * @param _driver
	 */
	public LoginPage(RemoteWebDriver _driver) {           
        super(_driver);
        PageFactory.initElements(driver, this);
	}
	
	
	public void Login(String userName, String password) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		
		btnLogin.click();
	}
}
