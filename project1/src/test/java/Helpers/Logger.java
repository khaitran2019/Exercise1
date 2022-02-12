package Helpers;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.model.Status;

/**
 * This function help log info to allure report.
 */
public class Logger {
	private org.apache.log4j.Logger log;
	private Boolean screenshotInfo;
	private Boolean screenshotVerify;


	public Logger() {
		log = LogManager.getLogger(Logger.class.getName());
	}
	
	/**
	 * This method help log info (step) and attack to Allure.
	 *
	 * @param message: message will display in allure.
	 */
	public void info(String message) {
		log.info(message);
		System.out.println(message);
//		if (screenshotInfo) {
//			screenshot(message);
//		}
//		Allure.step(message);
	}

	/**
	 * This method help log verify and attach to Allure
	 *
	 * @param message: message will display in allure.
	 */
	public void verify(String message) {
		message = "VERIFY POINT: " + message;
		System.out.print(message);
//		if (screenshotVerify) {
//			screenshot(message);
//		}
//		Allure.step(message);
	}
	
	
	/**
	 * This method help screenshot device.
	 *
	 * @param screenshotFileName: name of file screenshot.
	 */
	@Attachment(value = "Screenshot", type = "image/png")
	public static void screenshot(String screenshotFileName) {
//		ByteArrayInputStream screenshot = new ByteArrayInputStream(
//				((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES));
//		Allure.addAttachment(DriverUtils.getPhysicalDeviceName() + ": " + screenshotFileName, screenshot);
	}
}
