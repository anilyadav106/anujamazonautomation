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
import com.nagp.amazon.util.TestUtil;
 

public class AmazonHomePageTest extends TestBase {

	AmazonHomePage amazonHomePage;


	TestUtil testUtil;

	public AmazonHomePageTest() {
		super();
	}

	@BeforeSuite
	public void setExtent() {
		testUtil = new TestUtil();



	}

	@BeforeMethod
	public void setup() {
		initialization();
		amazonHomePage = new AmazonHomePage();

	}

	@Test(priority = 1)
	public void amazonLogoOnHomePageTest() {
		
		ExtentListeners.test.log(Status.INFO, "Test Staretd for amazonLogoOnHomePageTest"  );
		 
		boolean isAmazonLogoVisible = amazonHomePage.isAmazonLogoVisible();
		Assert.assertEquals(isAmazonLogoVisible, true);
		ExtentListeners.test.log(Status.INFO, "Test completed for amazonLogoOnHomePageTest"  );
	}

	@Test(priority = 2)
	public void clickAndValidateTodaysDealsPage() {
		ExtentListeners.test.log(Status.INFO, "Test Staretd for clickAndValidateTodaysDealsPage"  );
		amazonHomePage.validateTodaysDealsPage();
		Assert.assertEquals(driver.getTitle(), "Amazon.in - Today's Deals", "Deals Page Title Does not Match");
		
		ExtentListeners.test.log(Status.INFO, "Test completed  for clickAndValidateTodaysDealsPage"  );
	}

	@Test(priority = 3)
	public void enterAndValidateDeliveryAddressPincodeTest() {
		ExtentListeners.test.log(Status.INFO, "Test staretd  for enterAndValidateDeliveryAddressPincodeTest"  );
		amazonHomePage.enterDeliveryAddressPincode(prop.getProperty("pincode_loc"));
		Assert.assertEquals(amazonHomePage.enteredLocation.getText(), prop.getProperty("pincode_loc"),
				"Pincode Value does not Match");
		ExtentListeners.test.log(Status.INFO, "Test completed  for enterAndValidateDeliveryAddressPincodeTest"  );
	}

	@Test(priority = 4)
	public void searchProductTest() {
		ExtentListeners.test.log(Status.INFO, "Test started  for searchProductTest"  );
		String productSearchString = prop.getProperty("product_to_search");
		amazonHomePage.searchProduct(productSearchString);
		String validateTitle = "Amazon.in : " + productSearchString;
		Assert.assertEquals(driver.getTitle(), validateTitle, "Title does not match");
		ExtentListeners.test.log(Status.INFO, "Test completed  for searchProductTest"  );
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (driver != null) {
			driver.quit();
		} 
	}

 

}
