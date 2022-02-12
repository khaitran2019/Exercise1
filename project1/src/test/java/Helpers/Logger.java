package Helpers;

import java.io.ByteArrayInputStream;
import org.apache.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

/**
 * This function help log info and screenshots to allure report.
 */
public class Logger {
	private org.apache.log4j.Logger log;
	private Boolean captureScreenshots;
	private RemoteWebDriver driver;


	public Logger(RemoteWebDriver _driver, boolean _captureScreenshots) {
		log = LogManager.getLogger(Logger.class.getName());
		
		this.driver = _driver;
		this.captureScreenshots = _captureScreenshots;
	}
	
	/**
	 * This method help log info (step) and attack to Allure.
	 *
	 * @param message: message will display in allure.
	 */
	public void info(String message) {
		log.info(message);
		System.out.println(message);
		if (captureScreenshots) {
			screenshot(message);
		}
		Allure.step(message);
	}
	
	
	/**
	 * This method help screenshot device.
	 *
	 * @param screenshotFileName: name of file screenshot.
	 */
	@Attachment(value = "Screenshot", type = "image/png")
	public void screenshot(String screenshotFileName) {
		ByteArrayInputStream screenshot = new ByteArrayInputStream(this.driver.getScreenshotAs(OutputType.BYTES));
		Allure.addAttachment(screenshotFileName, screenshot);
	}
}
