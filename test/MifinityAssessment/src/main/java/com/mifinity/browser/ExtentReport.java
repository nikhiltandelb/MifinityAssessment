package com.mifinity.browser;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport {

	public static ExtentReports report = null;
	public static String extentreportpath = "";

	// To avoid external initialization
	private ExtentReport() {
		extentreportpath = System.getProperty("user.dir") + "//reports//index.html";
		report = new ExtentReports(extentreportpath);
		report.loadConfig(new File(System.getProperty("user.dir") + "//src//main//java//resources//extentreport.xml"));
	}
	
	

	public static void initialize() {
		ExtentReport report = new ExtentReport();
	}

}
