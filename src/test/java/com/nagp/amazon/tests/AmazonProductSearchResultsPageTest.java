package com.nagp.amazon.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.automation.customlisterns.ExtentListeners;
import com.aventstack.extentreports.Status;
import com.nagp.amazon.base.TestBase;
import com.nagp.amazon.pages.AmazonHomePage;
import com.nagp.amazon.pages.AmazonProductSearchResultsPage;
import com.nagp.amazon.util.TestUtil;
 

public class AmazonProductSearchResultsPageTest extends TestBase {

	AmazonProductSearchResultsPage amazonProductSearchResultsPage;
	AmazonHomePage amazonHomePage;
	 
	TestUtil testUtil;

	public AmazonProductSearchResultsPageTest() {
		super();
	}	

	 

	@BeforeMethod
	public void setup() {
		initialization();
		amazonProductSearchResultsPage = new AmazonProductSearchResultsPage();
		amazonHomePage = new AmazonHomePage();
	}

	@Test
	public void validateSortSearchResultsByPriceLowToHighTest() throws InterruptedException {
		ExtentListeners.test.log(Status.INFO, "Test started  for validateSortSearchResultsByPriceLowToHighTest"  );
		amazonHomePage.searchProduct(prop.getProperty("product_to_search"));
		Thread.sleep(3000);
		amazonProductSearchResultsPage.chooseSortSearchResultsByPriceLowToHigh(prop.getProperty("sort_by_value"));
		Thread.sleep(3000);
		Assert.assertTrue(amazonProductSearchResultsPage.validateSearchResultsAreSortedByPriceLowToHigh(), "Products are sorted successfully on basis of Low to High Price");
		ExtentListeners.test.log(Status.INFO, "Test completed  for validateSortSearchResultsByPriceLowToHighTest"  );
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (driver != null) {
			driver.quit();
		}
	}
 
}
