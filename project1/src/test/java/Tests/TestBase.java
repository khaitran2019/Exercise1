package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Helpers.Constants;
import Helpers.DriverHelper;
import Helpers.Logger;


public class TestBase {
	protected RemoteWebDriver driver;
	protected Logger log;
	
	@Parameters({"flatform"})
	@BeforeMethod()
	public void beforeTest(String flatform) {
		log = new Logger();
		driver = DriverHelper.createDriver(flatform);
		driver.manage().timeouts().implicitlyWait(Constants.MEDIUM_TIME, TimeUnit.SECONDS);
		driver.get(Constants.BASE_URL);
	}

	@AfterMethod()
	public void afterTest() {
		driver.quit();
	}
	
}
