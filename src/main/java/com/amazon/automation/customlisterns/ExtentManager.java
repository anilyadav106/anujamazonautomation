package com.amazon.automation.customlisterns;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	/*
	 * This method to be used in ExtentListeners class to create instance of
	 * extent report.
	 */
	public static ExtentReports createReport(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		ExtentReports extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Anuj Alhans");
		extent.setSystemInfo("Organization", "Nagarro");
		extent.setSystemInfo("Build no", "NAGARRO-1234");

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Extent report Page Title");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Report for Amazon Testing Framework designed by AnilAnuj");
		htmlReporter.config().setCSS(".r-img { width: 50%; }");

		return extent;
	}

}
