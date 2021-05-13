package com.amazon.automation.commonmethods;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

 
import com.nagp.amazon.base.TestBase;

public class CommonMethods extends TestBase {

	private static WebDriverWait wait = new WebDriverWait(driver, 30);
 

	public static String captureScreeshot(String testMethodName) {
		// log.debug("Launching the capture screen shot");
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String fileName = d.toString().replace(":", "-").replace(" ", "-");
		String path = System.getProperty("user.dir") + "/FailedTestCasesScreenshots/" + fileName + " " + testMethodName
				+ ".png";
		File destination = new File(path);

		try {

			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Error in capturing screen shot" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An unknown exception occured while capturing screen shot:" + e.getMessage());
			e.printStackTrace();
		}
		return path;
	}

}
