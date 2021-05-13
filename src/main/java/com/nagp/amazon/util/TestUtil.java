package com.nagp.amazon.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nagp.amazon.base.TestBase;
 

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName, String errorMsg) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// After execution, a folder with name "FailedTestsScreenshots" will be created under src folder
		
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + "_" + errorMsg +dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
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

	
	/*
	 * public void tearDown(WebDriver driver, ITestResult result,ExtentReports
	 * extent,ExtentTest extentTest) throws IOException {
	 * 
	 * if (result.getStatus() == ITestResult.FAILURE) { // to add name in extent
	 * report extentTest.log(Status.FAIL, "TEST CASE FAILED IS " +
	 * result.getName()); // to add error/exception in extent report
	 * extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
	 * String screenshotPath = TestUtil.getScreenshot(driver, result.getName(),
	 * result.getThrowable().getMessage()); // to add screenshot in extent report
	 * extentTest.log(Status.FAIL, extentTest.addScreenCapture(screenshotPath)); //
	 * to add screencast/video in extent report //
	 * extentTest.log(LogStatus.FAIL,extentTest.addScreencast(screenshotPath)); }
	 * else if (result.getStatus() == ITestResult.SKIP) {
	 * extentTest.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName()); }
	 * else if (result.getStatus() == ITestResult.SUCCESS) {
	 * extentTest.log(Status.PASS, "Test Case PASSED IS " + result.getName()); } //
	 * ending test and ends the current test and prepare to create html // report
	 * extent.endTest(extentTest); driver.quit(); }
	 */
	
	public ExtentReports setExtent(ExtentReports extent, Properties prop) {
		String fileName = "/test-output/ExtentReport_" + new SimpleDateFormat("dd-MM-yyyy_HH_MM_SS").format(new Date()) + ".html";
		extent = new ExtentReports();
		extent.setSystemInfo("Project Name", "NAGP Amazon Selenium Project ");
		extent.setSystemInfo("User Name", "Anuj Alhans");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
		return extent;
	}		
}
